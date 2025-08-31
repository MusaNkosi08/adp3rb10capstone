import { useState, useEffect } from 'react'
import { API_BASE_URL } from '../api'
import { Card, CardContent, CardHeader, CardTitle } from './ui/card'
import { Button } from './ui/button'
import { Input } from './ui/input'
import { Badge } from './ui/badge'
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from './ui/select'
import { Search, Filter, Plus, Edit, Trash, BookOpen, Star } from 'lucide-react'
import { ImageWithFallback } from './figma/ImageWithFallback'

interface Book {
  id: string
  title: string
  author: string
  isbn: string
  category: string
  price: number
  stock: number
  description: string
  rating: number
  publishedYear: number | string
  publisher: string
  image?: string | null
}

export default function BookCatalog() {
  const [searchTerm, setSearchTerm] = useState('')
  const [categoryFilter, setCategoryFilter] = useState<string>('all')
  const [showAddModal, setShowAddModal] = useState(false)
  const [addForm, setAddForm] = useState({
    title: '',
    author: '',
    pages: '',
    genre: '',
    quantity: '',
    price: '',
    image: null as File | null
  })
  const [loading, setLoading] = useState(false)
  const [success, setSuccess] = useState('')
  const [error, setError] = useState('')
  const [books, setBooks] = useState<Book[]>([])

  const handleAddInput = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value, files } = e.target
    if (name === 'image' && files) {
      setAddForm({ ...addForm, image: files[0] })
    } else {
      setAddForm({ ...addForm, [name]: value })
    }
  }

  const handleAddSubmit = async (e: React.FormEvent) => {
    e.preventDefault()
    setLoading(true)
    setSuccess('')
    setError('')
    try {
      const formData = new FormData()
      formData.append('title', addForm.title)
      formData.append('author', addForm.author)
      formData.append('pages', addForm.pages)
      formData.append('genre', addForm.genre)
      formData.append('quantity', addForm.quantity)
      formData.append('price', addForm.price)
      if (addForm.image) formData.append('image', addForm.image)

      const response = await fetch(`${API_BASE_URL}/book/create`, {
        method: 'POST',
        body: formData
      })
      if (response.ok) {
        setSuccess('Book added successfully!')
        setAddForm({ title: '', author: '', pages: '', genre: '', quantity: '', price: '', image: null })
        setShowAddModal(false)
        // refresh books
        fetchBooks()
      } else {
        setError('Failed to add book: ' + (await response.text()))
      }
    } catch (err: any) {
      setError('Error: ' + err.message)
    }
    setLoading(false)
  }

  const fetchBooks = async () => {
    try {
      const response = await fetch(`${API_BASE_URL}/book/all`)
      if (response.ok) {
        const data = await response.json()
        setBooks(
          data.map((book: any) => ({
            id: book.isbn || book.id || '',
            title: book.title,
            author: book.author,
            isbn: book.isbn,
            category: book.genre || 'Unknown',
            price: book.price,
            stock: book.quantity,
            description: book.description || '',
            rating: book.rating || 0,
            publishedYear: book.publishedYear || '',
            publisher: book.publisher || '',
            image: book.image || null
          }))
        )
      }
    } catch (err) {
      console.error('Failed to fetch books:', err)
    }
  }

  useEffect(() => {
    fetchBooks()
  }, [])

  const categories = ['all', ...Array.from(new Set(books.map(book => book.category)))]

  const filteredBooks = books.filter(book => {
    const matchesSearch =
      book.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
      book.author.toLowerCase().includes(searchTerm.toLowerCase()) ||
      book.isbn.includes(searchTerm)
    const matchesCategory = categoryFilter === 'all' || book.category === categoryFilter
    return matchesSearch && matchesCategory
  })

  const getStockBadge = (stock: number) => {
    if (stock === 0) return <Badge variant="destructive">Out of Stock</Badge>
    if (stock <= 5) return <Badge variant="outline">Low Stock</Badge>
    return <Badge variant="secondary">In Stock</Badge>
  }

  const renderStars = (rating: number): JSX.Element[] => {
    const stars: JSX.Element[] = []
    const fullStars = Math.floor(rating)
    const hasHalfStar = rating % 1 !== 0

    for (let i = 0; i < fullStars; i++) {
      stars.push(<Star key={i} className="h-3 w-3 fill-yellow-400 text-yellow-400" />)
    }
    if (hasHalfStar) {
      stars.push(<Star key="half" className="h-3 w-3 text-yellow-400" />)
    }
    const emptyStars = 5 - Math.ceil(rating)
    for (let i = 0; i < emptyStars; i++) {
      stars.push(<Star key={`empty-${i}`} className="h-3 w-3 text-gray-300" />)
    }
    return stars
  }

  return (
    <div className="p-6">
      <div className="mb-8 flex items-center justify-between">
        <div>
          <h2 className="mb-2">Book Catalog</h2>
          <p className="text-muted-foreground">Manage your bookstore inventory and product details.</p>
        </div>
        <Button onClick={() => setShowAddModal(true)}>
          <Plus className="h-4 w-4 mr-2" />
          Add New Book
        </Button>
      </div>

      {/* Add Book Modal */}
      {showAddModal && (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-40">
          <div className="bg-white rounded-lg shadow-lg p-6 w-full max-w-lg">
            <h3 className="text-xl font-bold mb-4 text-orange-800">Add New Book</h3>
            <form className="space-y-4" onSubmit={handleAddSubmit} encType="multipart/form-data">
              <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                <div>
                  <label htmlFor="title" className="block text-sm font-medium text-orange-700">Title</label>
                  <input id="title" name="title" value={addForm.title} onChange={handleAddInput} required className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
                <div>
                  <label htmlFor="author" className="block text-sm font-medium text-orange-700">Author</label>
                  <input id="author" name="author" value={addForm.author} onChange={handleAddInput} required className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
                <div>
                  <label htmlFor="pages" className="block text-sm font-medium text-orange-700">Pages</label>
                  <input id="pages" name="pages" type="number" value={addForm.pages} onChange={handleAddInput} required className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
                <div>
                  <label htmlFor="genre" className="block text-sm font-medium text-orange-700">Genre</label>
                  <input id="genre" name="genre" value={addForm.genre} onChange={handleAddInput} required className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
                <div>
                  <label htmlFor="quantity" className="block text-sm font-medium text-orange-700">Quantity</label>
                  <input id="quantity" name="quantity" type="number" value={addForm.quantity} onChange={handleAddInput} required className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
                <div>
                  <label htmlFor="price" className="block text-sm font-medium text-orange-700">Price</label>
                  <input id="price" name="price" type="number" step="0.01" value={addForm.price} onChange={handleAddInput} required className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
                <div className="md:col-span-2">
                  <label htmlFor="image" className="block text-sm font-medium text-orange-700">Book Image (optional)</label>
                  <input id="image" name="image" type="file" accept="image/*" onChange={handleAddInput} className="border-orange-200 focus:border-orange-400 w-full px-3 py-2 rounded" />
                </div>
              </div>
              <div className="flex gap-2 mt-4">
                <Button type="submit" disabled={loading} className="flex-1 bg-gradient-to-r from-orange-500 to-amber-500 hover:from-orange-600 hover:to-amber-600">
                  {loading ? 'Adding...' : 'Add Book'}
                </Button>
                <Button type="button" variant="outline" onClick={() => setShowAddModal(false)} className="flex-1 text-orange-600 border-orange-200 hover:bg-orange-50">
                  Cancel
                </Button>
              </div>
              {success && <p className="text-green-600 mt-2">{success}</p>}
              {error && <p className="text-red-600 mt-2">{error}</p>}
            </form>
          </div>
        </div>
      )}

      {/* Filters */}
      <Card className="mb-6">
        <CardContent className="pt-6">
          <div className="flex gap-4 items-end">
            <div className="flex-1">
              <div className="relative">
                <Search className="absolute left-3 top-3 h-4 w-4 text-muted-foreground" />
                <Input
                  placeholder="Search books by title, author, or ISBN..."
                  value={searchTerm}
                  onChange={(e) => setSearchTerm(e.target.value)}
                  className="pl-9"
                />
              </div>
            </div>
            <div className="min-w-48">
              <Select value={categoryFilter} onValueChange={setCategoryFilter}>
                <SelectTrigger>
                  <Filter className="h-4 w-4 mr-2" />
                  <SelectValue />
                </SelectTrigger>
                <SelectContent>
                  {categories.map(category => (
                    <SelectItem key={category} value={category}>
                      {category === 'all' ? 'All Categories' : category}
                    </SelectItem>
                  ))}
                </SelectContent>
              </Select>
            </div>
          </div>
        </CardContent>
      </Card>

      {/* Books Grid */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {filteredBooks.map(book => (
          <Card key={book.id} className="overflow-hidden">
            <div className="aspect-[3/4] bg-muted relative">
              <ImageWithFallback
                src={book.image || '/api/placeholder/200/267'}
                alt={book.title}
                className="w-full h-full object-cover"
              />
              <div className="absolute top-2 right-2">{getStockBadge(book.stock)}</div>
            </div>
            <CardHeader className="pb-2">
              <div className="flex items-start justify-between gap-2">
                <div className="flex-1 min-w-0">
                  <CardTitle className="text-base line-clamp-2">{book.title}</CardTitle>
                  <p className="text-sm text-muted-foreground">{book.author}</p>
                </div>
                <div className="text-right">
                  <p className="font-semibold">${book.price}</p>
                </div>
              </div>
            </CardHeader>
            <CardContent className="pt-0">
              <div className="space-y-3">
                <div className="flex items-center justify-between text-sm">
                  <div className="flex items-center gap-1">
                    {renderStars(book.rating)}
                    <span className="text-muted-foreground ml-1">({book.rating})</span>
                  </div>
                  <Badge variant="outline" className="text-xs">
                    {book.category}
                  </Badge>
                </div>
                <div className="text-sm text-muted-foreground">
                  <p>ISBN: {book.isbn}</p>
                  <p>Stock: {book.stock} units</p>
                  <p>Published: {book.publishedYear}</p>
                </div>
                <p className="text-sm text-muted-foreground line-clamp-2">{book.description}</p>
                <div className="flex gap-2 pt-2">
                  <Button variant="outline" size="sm" className="flex-1">
                    <Edit className="h-4 w-4 mr-1" />
                    Edit
                  </Button>
                  <Button variant="outline" size="sm" className="flex-1">
                    <BookOpen className="h-4 w-4 mr-1" />
                    View
                  </Button>
                  <Button variant="outline" size="sm">
                    <Trash className="h-4 w-4" />
                  </Button>
                </div>
              </div>
            </CardContent>
          </Card>
        ))}
      </div>

      {filteredBooks.length === 0 && (
        <Card>
          <CardContent className="text-center py-12">
            <BookOpen className="h-12 w-12 mx-auto text-muted-foreground mb-4" />
            <h3 className="text-lg font-medium mb-2">No books found</h3>
            <p className="text-muted-foreground">Try adjusting your search terms or filters.</p>
          </CardContent>
        </Card>
      )}
    </div>
  )
}

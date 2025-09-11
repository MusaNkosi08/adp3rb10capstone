import { useState, useEffect } from 'react'
import { API_BASE_URL } from '../api'
import { Card, CardContent, CardHeader, CardTitle } from './ui/card'
import { Button } from './ui/button'
import { Input } from './ui/input'
import { Label } from './ui/label'
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from './ui/select'
import { Textarea } from './ui/textarea'
import { Badge } from './ui/badge'
import { Separator } from './ui/separator'
import { Plus, Minus, Search } from 'lucide-react'

interface OrderItem {
  id: string
  title: string
  author: string
  price: number
  quantity: number
  stock: number
}

export function OrderCreation() {
  const [orderItems, setOrderItems] = useState<OrderItem[]>([])
  const [searchTerm, setSearchTerm] = useState('')
  
  const [availableBooks, setAvailableBooks] = useState<OrderItem[]>([]);
  useEffect(() => {
    async function fetchAvailableBooks() {
      try {
        const response = await fetch(`${API_BASE_URL}/book/all`);
        if (response.ok) {
          const data = await response.json();
          setAvailableBooks(data.map((book: any) => ({
            id: book.id || book.isbn,
            title: book.title,
            author: book.author,
            price: book.price,
            quantity: 0,
            stock: book.quantity
          })));
        }
      } catch (err) {
        console.error('Failed to fetch available books:', err);
      }
    }
    fetchAvailableBooks();
  }, []);

  const filteredBooks = availableBooks.filter(book =>
    book.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
    book.author.toLowerCase().includes(searchTerm.toLowerCase())
  )

  const addToOrder = (book: OrderItem) => {
    const existingItem = orderItems.find(item => item.id === book.id)
    if (existingItem) {
      if (existingItem.quantity < book.stock) {
        setOrderItems(orderItems.map(item =>
          item.id === book.id ? { ...item, quantity: item.quantity + 1 } : item
        ))
      }
    } else {
      setOrderItems([...orderItems, { ...book, quantity: 1 }])
    }
  }

  const removeFromOrder = (bookId: string) => {
    const existingItem = orderItems.find(item => item.id === bookId)
    if (existingItem && existingItem.quantity > 1) {
      setOrderItems(orderItems.map(item =>
        item.id === bookId ? { ...item, quantity: item.quantity - 1 } : item
      ))
    } else {
      setOrderItems(orderItems.filter(item => item.id !== bookId))
    }
  }

  const totalAmount = orderItems.reduce((total, item) => total + (item.price * item.quantity), 0)

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault()
    // Handle order submission
    alert('Order created successfully!')
    setOrderItems([])
  }

  return (
    <div className="p-6">
      <div className="mb-8">
        <h2 className="mb-2">Create New Order</h2>
        <p className="text-muted-foreground">
          Create a new customer order by selecting books and filling in customer details.
        </p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {/* Book Selection */}
        <Card>
          <CardHeader>
            <CardTitle>Select Books</CardTitle>
            <div className="relative">
              <Search className="absolute left-3 top-3 h-4 w-4 text-muted-foreground" />
              <Input
                placeholder="Search books or authors..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="pl-9"
              />
            </div>
          </CardHeader>
          <CardContent>
            <div className="space-y-3 max-h-96 overflow-y-auto">
              {filteredBooks.map((book) => (
                <div key={book.id} className="flex items-center justify-between p-3 border border-border rounded-lg">
                  <div className="flex-1">
                    <p className="font-medium">{book.title}</p>
                    <p className="text-sm text-muted-foreground">{book.author}</p>
                    <div className="flex items-center gap-2 mt-1">
                      <span className="text-sm font-medium">${book.price}</span>
                      <Badge variant={book.stock > 5 ? 'secondary' : 'destructive'} className="text-xs">
                        {book.stock} in stock
                      </Badge>
                    </div>
                  </div>
                  <Button
                    onClick={() => addToOrder(book)}
                    disabled={book.stock === 0}
                    size="sm"
                  >
                    <Plus className="h-4 w-4" />
                  </Button>
                </div>
              ))}
            </div>
          </CardContent>
        </Card>

        {/* Order Details */}
        <div className="space-y-6">
          {/* Current Order */}
          <Card>
            <CardHeader>
              <CardTitle>Order Items</CardTitle>
            </CardHeader>
            <CardContent>
              {orderItems.length === 0 ? (
                <p className="text-muted-foreground text-center py-8">No items selected</p>
              ) : (
                <div className="space-y-3">
                  {orderItems.map((item) => (
                    <div key={item.id} className="flex items-center justify-between p-3 border border-border rounded-lg">
                      <div className="flex-1">
                        <p className="font-medium">{item.title}</p>
                        <p className="text-sm text-muted-foreground">{item.author}</p>
                      </div>
                      <div className="flex items-center gap-2">
                        <Button
                          variant="outline"
                          size="sm"
                          onClick={() => removeFromOrder(item.id)}
                        >
                          <Minus className="h-4 w-4" />
                        </Button>
                        <span className="min-w-8 text-center">{item.quantity}</span>
                        <Button
                          variant="outline"
                          size="sm"
                          onClick={() => addToOrder(item)}
                          disabled={item.quantity >= item.stock}
                        >
                          <Plus className="h-4 w-4" />
                        </Button>
                        <span className="min-w-16 text-right font-medium">
                          ${(item.price * item.quantity).toFixed(2)}
                        </span>
                      </div>
                    </div>
                  ))}
                  <Separator />
                  <div className="flex justify-between items-center text-lg font-semibold">
                    <span>Total:</span>
                    <span>${totalAmount.toFixed(2)}</span>
                  </div>
                </div>
              )}
            </CardContent>
          </Card>

          {/* Customer Information */}
          <Card>
            <CardHeader>
              <CardTitle>Customer Information</CardTitle>
            </CardHeader>
            <CardContent>
              <form onSubmit={handleSubmit} className="space-y-4">
                <div className="grid grid-cols-2 gap-4">
                  <div>
                    <Label htmlFor="firstName">First Name</Label>
                    <Input id="firstName" required />
                  </div>
                  <div>
                    <Label htmlFor="lastName">Last Name</Label>
                    <Input id="lastName" required />
                  </div>
                </div>
                
                <div>
                  <Label htmlFor="email">Email</Label>
                  <Input id="email" type="email" required />
                </div>
                
                <div>
                  <Label htmlFor="phone">Phone</Label>
                  <Input id="phone" type="tel" />
                </div>
                
                <div>
                  <Label htmlFor="address">Shipping Address</Label>
                  <Textarea id="address" required />
                </div>
                
                <div>
                  <Label htmlFor="paymentMethod">Payment Method</Label>
                  <Select required>
                    <SelectTrigger>
                      <SelectValue placeholder="Select payment method" />
                    </SelectTrigger>
                    <SelectContent>
                      <SelectItem value="credit-card">Credit Card</SelectItem>
                      <SelectItem value="debit-card">Debit Card</SelectItem>
                      <SelectItem value="paypal">PayPal</SelectItem>
                      <SelectItem value="cash-on-delivery">Cash on Delivery</SelectItem>
                    </SelectContent>
                  </Select>
                </div>
                
                <div>
                  <Label htmlFor="notes">Order Notes</Label>
                  <Textarea id="notes" placeholder="Any special instructions..." />
                </div>
                
                <Button 
                  type="submit" 
                  className="w-full" 
                  disabled={orderItems.length === 0}
                >
                  Create Order (${totalAmount.toFixed(2)})
                </Button>
              </form>
            </CardContent>
          </Card>
        </div>
      </div>
    </div>
  )
}
import { useState } from 'react'
import { API_BASE_URL } from '../../api'
import { Card, CardContent, CardHeader, CardTitle } from '../ui/card'
import { Button } from '../ui/button'
import { Input } from '../ui/input'
import { Label } from '../ui/label'
import { Separator } from '../ui/separator'
import { Badge } from '../ui/badge'
import { 
  Minus, 
  Plus, 
  Trash2, 
  ShoppingBag, 
  Heart,
  ArrowLeft,
  Coffee,
  Gift
} from 'lucide-react'
import { ImageWithFallback } from '../figma/ImageWithFallback'
import { CartItem } from '../CustomerApp'

interface ShoppingCartProps {
  items: CartItem[]
  onUpdateQuantity: (bookId: string, quantity: number) => void
  onRemoveItem: (bookId: string) => void
  onClearCart: () => void
  onBackToShopping: () => void
}

export function ShoppingCart({ 
  items, 
  onUpdateQuantity, 
  onRemoveItem, 
  onClearCart,
  onBackToShopping 
}: ShoppingCartProps) {
  const [isCheckingOut, setIsCheckingOut] = useState(false)
  const [orderComplete, setOrderComplete] = useState(false)

  const formatCurrency = (amount: number) => {
    return new Intl.NumberFormat('en-ZA', {
      style: 'currency',
      currency: 'ZAR',
      minimumFractionDigits: 2,
      maximumFractionDigits: 2,
    }).format(amount).replace('ZAR', 'R')
  }

  const subtotal = items.reduce((total, item) => total + (item.price * item.quantity), 0)
  const freeShippingThreshold = 650 // R650 for free shipping (equivalent to $35)
  const shipping = subtotal > freeShippingThreshold ? 0 : 89.99 // R89.99 shipping
  const tax = subtotal * 0.15 // 15% VAT for South Africa
  const total = subtotal + shipping + tax

  const [address, setAddress] = useState('')
  const [paymentMethod, setPaymentMethod] = useState('Standard Delivery')

  const handleCheckout = async () => {
    setIsCheckingOut(true)
    // Prepare payment payload
    const paymentPayload = {
      amount: total,
      status: 'Pending',
      transactionCode: '',
      method: paymentMethod
    }
    let paymentId = null
    try {
      // Save payment in DB
      const paymentRes = await fetch(`${API_BASE_URL}/payments/create`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(paymentPayload)
      })
      if (paymentRes.ok) {
        const payment = await paymentRes.json()
        paymentId = payment.paymentID || payment.id
      } else {
        alert('Payment failed: ' + (await paymentRes.text()))
        setIsCheckingOut(false)
        return
      }
      // Prepare order payload matching backend requirements
      const orderPayload = {
        customerId: 1, // Replace with actual customer ID from context/session
        // orderDate can be omitted, backend will set
        status: 'Pending',
        shippingAddress: address,
        paymentMethod,
        items: items.map(item => ({
          quantity: item.quantity,
          price: item.price,
          book: {
            isbn: (item as any).isbn ?? '',
            title: item.title,
            author: item.author,
            pages: (item as any).pages ?? 0,
            genre: (item as any).genre ?? '',
            quantity: (item as any).stock ?? item.quantity,
            price: item.price
          }
        })),
        payment: {
          amount: total,
          status: 'Pending',
          transactionCode: paymentId || '',
          method: paymentMethod
        }
      }
      const response = await fetch(`${API_BASE_URL}/orders/create`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(orderPayload)
      })
      if (response.ok) {
        setOrderComplete(true)
        onClearCart()
      } else {
        alert('Order failed: ' + (await response.text()))
      }
    } catch (err) {
      alert('Order error: ' + err)
    }
    setIsCheckingOut(false)
  }

  if (orderComplete) {
    return (
      <div className="max-w-2xl mx-auto">
        <Card className="border-green-200 bg-gradient-to-br from-green-50 to-emerald-50">
          <CardContent className="text-center py-12">
            <div className="flex items-center justify-center w-20 h-20 bg-gradient-to-br from-green-200 to-emerald-200 rounded-full mx-auto mb-6">
              <Gift className="w-10 h-10 text-green-600" />
            </div>
            <h2 className="text-2xl font-bold text-green-800 mb-4">Order Complete!</h2>
            <p className="text-green-700 mb-6">
              Your cozy books are on their way! Get ready for some warm reading sessions.
            </p>
            <div className="space-y-3">
              <Button 
                onClick={onBackToShopping}
                className="bg-gradient-to-r from-orange-500 to-amber-500 hover:from-orange-600 hover:to-amber-600"
              >
                <Coffee className="w-4 h-4 mr-2" />
                Continue Reading Adventure
              </Button>
            </div>
          </CardContent>
        </Card>
      </div>
    )
  }

  if (items.length === 0) {
    return (
      <div className="max-w-2xl mx-auto">
        <Card className="border-orange-100">
          <CardContent className="text-center py-12">
            <ShoppingBag className="h-16 w-16 mx-auto text-orange-300 mb-6" />
            <h2 className="text-2xl font-bold text-orange-800 mb-4">Your cart feels a bit lonely</h2>
            <p className="text-orange-600 mb-6">
              Add some cozy books to make it happy! Every book is waiting to give you a warm hug.
            </p>
            <Button 
              onClick={onBackToShopping}
              className="bg-gradient-to-r from-orange-500 to-amber-500 hover:from-orange-600 hover:to-amber-600"
            >
              <Coffee className="w-4 h-4 mr-2" />
              Browse Our Cozy Collection
            </Button>
          </CardContent>
        </Card>
      </div>
    )
  }

  return (
    <div className="max-w-6xl mx-auto">
      <div className="mb-6 flex items-center gap-4">
        <Button 
          variant="outline" 
          onClick={onBackToShopping}
          className="text-orange-600 border-orange-200 hover:bg-orange-50"
        >
          <ArrowLeft className="w-4 h-4 mr-2" />
          Continue Shopping
        </Button>
        <div>
          <h2 className="text-2xl font-bold text-orange-800">Your Cozy Cart</h2>
          <p className="text-orange-600">
            {items.length} {items.length === 1 ? 'book' : 'books'} ready to wrap you in warmth
          </p>
        </div>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Cart Items */}
        <div className="lg:col-span-2 space-y-4">
          {items.map((item) => (
            <Card key={item.id} className="border-orange-100">
              <CardContent className="p-4">
                <div className="flex gap-4">
                  <div className="w-20 h-28 bg-gradient-to-br from-orange-100 to-amber-100 rounded-lg flex-shrink-0">
                    <ImageWithFallback 
                      src="/api/placeholder/80/112"
                      alt={item.title}
                      className="w-full h-full object-cover rounded-lg"
                    />
                  </div>
                  
                  <div className="flex-1">
                    <div className="flex justify-between items-start mb-2">
                      <div>
                        <h4 className="font-medium text-orange-800">{item.title}</h4>
                        <p className="text-sm text-orange-600">{item.author}</p>
                      </div>
                      <Button
                        variant="ghost"
                        size="sm"
                        onClick={() => onRemoveItem(item.id)}
                        className="text-orange-400 hover:text-red-500 hover:bg-red-50"
                      >
                        <Trash2 className="w-4 h-4" />
                      </Button>
                    </div>
                    
                    <div className="flex items-center justify-between">
                      <div className="flex items-center gap-2">
                        <Button
                          variant="outline"
                          size="sm"
                          onClick={() => onUpdateQuantity(item.id, item.quantity - 1)}
                          disabled={item.quantity <= 1}
                          className="w-8 h-8 p-0 border-orange-200"
                        >
                          <Minus className="w-3 h-3" />
                        </Button>
                        <span className="w-8 text-center font-medium text-orange-800">
                          {item.quantity}
                        </span>
                        <Button
                          variant="outline"
                          size="sm"
                          onClick={() => onUpdateQuantity(item.id, item.quantity + 1)}
                          className="w-8 h-8 p-0 border-orange-200"
                        >
                          <Plus className="w-3 h-3" />
                        </Button>
                      </div>
                      
                      <div className="text-right">
                        <p className="font-medium text-orange-800">
                          {formatCurrency(item.price * item.quantity)}
                        </p>
                        <p className="text-sm text-orange-600">
                          {formatCurrency(item.price)} each
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              </CardContent>
            </Card>
          ))}
          
          <div className="flex justify-between items-center">
            <Button
              variant="outline"
              onClick={onClearCart}
              className="text-orange-600 border-orange-200 hover:bg-orange-50"
            >
              <Trash2 className="w-4 h-4 mr-2" />
              Clear Cart
            </Button>
          </div>
        </div>

        {/* Order Summary */}
        <div className="space-y-6">
          <Card className="border-orange-100 bg-gradient-to-br from-orange-50 to-amber-50">
            <CardHeader>
              <CardTitle className="text-orange-800">Order Summary</CardTitle>
            </CardHeader>
            <CardContent className="space-y-3">
              <div className="flex justify-between">
                <span className="text-orange-700">Subtotal</span>
                <span className="font-medium text-orange-800">{formatCurrency(subtotal)}</span>
              </div>
              
              <div className="flex justify-between">
                <span className="text-orange-700">Shipping</span>
                <div className="text-right">
                  {shipping === 0 ? (
                    <div>
                      <span className="font-medium text-green-600">Free</span>
                      <Badge variant="secondary" className="ml-2 text-xs">
                        R650+ orders
                      </Badge>
                    </div>
                  ) : (
                    <span className="font-medium text-orange-800">{formatCurrency(shipping)}</span>
                  )}
                </div>
              </div>
              
              <div className="flex justify-between">
                <span className="text-orange-700">VAT (15%)</span>
                <span className="font-medium text-orange-800">{formatCurrency(tax)}</span>
              </div>
              
              <Separator className="bg-orange-200" />
              
              <div className="flex justify-between text-lg">
                <span className="font-medium text-orange-800">Total</span>
                <span className="font-bold text-orange-800">{formatCurrency(total)}</span>
              </div>
              
              {subtotal < freeShippingThreshold && (
                <div className="bg-yellow-50 border border-yellow-200 rounded-lg p-3">
                  <p className="text-sm text-yellow-700">
                    Add {formatCurrency(freeShippingThreshold - subtotal)} more for free shipping!
                  </p>
                </div>
              )}
            </CardContent>
          </Card>

          <Card className="border-orange-100">
            <CardHeader>
              <CardTitle className="text-orange-800">Delivery Information</CardTitle>
            </CardHeader>
            <CardContent className="space-y-4">
              <div>
                <Label htmlFor="address">Delivery Address</Label>
                <Input
                  id="address"
                  placeholder="Where should we send your cozy books?"
                  className="border-orange-200 focus:border-orange-400"
                  value={address}
                  onChange={e => setAddress(e.target.value)}
                />
              </div>
              
              <div>
                <Label>Delivery Option</Label>
                <div className="space-y-2 mt-2">
                  <div className="flex items-center gap-2">
                    <input type="radio" name="delivery" checked={paymentMethod === 'Standard Delivery'} onChange={() => setPaymentMethod('Standard Delivery')} />
                    <label className="text-sm text-orange-700">
                      Standard Delivery (5-7 days) - 
                      {shipping === 0 ? ' Free' : ` ${formatCurrency(shipping)}`}
                    </label>
                  </div>
                  <div className="flex items-center gap-2">
                    <input type="radio" name="delivery" checked={paymentMethod === 'Express Delivery'} onChange={() => setPaymentMethod('Express Delivery')} />
                    <label className="text-sm text-orange-700">
                      Express Delivery (2-3 days) - R179.99
                    </label>
                  </div>
                </div>
              </div>
            </CardContent>
          </Card>

          <Button
            onClick={handleCheckout}
            disabled={isCheckingOut}
            className="w-full bg-gradient-to-r from-orange-500 to-amber-500 hover:from-orange-600 hover:to-amber-600 text-white text-lg py-6"
          >
            {isCheckingOut ? (
              <div className="flex items-center gap-2">
                <div className="w-4 h-4 border-2 border-white border-t-transparent rounded-full animate-spin" />
                Processing your cozy order...
              </div>
            ) : (
              <div className="flex items-center gap-2">
                <Heart className="w-5 h-5" />
                Complete Order - {formatCurrency(total)}
              </div>
            )}
          </Button>
        </div>
      </div>
    </div>
  )
}
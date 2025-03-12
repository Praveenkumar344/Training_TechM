import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({ providedIn: 'root' })
export class CartService {
  private cart = new BehaviorSubject<any[]>([]);
  cart$ = this.cart.asObservable();
  private apiUrl = 'http://localhost:4500/cart'; // Change this if your API is different

  constructor(private http: HttpClient) {}

  addToCart(item: any) {
    const currentCart = this.cart.value;
    this.cart.next([...currentCart, item]); // Updates local state

    // **Save to API**
    this.http.post(this.apiUrl, item).subscribe({
      next: () => console.log('Item added to cart API'),
      error: (err) => console.error('Error adding to cart:', err),
    });
  }
}

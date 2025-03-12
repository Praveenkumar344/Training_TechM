import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent {
  order = { name: '', address: '', phone: '', email: '' };
  apiUrl = 'http://localhost:4500/orders'; // Change if needed

  constructor(private http: HttpClient) {}

  placeOrder(form: any) {
    if (form.valid) {
      this.http.post(this.apiUrl, this.order).subscribe({
        next: () => alert('Order placed successfully!'),
        error: (err) => console.error('Order failed:', err),
      });
      form.reset();
    }
  }
}

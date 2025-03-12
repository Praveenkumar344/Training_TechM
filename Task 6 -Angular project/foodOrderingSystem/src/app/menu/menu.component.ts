import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  menuItems: any[] = [];    
  
  minPrice: number = 0;
  maxPrice: number = 1000;                                                                    

  constructor(private cartService: CartService, private http: HttpClient) {}

  ngOnInit() {
    this.http.get<any[]>('http://localhost:4500/menu').subscribe(data => { 
      this.menuItems = data;
    });
  }

  addToCart(item: any) {
    this.cartService.addToCart(item);
  }
} 
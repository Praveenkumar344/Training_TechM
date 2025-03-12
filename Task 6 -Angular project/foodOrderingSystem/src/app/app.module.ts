import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { FoodItemComponent } from './food-item/food-item.component';
import { CartService } from './services/cart.service';
import { OrderSummaryComponent } from './order-summary/order-summary.component';
import { OrderComponent } from './order/order.component';
import { PriceFilterPipe } from './pipes/price-filter.pipe';

const routes: Routes = [
  { path: 'menu', component: MenuComponent },
  { path: 'order-summary', component: OrderSummaryComponent },
  { path: 'place-order', component: OrderComponent },
  { path: '', redirectTo: '/menu', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    FoodItemComponent,
    OrderSummaryComponent,
    OrderComponent,
    PriceFilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [CartService],
  bootstrap: [AppComponent]
})
export class AppModule { }
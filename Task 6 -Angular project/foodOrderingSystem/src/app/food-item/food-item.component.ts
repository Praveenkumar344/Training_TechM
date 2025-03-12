import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-food-item',
  templateUrl: './food-item.component.html',
  styleUrls: ['./food-item.component.css']  
})
export class FoodItemComponent {
  @Input() item: any;
  @Output() addItem = new EventEmitter<any>();

  addItemToCart() {
    this.addItem.emit(this.item);
  }
}

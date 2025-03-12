import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'priceFilter'
})
export class PriceFilterPipe implements PipeTransform {
  transform(items: any[], minPrice: number, maxPrice: number): any[] {
    if (!items || items.length === 0) return [];
    if (!minPrice && !maxPrice) return items;

    return items.filter(item => {
      const price = item.price;
      return (!minPrice || price >= minPrice) && (!maxPrice || price <= maxPrice);
    });
  }
}

import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ProductsPage } from '../products/products';

@Component({
  selector: 'page-cart',
  templateUrl: 'cart.html'
})
export class CartPage {

  constructor(public navCtrl: NavController) {
  }
  goToProductos(params){
    if (!params) params = {};
    this.navCtrl.push(ProductsPage);
  }
}

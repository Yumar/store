import { UserDetailsPage } from './../user-details/user-details';
import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { ProductsPage } from '../products/products';
import { CartPage } from '../cart/cart';

@Component({
  selector: 'page-tabs-controller',
  templateUrl: 'tabs-controller.html'
})
export class TabsControllerPage {

  tab1Root: any = ProductsPage;
  tab2Root: any = CartPage;
  tab3Root: any = UserDetailsPage;
  constructor(public navCtrl: NavController) {
  }
  
}

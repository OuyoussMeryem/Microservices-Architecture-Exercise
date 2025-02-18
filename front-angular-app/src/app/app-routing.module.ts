import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./products/products.component";
import {CustomersComponent} from "./customers/customers.component";
import {OrdersComponent} from "./orders/orders.component";
import {OrderDetailComponent} from "./order-detail/order-detail.component";


const routes: Routes = [
  {path:"products",component:ProductsComponent},
  {path:"customers",component:CustomersComponent},
  {path:"orders/:customerId",component:OrdersComponent},
  {path:"orderDetail/:orderId",component:OrderDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

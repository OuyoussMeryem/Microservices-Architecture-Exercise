import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.css'
})
export class OrdersComponent implements OnInit{

  customerId!:number;
  orders!:any;


  constructor(private http:HttpClient,private activatedRoute:ActivatedRoute,private router:Router) {
    this.customerId=activatedRoute.snapshot.params["customerId"];
  }
  ngOnInit(): void {

    this.http.get("http://localhost:9999/order-service/orders/search/byCustomerId?projection=fullOrder&customerId="+this.customerId).subscribe({
      next:(data)=>{
        this.orders=data;
        console.log(this.orders._embedded.orders);
      },
      error:(err)=>{

      }
    })
  }

  detailsOrder(o: any) {
    this.router.navigateByUrl("orderDetail/"+o.id);

  }
}

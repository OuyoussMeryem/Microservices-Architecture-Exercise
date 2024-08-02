import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-order-detail',
  templateUrl: './order-detail.component.html',
  styleUrl: './order-detail.component.css'
})
export class OrderDetailComponent implements OnInit{
  productItemsList!:any;
  customerDetail!:any;
  orderId!:number;
  public orderDetails!:any;

  constructor(private http:HttpClient,private activatedRoute:ActivatedRoute) {
    this.orderId=activatedRoute.snapshot.params["orderId"];
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/order-service/fullOrder/"+this.orderId).subscribe({
      next:(data)=>{
        console.log(data);
        this.orderDetails=data;
        this.customerDetail=this.orderDetails.customer;
        this.productItemsList=this.orderDetails.productItems;
        console.log(this.customerDetail);
        console.log(this.productItemsList);

      },
      error:(err)=>{

      }
    });
  }

}

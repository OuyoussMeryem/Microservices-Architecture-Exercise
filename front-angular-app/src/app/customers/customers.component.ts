import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  public customers!:any;
  constructor(private http:HttpClient,private router:Router) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/customer-service/customers?projection=fullname").subscribe({
      next:(data)=>{
        this.customers=data;
        console.log(this.customers)
      }
    })
  }

  getOrders(c: any) {
  this.router.navigateByUrl("orders/"+c.id);
  }
}

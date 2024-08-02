import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent implements OnInit{
  public products!:any;
  constructor(private http:HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:9999/inventory-service/products?projection=fullname").subscribe({
      next:(data)=>{
        this.products=data;
        console.log(this.products)
      },
      error:(err)=>{

      }
      }
    )
  }

}

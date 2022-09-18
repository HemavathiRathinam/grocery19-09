import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Payment } from 'src/app/Payment';
import { UserApiService } from 'src/app/SignupLogin/user-api.service';
import { User } from 'src/app/user';
import { PaymentService } from 'src/app/User/service/payment.service';
import { category } from '../category';
import { product } from '../product';
import { CategoryService } from '../service/category.service';
import { ProductsService } from '../service/products.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  public productdetails:product[]=[];
  public categorydetails: category[] = [];
  public userdetails:User[] = [];
  public orderdetails:Payment[] = [];
  constructor(private productservice:ProductsService,private categoryservice: CategoryService,
    private api:UserApiService,private api1:PaymentService) { }
  get totalRows1(): number {
    return this.categorydetails.length;
  }
  get totalRows(): number {
    return this.productdetails.length;
  }
  get totalRows2(): number {
    return this.userdetails.length;
  }
  get totalRows3(): number {
    return this.orderdetails.length;
  }
  public getProducts():void{
    this.productservice.getProducts().subscribe(
      (response: product[]) => {
       this.productdetails=response;
 
      },(error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  public getCategory():void{
    this.categoryservice.getCategory().subscribe(
      (response: category[]) => {
       this.categorydetails=response;
      },(error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  public getUsers():void{
    this.api.getUser().subscribe(
      (response: User[]) => {
       this.userdetails=response;
      },(error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  public getOrder():void{
    this.api1.getOrders().subscribe(
      (response: Payment[]) => {
       this.orderdetails=response;
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }
  ngOnInit(): void {
    this.getProducts();
    this.getCategory();
    this.getUsers();
    this.getOrder();
  }

}

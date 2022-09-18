import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { PaymentService } from '../service/payment.service';
import { User } from 'src/app/user';
import { Payment } from 'src/app/Payment';
import { UserApiService } from 'src/app/SignupLogin/user-api.service';
import { SharedService } from 'src/app/shared.service';
import { addtocart } from '../addtocart';
import { AddcartService } from '../service/addcart.service';
import { R3SelectorScopeMode } from '@angular/compiler';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  public paymentForm!:FormGroup
  user!:User;
  t:any;
  
  payment!:Payment[];
  users!:User[];
  addtocarts!:addtocart;
  id!: any;
  emailId:any;
  userProfile!: FormGroup;
  constructor(private formBuilder:FormBuilder,private router:Router,private api:PaymentService,
    private api1:UserApiService,private sharedservice:SharedService,private addcartservice:AddcartService) {

  

   }

  ngOnInit(): void {
    this.id=sessionStorage.getItem('uid');
    this.emailId=sessionStorage.getItem('uemailId');
    this.paymentForm= this.formBuilder.group({
      username: new FormControl('', Validators.required),
      userEmail:new FormControl(this.emailId, Validators.required),
      phoneNumber:new FormControl('', Validators.required),
      address:new FormControl('', Validators.required),
      city:new FormControl('', Validators.required),
      state:new FormControl('', Validators.required),
      pincode:new FormControl('', Validators.required),
      paymentType:new FormControl('', Validators.required),
      amount:new FormControl('', Validators.required),
      orderDate: new FormControl((new Date()).toISOString().substring(0,10)),
      //addToCartModel_new:this.addtocart
     
    });
    
   
    this.showData();
    // this.tot=sessionStorage.getItem('t');
    this.t=this.sharedservice.getTot();
    console.log("get",this.t);
  }
  showData(){
    this.api1.getUserData(this.id).subscribe({
      next:(response:User)=>{
       
        console.log(response);
        this.user=response;
        this.paymentForm.setValue(response);
        
        this.paymentForm.disable();
  
  },
  error:()=>{
    alert("Error while fetching records")
  }
  });
   }

res!:Payment; carid!:number;
addToCartde:addtocart[]=[];

//adding payment
c:any;
  public success(paymentForm: NgForm): void{
    this.res=paymentForm.value;
    console.log("inside success",this.res);
    let cartt=this.sharedservice.getcart();
    this.res.addToCartModel_new=cartt;
    console.log("after acrt",this.res);
    this.api.addOrders(this.res).subscribe({
      
      next:(response:Payment)=>{
      
        alert("Order placed successfully");
        console.log(response);
        // this.c=response.addToCartModel_new;
        // sessionStorage.setItem('d',this.c);
        for(let x of response.addToCartModel_new){
            console.log("inside forloop");
            this.carid=x.cartId;
            
            this.addcartservice.deleteByid(this.carid).subscribe(
              (data)=>
              {  
                  console.log("Succesfully deleted",this.carid,x);
                  
              })
           
        }
        
        
        paymentForm.reset();
        this.router.navigate(['home'])
        
      },
      error:()=>{
        alert("Error while adding records")
      }
    });


  }

  
}

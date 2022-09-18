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
        this.paymentForm.disable()
  
  
  },
  error:()=>{
    alert("Error while fetching records")
  }
  });
   }
// isPurchased:boolean=false;
arr:any
addToCartde:addtocart[]=[];
  public success(paymentForm: NgForm): void{
    
    this.api.addOrders(paymentForm.value).subscribe({
      
      next:(response:Payment)=>{
        //console.log(this.addcartservice.getUserData(this.id))
        // this.addcartservice.getUserData(this.id).subscribe({
        //   next:(res:addtocart[])=>{
        //      console.log("before",res);
        //      this.addToCartde=res;
        //     //  for(let c of res){
        //     //   c.purchased=1
        //     //   this.addcartservice.updateProduct(c);
        //     //  }
        //     //  console.log("after",res);
            
        //   }
        // })
        let res=this.sharedservice.getcart();
    console.log(res);
    for(let x of res){
       this.addToCartde.push(x);
    }
    response.addToCartModel_new=this.addToCartde;
    console.log(this.addToCartde);
    // response.addToCartModel_new=res;
    // console.log(response.addToCartModel_new)
        
        
      
        alert("Order placed successfully");
        console.log(response);
        // this.isPurchased=true;
        // sessionStorage.setItem('pur',JSON.stringify(this.isPurchased));
      //   console.log("before",this.addToCartde);
      //   for(let i of this.addToCartde){
      //     console.log(i);
      //     i.purchased=1; 
      //   }
      //  console.log("after",this.addToCartde);
      //  this.sharedservice.setpurchase(this.addToCartde);
        paymentForm.reset();
        this.router.navigate(['home'])
        
      },
      error:()=>{
        alert("Error while adding records")
      }
    });


  }

  
}

import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { UserApiService } from 'src/app/SignupLogin/user-api.service';
import { User } from 'src/app/user';
import { review } from '../review';


import { ReviewService } from '../service/review.service';

@Component({
  selector: 'app-reviewform',
  templateUrl: './reviewform.component.html',
  styleUrls: ['./reviewform.component.css']
})
export class ReviewformComponent implements OnInit {
  user!:User;
  go(){
		this.route.navigate(['user/Review']); 
	}
 
  
  constructor(private reviewservice:ReviewService,private route:Router,private api1:UserApiService) { }
  public onAddReview(addForm: NgForm): void{
    this.go();
    this.reviewservice.addReview(addForm.value).subscribe(
      (response: review)=>{
        console.log(response);
      },
      (error: HttpErrorResponse)=>{
        alert(error.message);
      }
      );
  }
  showData(){
    this.api1.getUserData(this.id).subscribe({
      next:(response:User)=>{
       
        console.log(response);
        this.user=response;
        // this.paymentForm.setValue(response);
        
        // this.paymentForm.disable();
  
  }
})
  }
  id!: any;usernam!:any
  ngOnInit(): void {
    this.id=sessionStorage.getItem('uid');
    this.usernam=sessionStorage.getItem('uname')
    this.showData();
    
  }

}

import { Component, OnInit } from '@angular/core';
import { ReviewService } from '../service/review.service';
import { review } from '../review';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {
  public reviewdetails: review[] = [];
  public rev: any;
  reviewsupdate:any={
    reviewId:"",
    name:"",
    feedback:"",
    rating:""
   }
   isLoggedIn = false;
  user :any ;
  review:any;
  constructor(private reviewservice:ReviewService) { }

  public getReview():void{
    this.reviewservice.getReview().subscribe(
      (response: review[]) => {
       this.reviewdetails=response;
       console.log(this.reviewdetails)
      },(error: HttpErrorResponse)=>{
        alert(error.message);
      }
    );
  }

  // public getreviewbyname()
  // {
    
  //   this.reviewservice.getreviewbyname(this.user.username).subscribe(
  //     (response: any) => {
  //       this.rev=response;
  //      },(error: HttpErrorResponse)=>{
  //        alert("Your review not found! Add your review");
  //      }
  //   );
  // }

  displayStyle="none";
  openPopup(Addon:any) {
    this.displayStyle = "block";
    this.reviewsupdate=Addon;
  }
  close()
  {
    this.displayStyle = "none";
  }
  register()
  {
    this.reviewservice.updateReview(this.reviewsupdate).subscribe(data=>
      {
        console.log(data);
      })
  }

  delete(Addon:any)
  {
    this.reviewservice.deleteByid(Addon.review_id).subscribe(
      (data)=>
      {
          console.log("Succesfully deleted");
          this.getReview();
      })
  }
  
usernam!:any
  ngOnInit(): void {
    this.usernam=sessionStorage.getItem('uname')
    this.getReview();
  }

}

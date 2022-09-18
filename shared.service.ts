import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  prod:[]=[];
  tot:any;
  puchase:[]=[];
  car:any;
  proo:[]=[];
  setproductstodisplay(data:any){
    this.proo=data
    console.log("inside setter",this.proo)

  }
  getproductstodisplay(){
    return this.proo;
  }
  setPro(data: any){
    this.prod=data;
  }
  setpurchase(data:any){
    this.puchase=data;
  }
  setTot(data: any){
    this.tot=data;
    console.log(this.tot);
  }
  getpurchase(){
    return this.puchase;
  }
  getPro(){
    return this.prod;
  }
  getTot(){
    return this.tot;
  }
  setcart(data:any){
    this.car=data;
  }
  getcart(){
    return this.car;
  }
  constructor() { }
}

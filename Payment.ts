import { addtocart } from "./User/addtocart";

export class Payment {

  

    id!: number;
    username!: string;
    userEmail!: string;
    phoneNumber!: string;
    address!: string;
    city!: string;
    state!: string;
    paymentType!: string;
    amount!: number;
    orderDate!:string;
    addToCartModel_new!:addtocart[];

   
    
  }
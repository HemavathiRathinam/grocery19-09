package com.demo.grocery.controller;

import com.demo.grocery.model.AddToCartModel;
import com.demo.grocery.model.AddToCartModel_New;
import com.demo.grocery.service.AddtocartService;
import com.demo.grocery.service.AddtocartService_New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user_new")
public class AddtocartController_New {

    @Autowired
    private final AddtocartService_New addtocartService;


    public AddtocartController_New(AddtocartService_New addtocartService) {
        this.addtocartService = addtocartService;
    }
    @GetMapping("/getcart")
    public ResponseEntity<List<AddToCartModel_New>> getcart(){
        List<AddToCartModel_New> productModels=addtocartService.findAllcartModel();
        //System.out.println(new ResponseEntity(productModels, HttpStatus.OK));
        return new ResponseEntity<>(productModels, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<List<AddToCartModel_New>> getUserById(@PathVariable("id") int id){
        List<AddToCartModel_New> user=addtocartService.findUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    //        @GetMapping("/products/{prodName}")
//        public ResponseEntity<List<ProductModel>> getProductByName(@PathVariable("prodName") String prodName){
//            ProductModel productModels=productService.findProductModelByName(prodName);
//            return new ResponseEntity(productModels, HttpStatus.OK);
//        }
    @PostMapping("/addtocart")
    public ResponseEntity<AddToCartModel_New> addProduct(@RequestBody AddToCartModel_New data){
        AddToCartModel_New newProductModel=addtocartService.addtocart(data);
        return new ResponseEntity(newProductModel, HttpStatus.CREATED);
    }


    @PutMapping("/updateCart")
    public AddToCartModel_New updateProduct(@RequestBody AddToCartModel_New add)
    {

        return addtocartService.update(add);
    }
    @DeleteMapping("/deleteCart/{cartId}")
    public void deleteProduct(@PathVariable("cartId") int cartId)
    {
       addtocartService.deleteProduct(cartId);
    }
}

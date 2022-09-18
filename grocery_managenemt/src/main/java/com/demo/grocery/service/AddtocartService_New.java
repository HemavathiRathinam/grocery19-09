package com.demo.grocery.service;

import com.demo.grocery.model.AddToCartModel;
import com.demo.grocery.model.AddToCartModel_New;
import com.demo.grocery.repository.AddtocartRepo_New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AddtocartService_New {
    private static AddtocartRepo_New addtocartRepo=null;

    @Autowired
    public AddtocartService_New(AddtocartRepo_New addtocartRepo) {
        this.addtocartRepo=addtocartRepo;
    }

    public static AddToCartModel_New addtocart(AddToCartModel_New data){
        return addtocartRepo.save(data);

    }
    public static List<AddToCartModel_New> findAllcartModel(){

        return addtocartRepo.findAll();
    }
    public List<AddToCartModel_New> findUserById(int id){
        return addtocartRepo.findUserById(id);
                //.orElseThrow(()-> new UserNotFoundException("User by id "+id+" was not found"));
    }

//    public static ProductModel findProductModelByName(String prodName){
//        return productRepository.findProductModelByName(prodName).
//                orElseThrow(()-> new ProductNotFoundException("product not found"));
//    }

    public AddToCartModel_New update(AddToCartModel_New prod)
    {
        int cartId=prod.getCartId();
        AddToCartModel_New add=addtocartRepo.findById(cartId).get();
        add.setUsername(prod.getUsername());
        add.setProdName(prod.getProdName());
        add.setProdPrice(prod.getProdPrice());
        add.setProdquantity(prod.getProdquantity());
        add.setProdWeight(prod.getProdWeight());
        add.setProdImg(prod.getProdImg());
        add.setSubtotal(prod.getSubtotal());
        return addtocartRepo.save(add);
    }

    public void deleteProduct(int cartId)
    {

        addtocartRepo.deleteById(cartId);
    }
}

package com.demo.grocery.repository;

import com.demo.grocery.model.AddToCartModel;
import com.demo.grocery.model.AddToCartModel_New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddtocartRepo_New extends JpaRepository<AddToCartModel_New, Integer> {



     List<AddToCartModel_New> findUserById(int id);
}

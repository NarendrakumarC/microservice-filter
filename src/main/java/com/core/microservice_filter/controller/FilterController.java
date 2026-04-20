package com.core.microservice_filter.controller;

import com.core.microservice_filter.dto.FilteredProducts;
import com.core.microservice_filter.dto.SortedProducts;
import com.core.microservice_filter.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;

@RestController
public class FilterController {

    @Autowired
    private ProductService productService;

    @CrossOrigin
    @GetMapping("/filter/price/{initial_price}/{final_price}")
    private ResponseEntity< ArrayList<FilteredProducts> > filtered_books(@PathVariable("initial_price") int init_price , @PathVariable("final_price") int final_price)
    {
        try {
            ArrayList<FilteredProducts> books = productService.filterByPrice(init_price, final_price);
            if(books.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<ArrayList<FilteredProducts>>(books, HttpStatus.OK);

        }catch(Exception E)
        {
            System.out.println("Error encountered : "+E.getMessage());
            return new ResponseEntity<ArrayList<FilteredProducts>>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping("/sort/price")
    private ResponseEntity<SortedProducts[]> sorted_books()
    {
        try {
            SortedProducts[] ans=productService.sortByPrice();
            if(ans.length==0){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<SortedProducts[]>(ans, HttpStatus.OK);

        }catch(Exception E) {
            System.out.println("Error encountered : "+E.getMessage());
            return new ResponseEntity<SortedProducts[]>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test")
    public String testBackend(){
        return "Backend is working fine!";
    }
}

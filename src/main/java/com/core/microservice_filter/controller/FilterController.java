package com.core.microservice_filter.controller;

import com.core.microservice_filter.dto.FilteredProducts;
import com.core.microservice_filter.dto.SortedProducts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class FilterController {

    final String uri = "https://jsonmock.hackerrank.com/api/inventory";
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(uri, String.class);
    JSONObject root = new JSONObject(result);
    JSONArray data = root.getJSONArray("data");

    private JSONArray fetchProducts(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JSONObject root = new JSONObject(result);
        JSONArray data = root.getJSONArray("data");
        return data;
    }

    @CrossOrigin
    @GetMapping("/filter/price/{initial_price}/{final_price}")
    private ResponseEntity< ArrayList<FilteredProducts> > filtered_books(@PathVariable("initial_price") int init_price , @PathVariable("final_price") int final_price)
    {
        try {
            ArrayList<FilteredProducts> books = new ArrayList<FilteredProducts>();
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
            SortedProducts[] ans=new SortedProducts[data.length()];

            return new ResponseEntity<SortedProducts[]>(ans, HttpStatus.OK);
        }catch(Exception E) {
            System.out.println("Error encountered : "+E.getMessage());
            return new ResponseEntity<SortedProducts[]>(HttpStatus.NOT_FOUND);
        }
    }
}

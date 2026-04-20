package com.core.microservice_filter.service;

import com.core.microservice_filter.dto.FilteredProducts;
import com.core.microservice_filter.dto.SortedProducts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    // Filter products by price range
    public ArrayList<FilteredProducts> filterByPrice(int min, int max, JSONArray data){
        ArrayList<FilteredProducts> result = new ArrayList<FilteredProducts>();
        for(int i=0;i<data.length();i++){
            JSONObject obj = data.getJSONObject(i);
            int price = obj.getInt("price");
            if(price>=min && price<=max){
                result.add(new FilteredProducts(obj.getString("barcode")));
        }
    }
        return result;
    }

    // Sort products by price
    public SortedProducts[] sortByPrice(JSONArray data) {
        List<JSONObject> products = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            products.add(data.getJSONObject(i));
        }
        products.sort(Comparator.comparingInt(o -> o.getInt("price")));
        SortedProducts[] result = new SortedProducts[products.size()];
        for (int i = 0; i < products.size(); i++) {
            result[i] = new SortedProducts(products.get(i).getString("barcode"));
        }
        return result;
    }
}

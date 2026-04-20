package com.core.microservice_filter.service;

import com.core.microservice_filter.dto.FilteredProducts;
import com.core.microservice_filter.dto.SortedProducts;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    final String uri = "https://jsonmock.hackerrank.com/api/inventory";

    private JSONArray fetchProducts(){
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        JSONObject root = new JSONObject(result);
        JSONArray data = root.getJSONArray("data");
        return data;
    }

    // Filter products by price range
    public ArrayList<FilteredProducts> filterByPrice(int min, int max){
        ArrayList<FilteredProducts> result = new ArrayList<FilteredProducts>();
        JSONArray data = fetchProducts();
        for(int i=0;i<data.length();i++){
            JSONObject obj = data.getJSONObject(i);
            int price = obj.getInt("price");
            if(price>=min && price<=max){
                result.add(new FilteredProducts(obj.getString("barcode"),
                        obj.getString("item"),
                        obj.getString("category"),
                        price, obj.getInt("discount"),
                        obj.getInt("available")));
        }
    }
        return result;
    }

    // Sort products by price
    public SortedProducts[] sortByPrice() {
        JSONArray data = fetchProducts();
        List<JSONObject> products = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            products.add(data.getJSONObject(i));
        }
        products.sort(Comparator.comparingInt(o -> o.getInt("price")));
        SortedProducts[] result = new SortedProducts[products.size()];
        for (int i = 0; i < products.size(); i++) {
            result[i] = new SortedProducts(products.get(i).getString("barcode"),
                    products.get(i).getString("item"),
                    products.get(i).getString("category"),
                    products.get(i).getInt("price"),
                    products.get(i).getInt("discount"),
                    products.get(i).getInt("available"));
        }
        return result;
    }
}

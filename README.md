# Springboot microservice-filter
Implement REST-APIs to perform filter and sort operation on collection of products
Given JSON entry
barcode : the unique id of the product(String)
price : the price of the product(Integer)
discount : the discount% available on the product(Integer)
available : the availability status of the product (0 or 1)
     {
      "barcode": "74001755",
      "item": "Ball Gown",
      "category": "Full Body Outfits",
      "price": 785,
      "discount": 7,
      "available": 1
    }
Implement the below
GET Request
/filter/price/{initial_range}/{final_range}
Return the collection of all products whose price between the initial and final range supplied
The response code is 200 and the response body is array of products, In case there is no such product return status code 400

GET request
/sort/price
Return a collection of all product sorted by their pricing
The response code is 200, and the response body is array product names sorted in ascending order of prices









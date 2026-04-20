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

NOTE :
How to import SSL certificate in Java ?
Since we are calling external API to fetch the product details,
https://jsonmock.hackerrank.com/api/inventory
we need to import the SSL certificate of the API in our Java keystore. This can be done using the following command:
1. openssl s_client -connect jsonmock.hackerrank.com:443 -showcerts
2. Copy the certificate from the output and save it in a file named "hackerrank.crt"
3. Import the certificate into Java keystore using the following command:
4. keytool -importcert -alias jsonmock-hackerrank -file C:\Narendra_Workspace\microservice-filter\src\main\resources\certs\hackerrank.crt -keystore "C:\Users\narenc\.jdks\jbr-21.0.6\lib\security\cacerts"
5. Enter the keystore password when prompted (default is "changeit") and confirm the import. After this, you should be able to make HTTPS requests to the API without SSL errors.\
6. Note: Make sure to replace the paths in the commands with the actual paths on your system.
7. After importing the certificate, you can run your Spring Boot application and it should be able to fetch the product details from the external API without any SSL issues.

Test Cases
GET request /filter/price/500/1000
Response Code: 200
Response Body: List of products with price between 500 and 1000

GET request /price/sort
Response Code: 200
Response Body: List of product names sorted by price in ascending order







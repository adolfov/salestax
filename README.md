# salestax
java coding problem - calculate the sales tax for different products

# how to run
./mvnw spring-boot:run

# how to test
- use a rest client to send a POST request to http://localhost:8080/receipt

sample request 1:
```json
{
 "items": [
  {
   "quantity": 1,
   "product": {
     "name": "book",
     "price": 12.49,
     "exempt": true
    }
  },
  {
   "quantity": 1,
   "product": {
     "name": "music CD",
     "price": 14.99
    }
  },
  {
   "quantity": 1,
   "product": {
     "name": "book",
     "price": 0.85,
     "exempt": true
    }
  }
 ]
}
```
sample request 2:
```json
{
 "items": [
  {
   "quantity": 1,
   "product": {
     "name": "box of chocolates",
     "price": 10.00,
     "exempt": true,
     "imported": true
    }
  },
  {
   "quantity": 1,
   "product": {
     "name": "bottle of perfume",
     "price": 47.50,
     "imported": true
    }
  }
 ]
}
```

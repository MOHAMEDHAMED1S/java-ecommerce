# Ecommerce  Fawry Challenge (Java)
Sorry I didn't know the repo was private 🙏 I changed it to public.

## usage example
```java
cart.add(cheese, 2);
cart.add(tv, 3);
cart.add(scratchCard, 1);
checkout(customer, cart);
```
test: 

```java
    //to test the expiration date issue
    cart.add(Chips, 2);

    //to test the quantity issue  
    cart.add(juice, 10);
```

## example of running
```
(base) md@Mohameds-MacBook-Air java-ecommerce % javac App.java
(base) md@Mohameds-MacBook-Air java-ecommerce % java App
** shipment notice **
9x Cheese 1800.0g
1x TV 8000.0g
1x Biscuit 700.0g
total  weight 10.5 kg  

** Checkout receipt **
9x Cheese        900
1x TV           3000
1x Biscuit       150
1x Card           50
----------------------
Subtotal         4100
Shipping         30
Amount Paid      4130
Remaining Balance: 400
```



---

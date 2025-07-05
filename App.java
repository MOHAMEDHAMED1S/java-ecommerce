import java.util.*;

class Product{
    String name;
    double price;
    int quantity;
    double weight;
    int daysExpire;


    Product(String name,double price, int quantity , double weight , int daysExpire){
        this.name =name;
        this.price =price;
        this.quantity =quantity;
        this.weight =weight;
        this.daysExpire =daysExpire;
    }
    boolean isexpired(){
        return daysExpire !=-1   && daysExpire <=0;
    }
}

class Customer{
    String name;
    double balance;

    Customer(String name, double balance){
        this.name =name;
        this.balance =balance;

 }
    boolean hasmoney(double amount){
        return balance >=amount;
    }

    void takemoney(double amount){
        balance -=amount;
    }
}

class CartD{
    Product product;
    int quantity;

    CartD(Product product, int quantity){
        this.product =product;
        this.quantity =quantity;
    }
}

class Cart{
    List<CartD> items =new ArrayList<>();

    void add(Product a, int b){
        items.add(new CartD(a, b));
    }

    List<CartD> getItems(){
        return items;
    }
}

public class App{
        static void checkout(Customer customer, Cart cart){
        if (cart.getItems().isEmpty()){
            System.out.println(" cart is empty.");
            return;
        }

        double subtotal =0;
        double totalWeight =0;
        double Fee =0;
        double COST =30;

        for (CartD item : cart.getItems()){
            if (item.quantity > item.product.quantity){
                System.out.println(" product ' " + item.product.name + " ' not available.");
                return;
            }
            if (item.product.isexpired()){
                System.out.println("the product '" + item.product.name + "' is expired.");
                return;
            }

            subtotal +=item.product.price *item.quantity;

            if (item.product.weight > 0){
                totalWeight +=item.product.weight *item.quantity;
            }
        }

        if (totalWeight > 0){
            Fee =COST;
            System.out.println("**shipment notice **");
            for (CartD item : cart.getItems()){
                if (item.product.weight > 0 && item.quantity > 0){
                    double weight =item.product.weight *item.quantity;
                System.out.println(item.quantity + "x " + item.product.name + " " + weight + "g");                }
            }
            System.out.printf("total  weight %.1f kg  \n\n", totalWeight / 1000.0);
        }

        double total =subtotal + Fee;

        if (!customer.hasmoney(total)){
            System.out.println("insufficient balance.");
            return;
        }

        for (CartD item : cart.getItems()){
            item.product.quantity -=item.quantity;
        }
        customer.takemoney(total);

        System.out.println("**Checkout receipt **");
        for (CartD item : cart.getItems()){
            if (item.quantity > 0){
System.out.println(item.quantity + "x " + item.product.name + " " + (item.product.price *item.quantity));
            }
        }
                System.out.println("----------------------");
        System.out.printf("Subtotal         %.0f\n", subtotal);
        System.out.printf("Shipping         %.0f\n", Fee);
        System.out.printf("Amount Paid      %.0f\n", total);
        System.out.printf("Remaining Balance: %.0f\n", customer.balance);


        
    }
    public static void main(String[] args){
        Product cheese =new Product("Cheese", 100, 10, 200, 5);
    Product biscuit =new Product("Biscuit", 150, 5, 700, 2);
    Product Chips =new Product("Potato Chips", 50, 20, 300, 0);
    Product juice =new Product("Juice", 80, 4, 500, 7);
    Product tv =new Product("TV", 3000, 3, 8000, -1);
    Product card =new Product("Card", 50, 20, 0, -1);

        Customer customer =new Customer("Mohamed Hamed", 4530);

        Cart cart =new Cart();
        // ممكن تشيل الكومنت عشان تجرب مشكله انتهاء الصلاحية
        // cart.add(Chips, 1);

        // ممكن تشيل الكومنت هنا عشان تجرب مشكله الكميه  
        // cart.add(juice, 10);

        cart.add(cheese, 9);
        cart.add(tv, 1);
        cart.add(biscuit, 1);
        cart.add(card, 1);

        checkout(customer, cart);
    }



    
}

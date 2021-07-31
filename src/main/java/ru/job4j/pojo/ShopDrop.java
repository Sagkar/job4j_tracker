package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        for (int i = index + 1; i < products.length; i++) {
            products[index] = products[i];
            products[i] = null;
            index++;
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (Product product : products) {
            System.out.println(product.getName());
        }
        products[1] = products[2];
        products[2] = null;
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
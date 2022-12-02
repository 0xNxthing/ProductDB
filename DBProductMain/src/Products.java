import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    private ArrayList<Product> products = new ArrayList<Product>();

    private Scanner scanner = new Scanner(System.in);

    public void addProduct(String nameProduct, int price) {
        Product newProduct = new Product(nameProduct, price);
        if (products.isEmpty()) {
            newProduct.setId(1);
        } else {
            newProduct.setId(products.get(products.size() - 1).getId() + 1);
        }
        products.add(newProduct);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void updateProduct(Product updatedProduct, String updatedNameProduct, String updatedPrice) {
        if (!updatedNameProduct.equals("")) {
            updatedProduct.setNameProduct(updatedNameProduct);
        }
        if (!updatedPrice.equals("")) {
            updatedProduct.setPrice(Integer.parseInt(updatedPrice));
        }
    }

    public void showProducts() {
        for (Product product : products) {
            if (!products.isEmpty()) {
                System.out.println(product.getId() + "\t" + product.getNameProduct() + " " + product.getPrice() + "$");
            }
            if (products.isEmpty()) {
                System.out.println("There are no products...");
            }
        }
    }

    public Product findProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void setProducts(ArrayList<Product> products) {this.products = products;}

    public ArrayList<Product> getProducts() {return this.products;}
}

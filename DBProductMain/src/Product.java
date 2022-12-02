public class Product {
    private int id;
    private String nameProduct;
    private int price;

    public Product(String nameProduct, int price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public void setId(int id) {this.id = id;}

    public void setNameProduct(String nameProduct) {this.nameProduct = nameProduct;}

    public void setPrice(int price) {this.price = price;}

    public int getId() {return this.id;}

    public String getNameProduct() {return this.nameProduct;}

    public int getPrice() {return this.price;}

}

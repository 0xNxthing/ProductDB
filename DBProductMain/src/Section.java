import java.util.ArrayList;

public class Section {
    private int id;
    private String name;
    private String workTime;
    private ArrayList<Product> products = new ArrayList<>();

    public Section(String name, String workTime) {
        this.name = name;
        this.workTime = workTime;
    }

    public void setName(String name) {this.name = name;}

    public void setWorkTime(String workTime) {this.workTime = workTime;}

    public String getName() {return this.name;}

    public String getWorkTime() {return this.workTime;}

    public void addProductToSection(Product product) {
        products.add(product);}

    public void removeProductInSection(Product product) {
        products.remove(product);
    }

    public void setId(int id) {this.id = id;}

    public void setProducts(ArrayList<Product> products) {this.products = products;}

    public int getId() {return this.id;}

    public ArrayList<Product> getProducts() {return this.products;}
}

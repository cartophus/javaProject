package entities;

public class Product {

    private int productId;
    private String titlu;
    private String descriere;
    private String brand;
    private String categorie;
    private float pret;

    public Product(){
    }

    public Product(String titlu, String descriere, String brand, String categorie, float pret) {
        //this.productId = productId;
        this.titlu = titlu;
        this.descriere = descriere;
        this.brand = brand;
        this.categorie = categorie;
        this.pret = pret;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", titlu='" + titlu + '\'' +
                ", descriere='" + descriere + '\'' +
                ", brand='" + brand + '\'' +
                ", categorie='" + categorie + '\'' +
                ", pret=" + pret +
                '}';
    }
}

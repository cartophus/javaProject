package entities;

import java.util.*;

public interface ProductDao {

    void CreateProductTable();

    void InsertProduct(Product product);

    Product SelectProductById(String categorie);

    List<Product> SelectAllProducts();

    void DeleteProduct(int id);

    void UpdateProduct(Product product, int id);

}

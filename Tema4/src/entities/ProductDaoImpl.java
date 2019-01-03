package entities;

import com.company.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void CreateProductTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS products (id int primary key unique auto_increment," +
                    "titlu varchar(55),descriere varchar(255),brand varchar(55),categorie varchar(55),pret FLOAT)");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void InsertProduct(Product product) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO products (titlu,descriere,brand,categorie,pret)" +
                    "VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, product.getTitlu());
            preparedStatement.setString(2, product.getDescriere());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getCategorie());
            preparedStatement.setFloat(5, product.getPret());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO product (titlu,descriere,brand,categorie,pret)" +
                    "VALUES (?,?,?,?,?)");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Product SelectProductById(String categorie) {
        Product product = new Product();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM products WHERE categorie = ?");
            preparedStatement.setString(1, categorie);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                product.setProductId(resultSet.getInt("id"));
                product.setTitlu(resultSet.getString("titlu"));
                product.setDescriere(resultSet.getString("descriere"));
                product.setBrand(resultSet.getString("brand"));
                product.setCategorie(resultSet.getString("categorie"));
                product.setPret(resultSet.getFloat("pret"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return product;
    }

    @Override
    public List<Product> SelectAllProducts() {
        List<Product> products = new ArrayList<Product>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("id"));
                product.setTitlu(resultSet.getString("titlu"));
                product.setDescriere(resultSet.getString("descriere"));
                product.setBrand(resultSet.getString("brand"));
                product.setCategorie(resultSet.getString("categorie"));
                product.setPret(resultSet.getFloat("pret"));

                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return products;
    }

    @Override
    public void DeleteProduct(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM products WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM product WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void UpdateProduct(Product product, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE products SET " +
                    "titlu = ?, descriere = ?, brand = ?, categorie = ?, pret = ? WHERE id = ?");

            preparedStatement.setString(1, product.getTitlu());
            preparedStatement.setString(2, product.getDescriere());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getCategorie());
            preparedStatement.setFloat(5, product.getPret());
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();

            System.out.println("UPDATE product SET " +
                    "titlu = ?, descriere = ?, brand = ?, categorie = ?, pret = ? WHERE id = ?");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

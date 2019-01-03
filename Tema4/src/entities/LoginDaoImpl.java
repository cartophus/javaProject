package entities;

import com.company.ConnectionConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements LoginDao{//username VARCHAR(55) primary key unique DEFAULT NULL

    @Override
    public void CreateLoginTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS login (username varchar(55) NOT NULL ," +
                    "role varchar(55), password varchar(55),primary key(username))");

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
    public void InsertLogin(Login login) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO login (role,username,password)" +
                    "VALUES (?, ?, ?)");
            preparedStatement.setString(1, login.getRole());
            preparedStatement.setString(2, login.getUsername());
            preparedStatement.setString(3, login.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO login (role,username,password)" +
                    "VALUES (?,?, ?)");

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
    public Login SelectLoginById(String username) {
        Login login = new Login();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM login WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                login.setUsername(resultSet.getString("username"));
                login.setRole(resultSet.getString("role"));
                login.setPassword(resultSet.getString("password"));
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

        return login;
    }

    @Override
    public List<Login> SelectAllLogins() {
        List<Login> logins = new ArrayList<Login>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM login");

            while (resultSet.next()) {
                Login login = new Login();
                login.setUsername(resultSet.getString("username"));
                login.setRole(resultSet.getString("role"));
                login.setPassword(resultSet.getString("password"));

                logins.add(login);
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

        return logins;
    }

    @Override
    public void DeleteLogin(String username) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM login WHERE username = ?");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();

            System.out.println("DELETE FROM login WHERE username = ?");

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

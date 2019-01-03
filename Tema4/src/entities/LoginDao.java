package entities;

import java.util.List;

public interface LoginDao {

    void CreateLoginTable();

    void InsertLogin(Login login);

    Login SelectLoginById(String username);

    List<Login> SelectAllLogins();

    void DeleteLogin(String username);
}

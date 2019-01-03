package entities;

import java.util.*;

public interface UserDao {

    void CreateUserTable();

    void Insert(User user);

    User SelectById(int id);

    List<User> SelectAll();

    void Delete(int id);

    void Update(User user, int id);

}

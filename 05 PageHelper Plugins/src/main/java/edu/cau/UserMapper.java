package edu.cau;


import java.util.List;

public interface UserMapper {

    List<User> selectUsers();

    void save(User user);
}

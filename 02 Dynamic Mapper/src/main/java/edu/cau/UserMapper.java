package edu.cau;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUsers();

    void save(User user);

    void deleteUser(Integer userId);
}

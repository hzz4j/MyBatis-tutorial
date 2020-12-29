package edu.cau;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    List<User> findUserAndRole();
}

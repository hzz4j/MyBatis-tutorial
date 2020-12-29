package edu.cau;

import java.util.List;

public interface UserMapper {
    List<User> selectAllUsers(User user);

    List<User> forEachSelectUsers(List<Integer> ids);

    void save(User user);

    void deleteUser(Integer userId);


}

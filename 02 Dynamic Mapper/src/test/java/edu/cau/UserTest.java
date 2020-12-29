package edu.cau;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getUsers(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //  List<User> users = sqlSession.selectList("userMapper.selectAllUsers");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAllUsers();

        System.out.println(users);
        users.stream().forEach(System.out::println);
    }

    // 插入一条数据
    @Test
    public void insertUser(){
        User user = new User();
        user.setId(2);
        user.setUsername("Q10Viking");
        user.setPassword("123456");


        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        // int result = sqlSession.insert("userMapper.save", user);
        userMapper.save(user);

        sqlSession.commit();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(3);
        sqlSession.commit();
    }
}

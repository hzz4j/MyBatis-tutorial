package edu.cau;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


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
    public void saveUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("Lizhi");
        user.setPassword("123456");
        user.setLevel(Level.HIGHT);

        userMapper.save(user);
        sqlSession.commit();
    }


    @Test
    public void getUser(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 分页插件
        PageHelper.startPage(2,2);
        List<User> users = userMapper.selectUsers();
        Page<User> d = (Page)users;

//        users.forEach(System.out::println);
    }
}
/**
 User{id=1, username='hello', password='mybatis', level=LOW}
 User{id=4, username='Q10Viking', password='123456', level=HIGHT}
 User{id=5, username='Q10Viking', password='123456', level=MEDIUM}
 User{id=7, username='Lizhi', password='123456', level=HIGHT}
 */

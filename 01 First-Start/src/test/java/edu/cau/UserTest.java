package edu.cau;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    @Test
    public void getUsers(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);

            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            List<User> users = sqlSession.selectList("userMapper.selectAllUsers");

            System.out.println(users);
            users.stream().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

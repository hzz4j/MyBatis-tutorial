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
    public void init() {
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
    public void getUserAndRole(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findUserAndRole();

        users.forEach(System.out::println);
    }

}


/**
 User{id=1, username='lucy', password='123', birthday='2018-12-12', roles =[Role{id=1, rolename='CTO', roledesc='CTO'}, Role{id=2, rolename='COO', roledesc='COO'}]}
 User{id=2, username='haohao', password='123', birthday='2019-12-12', roles =[Role{id=1, rolename='CTO', roledesc='CTO'}, Role{id=2, rolename='COO', roledesc='COO'}]}
 */
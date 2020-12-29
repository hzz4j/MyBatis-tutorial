package edu.cau;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
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
    public void getUserOrder(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = mapper.selectAll();

        orders.forEach(System.out::println);
    }

}

/**
 * Order{id=1, orderTime='2018-12-12', total=3000.0, user=User{id=1, username='lucy', password='123', birthday='2018-12-12'}}
 * Order{id=2, orderTime='2018-12-12', total=4000.0, user=User{id=1, username='lucy', password='123', birthday='2018-12-12'}}
 * Order{id=3, orderTime='2018-12-12', total=5000.0, user=User{id=2, username='haohao', password='123', birthday='2019-12-12'}}
 */


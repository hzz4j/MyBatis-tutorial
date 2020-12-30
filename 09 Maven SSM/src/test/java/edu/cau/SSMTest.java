package edu.cau;

import edu.cau.pojo.Item;
import edu.cau.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-service.xml","classpath:applicationContext-dao.xml"})
public class SSMTest {

    @Autowired
    private ItemService itemService;

    @Test
    public void findItem(){
        Item item = itemService.findItem(1);
        System.out.println(item);
    }
}

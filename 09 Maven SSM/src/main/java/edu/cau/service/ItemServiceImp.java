package edu.cau.service;

import edu.cau.dao.ItemMapper;
import edu.cau.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImp implements ItemService{

    @Autowired
    private ItemMapper itemMapper;

    public Item findItem(int id) {
        return itemMapper.findItem(id);
    }
}

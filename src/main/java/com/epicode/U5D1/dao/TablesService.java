package com.epicode.U5D1.dao;

import com.epicode.U5D1.entities.Table;
import com.epicode.U5D1.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesService {
    @Autowired
    TablesDAO tablesDAO;

    public void saveTable(Table table) {
        tablesDAO.save(table);
        System.out.println("Table saved.");
    }

    public Table findTableById(long id) throws ItemNotFoundException {
        return tablesDAO.findById(id).orElseThrow(()-> new ItemNotFoundException(id));
    }

    public List<Table> findByMaxNumberOfGuests(int maxNumberOfGuests) {
        return tablesDAO.findByMaxNumberOfGuests(maxNumberOfGuests);
    }

    public List<Table> findByIsOccupiedTrue() {
        return tablesDAO.findByIsOccupiedTrue();
    }


}

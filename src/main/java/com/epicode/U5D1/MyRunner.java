package com.epicode.U5D1;

import com.epicode.U5D1.U5D1Application;
import com.epicode.U5D1.dao.TablesService;
import com.epicode.U5D1.entities.Table;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    TablesService tablesService;

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);

        Table table = new Table(5);
        tablesService.saveTable(table);
        tablesService.findByIsOccupiedFalse().forEach(System.out::println);
        //System.out.println(tablesService.findTableById(1));
      //  tablesService.findByMaxNumberOfGuests(5).forEach(System.out::println);
        tablesService.findByIsOccupiedTrue().forEach(System.out::println);
    }
}

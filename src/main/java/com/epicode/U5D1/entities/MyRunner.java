package com.epicode.U5D1.entities;

import com.epicode.U5D1.U5D1Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
        Table table1 = (Table) ctx.getBean("table");
        Order order1 = (Order) ctx.getBean("order1");
        Menu menu = (Menu) ctx.getBean("menu");
        log.info("Costo totale dell'ordine:" + order1.getTotalCost());
        log.info("Dettagli dell'ordine:" + order1);

    }
}

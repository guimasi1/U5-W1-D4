package com.epicode.U5D1;

import com.epicode.U5D1.entities.Menu;
import com.epicode.U5D1.entities.Order;
import com.epicode.U5D1.entities.Table;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class U5D1Application {

	public static void main(String[] args) {
		SpringApplication.run(U5D1Application.class, args);

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5D1Application.class);

		// Menu m = (Menu) ctx.getBean("menu");

		/*m.printMenu();*/
		ctx.close();
	}

}

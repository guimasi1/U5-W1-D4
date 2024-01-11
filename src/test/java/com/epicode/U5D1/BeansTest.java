package com.epicode.U5D1;

import com.epicode.U5D1.entities.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BeansTest {
    private static AnnotationConfigApplicationContext ctx;
    @BeforeAll
    static public void createContext() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @Test
    void tomatoTest() {
        Topping tomato = ctx.getBean("toppings_tomato", Topping.class);
        assertEquals("Tomato" , tomato.getName());
        assertEquals(0, tomato.getCalories());
        assertEquals(0, tomato.getPrice());
    }

    @Test
    void margheritaTest() {
        Pizza pizzaMargherita = ctx.getBean("pizza_margherita",Pizza.class);

        Topping tomato = ctx.getBean("toppings_tomato", Topping.class);
        Topping cheese = ctx.getBean("toppings_cheese", Topping.class);
        assertEquals("Pizza Margherita", pizzaMargherita.getName());
        List<Topping> toppings = pizzaMargherita.getToppingList();
        assertNotNull(toppings);
        assertTrue(toppings.stream().anyMatch(topping -> topping.getName().equals("Tomato")));
        assertTrue(toppings.stream().anyMatch(topping -> topping.getName().equals("Cheese")));
        assertEquals(4.99, pizzaMargherita.getPrice());
    }


}

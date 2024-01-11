package com.epicode.U5D1;

import com.epicode.U5D1.entities.Order;
import com.epicode.U5D1.entities.OrderStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OrderTest {
    private static AnnotationConfigApplicationContext ctx;
    private static Order order1;
    @BeforeAll
    static public void createContext() {
        ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
    }

    @Test
    void isOrderInProgress() {
        Order order1 = (Order) ctx.getBean("order1");
        assertEquals(order1.getOrderStatus(),OrderStatus.INPROGRESS);
    }

    @ParameterizedTest
    @CsvSource({"2,2.0"})
    void checkGuestsAndFee(int guests, double fee) {
        assertEquals(guests,2);
        assertEquals(fee,2.0);
    }

    @AfterAll
    public static void closeContext() {
        ctx.close();
    }


}

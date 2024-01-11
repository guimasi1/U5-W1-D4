package com.epicode.U5D1;

import com.epicode.U5D1.entities.Table;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
class TableTest {

	private static AnnotationConfigApplicationContext ctx;
	private static Table table1;
	@BeforeAll
	static void createContext() {
		ctx = new AnnotationConfigApplicationContext(U5D1Application.class);
		table1 = (Table) ctx.getBean("table");

	}



	@Test
	void tableIsAvailable() {
        assertFalse(table1.isOccupied());
	}

	@Test
	void maxNumberOfGuestsIs12() {
		assertEquals(table1.getMaxNumberOfGuests(),12);
	}

	@AfterAll
	public static void closeContext() {
		ctx.close();
	}


}

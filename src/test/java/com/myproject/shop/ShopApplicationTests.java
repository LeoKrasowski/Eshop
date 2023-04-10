package com.myproject.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ShopApplicationTests {

	@Test
	public void test() {
		int a = 2;
		int b = 3;
		Assertions.assertEquals(5, a+b);
	}


}

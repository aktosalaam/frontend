/*package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.CartItem;

public class CartDAOTestCase 
{

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		
	    cartItem.setCartItemId(1);
		cartItem.setProductId(1);
		cartItem.setProductName("Samsung J7");
		cartItem.setQuantity(10);
		cartItem.setStatus("NP");
		cartItem.setUsername("Pr");
		cartItem.setPrice(7000);
		
		assertEquals("Adding CartItem", true,cartDAO.addCart(cartItem));
	}
}
*/
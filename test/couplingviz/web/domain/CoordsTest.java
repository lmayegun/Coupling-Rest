package couplingviz.web.domain;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CoordsTest {
	@Autowired
	private Coords coords;
	private double delta = 0.001;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		coords.setX(5);
		coords.setY(10); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void coordsNotNull(){
		assertNotNull(coords);
	}
	@Test
	public void testGetX() {
		System.out.println("testGetX");
		int actual = 5;
		int expResult = coords.getX();
		assertEquals(expResult, actual, delta); 
		
	}
	
	@Test
	public void testSetX() {
		System.out.println("testSetX");
		int actual =30;
		coords.setX(actual);
		int expResult = coords.getX();
		assertEquals(expResult,actual, delta);
		
	}
	
	@Test
	public void testGetY() {
		System.out.println("testGetY");
		int actual = 5;
		coords.setY(actual);
		int expected = coords.getY();
		assertEquals(expected,actual, delta); 
		
	}

	@Test
	public void testSetY() {
		System.out.println("testSetY");
		int actual = 20;
		coords.setY(actual);
		int expResult = coords.getY();
		assertEquals(expResult,actual, delta);
	}

	@Configuration
	static class CoordsTestConfiguration{
		@Bean
		public Coords coords(){
			return new Coords();
			
		}
	}
	
}

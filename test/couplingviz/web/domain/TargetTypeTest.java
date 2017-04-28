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
public class TargetTypeTest {
	
	@Autowired
	private TargetType targetType;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsIsDirectTarget() { 
		System.out.println("testIsIsDirectTarget");
		boolean actual = true;
		targetType.setIsDirectTarget(actual);
		boolean expResult = targetType.isIsDirectTarget();
		assertTrue(expResult);
	} 
	 

	@Test
	public void testSetIsDirectTarget() { 
		System.out.println("testSetIsDirectTarget"); 
		boolean actual = true;
		targetType.setIsDirectTarget(actual);
		boolean expResult = targetType.isIsDirectTarget();
		assertTrue(expResult);
	} 
	 

	@Test
	public void testIsIsLocalInheritanceTarget() { 
		System.out.println("testIsIsLocalInheritanceTarget"); 
		boolean actual = true;
		targetType.setIsLocalInheritanceTarget(actual);
		boolean expResult = targetType.isIsLocalInheritanceTarget();
		assertTrue(expResult);
	} 	 

	@Test
	public void testSetIsLocalInheritanceTarget() { 
		System.out.println("testSetIsLocalInheritanceTarget"); 
		boolean actual = true;
		targetType.setIsLocalInheritanceTarget(actual);
		boolean expResult = targetType.isIsLocalInheritanceTarget();
		assertTrue(expResult);
	} 
	 
	@Test
	public void testIsIsForeignInheritanceTarget() { 
		System.out.println("testIsIsForeignInheritanceTarget"); 
		boolean actual = true;
		targetType.setIsForeignInheritanceTarget(actual);
		boolean expResult = targetType.isIsForeignInheritanceTarget();
		assertTrue(expResult);
	} 	 

	@Test
	public void testSetIsForeignInheritanceTarget() { 
		System.out.println("testSetIsForeignInheritanceTarget"); 
		boolean actual = true;
		targetType.setIsForeignInheritanceTarget(actual);
		boolean expResult = targetType.isIsForeignInheritanceTarget();
		assertTrue(expResult);
	} 
	 
	@Test
	public void testIsIsInterfaceTarget() { 
		System.out.println("testIsIsInterfaceTarget");
		boolean actual = true;
		targetType.setIsInterfaceTarget(actual);
		boolean expResult = targetType.isIsInterfaceTarget();
		assertTrue(expResult);
	} 
	 
	@Test
	public void testSetIsInterfaceTarget() { 
		System.out.println("testSetIsInterfaceTarget"); 
		boolean actual = true;
		targetType.setIsInterfaceTarget(actual);
		boolean expResult = targetType.isIsInterfaceTarget();
		assertTrue(expResult);
	} 
	 
	@Configuration
	static class TargetTypeTestConfiguration{
		@Bean
		public TargetType targetType(){
			return new TargetType();
			
		}
	}
}

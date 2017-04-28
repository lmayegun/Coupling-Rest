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
public class CollaboratorTest {
	
	@Autowired
	private Collaborator collaborator;
	@Autowired
	private Properties properties;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		collaborator.setId("ID_Template"); 
		collaborator.setPackagename("lsbu.ac.uk.couplingviz"); 
		collaborator.setProperties(properties);
		properties.setName("Template"); 
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetId() { 
		System.out.println("testGetId"); 
		String actual = "ID_Template";
		String expResult = collaborator.getId();
		assertEquals(expResult, actual);
	} 
	 	
	@Test
	
	public void testSetId() { 
		System.out.println("testSetId");
		String actual = "ID_Log";
		collaborator.setId(actual);
		String expResult = collaborator.getId();
		assertEquals(expResult, actual);
	} 
	 	
	@Test
	public void testGetPackagename() { 
		System.out.println("testGetPackagename");
		String actual = "lsbu.ac.uk.couplingviz";
		String expResult = collaborator.getPackagename();
		assertEquals(expResult, actual);
	} 
	 	
	@Test
	public void testSetPackagename() { 
		System.out.println("testSetPackagename"); 
		String actual = "lsbu.ac.uk.apache";
		collaborator.setPackagename(actual);
		String expResult = collaborator.getPackagename();
		assertEquals(expResult, actual);
	} 
	 	
	@Test	
	public void testGetProperties() { 
		System.out.println("testGetProperties");
		Properties actual = this.properties;
		Properties expResult = collaborator.getProperties();
		assertSame(expResult,actual);
		assertEquals(expResult.getName(),"Template");
	} 
	 
	
	@Test
	public void testSetProperties() { 
		System.out.println("testSetProperties"); 
		Properties actual = new Properties();
		collaborator.setProperties(actual);
		Properties expResult = collaborator.getProperties();
		assertSame(expResult,actual);
	} 
	 
	
	@Configuration
	static class CollaboratorTestConfiguration{
		
		@Bean
		public Collaborator collaborator(){
			return new Collaborator();
		}
		@Bean
		public Properties properties(){
			return new Properties();
		}
		
		@Bean
		public Coords coords(){
			return new Coords();
		}
	}
}

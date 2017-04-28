package couplingviz.web.domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
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
public class PropertiesTest {
	
	@Autowired
	private Properties properties;
	@Autowired
	private Coords coords;
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
	public void testGetName() { 
		System.out.println("testGetName"); 
		String name = "Template";
		properties.setName(name);
		String expResult = properties.getName();
		assertEquals(expResult, name); 
	}

	@Test
	public void testSetName() { 
		System.out.println("testSetName"); 
		String name = "ClassName";
		properties.setName(name);
		String expResult = properties.getName();
		assertEquals(expResult, name);
	} 
 
	@Test
	public void testIsIsInterface() { 
		System.out.println("testIsIsInterface"); 
		boolean expResult = true;
		properties.setIsInterface(expResult);
		boolean result = properties.isIsInterface();
		assertTrue(result);
	} 
 
	@Test
	public void testSetIsInterface() { 
		System.out.println("testSetIsInterface"); 
		boolean expResult = true;
		properties.setIsInterface(expResult);
		boolean result = properties.isIsInterface();
		assertTrue(result);
	} 

	@Test
	public void testIsIsTarget() { 
	 	System.out.println("testIsIsTarget"); 
	 	boolean expResult = true;
		properties.setIsTarget(expResult);
		boolean result = properties.isIsTarget();
		assertTrue(result);
	} 
  
	@Test
	public void testSetIsTarget() { 
	 	System.out.println("testSetIsTarget"); 
	 	boolean expResult = true;
		properties.setIsTarget(expResult);
		boolean result = properties.isIsTarget();
		assertTrue(result);
	} 
  
	@Test
	public void testIsIsDirectTarget() { 
	 	System.out.println("testIsIsDirectTarget"); 
	 	boolean expResult = true;
		properties.setIsInterface(expResult);
		boolean result = properties.isIsInterface();
		assertTrue(result);
	} 
  
	@Test
	public void testSetIsDirectTarget() { 
	 	System.out.println("testSetIsDirectTarget"); 
	 	boolean expResult = true;
		properties.setIsInterface(expResult);
		boolean result = properties.isIsInterface();
		assertTrue(result);
	} 

	@Test
	public void testIsIsInnercalss() { 
	 	System.out.println("testIsIsInnercalss"); 
	 	boolean expResult = true;
		properties.setIsInnercalss(expResult);
		boolean result = properties.isIsInnercalss();
		assertTrue(result);
	} 
  
	@Test
	public void testSetIsInnercalss() { 
	 	System.out.println("testSetIsInnercalss"); 
	 	boolean expResult = true;
		properties.setIsInnercalss(expResult);
		boolean result = properties.isIsInnercalss();
		assertTrue(result);
	} 
  
	@Test
	public void testGetCBOCouplingViz() { 
	 	System.out.println("testGetCBOCouplingViz"); 
	 	int actual = 5;
	 	properties.setCBOCouplingViz(actual);
	 	int expResult = properties.getCBOCouplingViz();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetCBOCouplingViz() { 
	 	System.out.println("testSetCBOCouplingViz"); 
	 	int actual = 5;
	 	properties.setCBOCouplingViz(actual);
	 	int expResult = properties.getCBOCouplingViz();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetCBOTargetsOnly() { 
	 	System.out.println("testGetCBOTargetsOnly"); 
	 	int actual = 2;
	 	properties.setCBOTargetsOnly(actual);
	 	int expResult = properties.getCBOTargetsOnly();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetCBOTargetsOnly() { 
	 	System.out.println("testSetCBOTargetsOnly"); 
	 	int actual = 3;
	 	properties.setCBOTargetsOnly(actual);
	 	int expResult = properties.getCBOTargetsOnly();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetCBONoInheritance() { 
	 	System.out.println("testGetCBONoInheritance"); 
	 	int actual = 5;
	 	properties.setCBONoInheritance(actual);
	 	int expResult = properties.getCBONoInheritance();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetCBONoInheritance() { 
	 	System.out.println("testSetCBONoInheritance"); 
	 	int actual = 5;
	 	properties.setCBONoInheritance(actual);
	 	int expResult = properties.getCBONoInheritance();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetNoOfDirectcalss() { 
	 	System.out.println("testGetNoOfDirectcalss"); 
	 	int actual = 4;
	 	properties.setNoOfDirectcalss(actual);
	 	int expResult = properties.getNoOfDirectcalss();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetNoOfDirectcalss() { 
	 	System.out.println("testSetNoOfDirectcalss"); 
	 	int actual = 4;
	 	properties.setNoOfDirectcalss(actual);
	 	int expResult = properties.getNoOfDirectcalss();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetNoOfCalssWithForeignInheritance() { 
	 	System.out.println("testGetNoOfCalssWithForeignInheritance"); 
	 	int actual = 4;
	 	properties.setNoOfCalssWithForeignInheritance(actual);
	 	int expResult = properties.getNoOfCalssWithForeignInheritance();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetNoOfCalssWithForeignInheritance() { 
	 	System.out.println("testSetNoOfCalssWithForeignInheritance"); 
	 	int actual = 4;
	 	properties.setNoOfCalssWithForeignInheritance(actual);
	 	int expResult = properties.getNoOfCalssWithForeignInheritance();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetNoOfCalssWithNativeInheritance() { 
	 	System.out.println("testGetNoOfCalssWithNativeInheritance"); 
	 	int actual = 3;
	 	properties.setNoOfCalssWithNativeInheritance(actual);
	 	int expResult = properties.getNoOfCalssWithNativeInheritance();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetNoOfCalssWithNativeInheritance() { 
	 	System.out.println("testSetNoOfCalssWithNativeInheritance"); 
	 	int actual = 6;
	 	properties.setNoOfCalssWithNativeInheritance(actual);
	 	int expResult = properties.getNoOfCalssWithNativeInheritance();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetNoOfInterfaces() { 
	 	System.out.println("testGetNoOfInterfaces");
	 	int actual = 5;
	 	properties.setNoOfInterfaces(actual);
	 	int expResult = properties.getNoOfInterfaces();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetNoOfInterfaces() { 
	 	System.out.println("testSetNoOfInterfaces"); 
	 	int actual = 1;
	 	properties.setNoOfInterfaces(actual);
	 	int expResult = properties.getNoOfInterfaces();
	 	assertEquals(expResult, actual);
	}  

	@Test
	public void testGetNoOfInterfaceDependencies() { 
	 	System.out.println("testGetNoOfInterfaceDependencies"); 
	 	int actual = 0;
	 	properties.setNoOfInterfaceDependencies(actual);
	 	int expResult = properties.getNoOfInterfaceDependencies();
	 	assertEquals(expResult, actual);
	}  

	@Test
	public void testSetNoOfInterfaceDependencies() { 
	 	System.out.println("testSetNoOfInterfaceDependencies"); 
	 	int actual = 0;
	 	properties.setNoOfInterfaceDependencies(actual);
	 	int expResult = properties.getNoOfInterfaceDependencies();
	 	assertEquals(expResult, actual);
	} 

	@Test
	public void testGetNoOfInterfaceOrAbstract() { 
	 	System.out.println("testGetNoOfInterfaceOrAbstract"); 
	 	int actual = 0;
	 	properties.setNoOfInterfaceOrAbstract(actual);
	 	int expResult = properties.getNoOfInterfaceOrAbstract();
	 	assertEquals(expResult, actual);
	}   

	@Test
	public void testSetNoOfInterfaceOrAbstract() { 
	 	System.out.println("testSetNoOfInterfaceOrAbstract"); 
	 	int actual = 2;
	 	properties.setNoOfInterfaceOrAbstract(actual);
	 	int expResult = properties.getNoOfInterfaceOrAbstract();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetNoOfTotalCouples() { 
	 	System.out.println("testGetNoOfTotalCouples"); 
	 	int actual = 4;
	 	properties.setNoOfTotalCouples(actual);
	 	int expResult = properties.getNoOfTotalCouples();
	 	assertEquals(expResult, actual);
 	} 
  
	@Test
	public void testSetNoOfTotalCouples() { 
	 	System.out.println("testSetNoOfTotalCouples"); 
	 	int actual = 3;
	 	properties.setNoOfTotalCouples(actual);
	 	int expResult = properties.getNoOfTotalCouples();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetCouplingConstructors() { 
	 	System.out.println("testGetCouplingConstructors"); 
	 	int actual = 1;
	 	properties.setCouplingConstructors(actual);
	 	int expResult = properties.getCouplingConstructors();
	 	assertEquals(expResult, actual);
	} 

	@Test
	public void testSetCouplingConstructors() { 
	 	System.out.println("testSetCouplingConstructors"); 
	 	int actual = 2;
	 	properties.setCouplingConstructors(actual);
	 	int expResult = properties.getCouplingConstructors();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetNoOfAncestorMethods() { 
	 	System.out.println("testGetNoOfAncestorMethods"); 
	 	int actual = 3;
	 	properties.setNoOfAncestorMethods(actual);
	 	int expResult = properties.getNoOfAncestorMethods();
	 	assertEquals(expResult, actual);
	} 

	@Test
	public void testSetNoOfAncestorMethods() { 
	 	System.out.println("testSetNoOfAncestorMethods"); 
	 	int actual = 5;
	 	properties.setNoOfAncestorMethods(actual);
	 	int expResult = properties.getNoOfAncestorMethods();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetCBOWithAbstract() { 
	 	System.out.println("testGetCBOWithAbstract");
	 	int actual = 3;
	 	properties.setCBOWithAbstract(actual);
	 	int expResult = properties.getCBOWithAbstract();
	 	assertEquals(expResult, actual);
	}   

	@Test
	public void testSetCBOWithAbstract() { 
	 	System.out.println("testSetCBOWithAbstract"); 
	 	int actual = 12;
	 	properties.setCBOWithAbstract(actual);
	 	int expResult = properties.getCBOWithAbstract();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testGetClr() { 
	 	System.out.println("testGetClr"); 
	 	String actual = "blue";
	 	properties.setClr(actual);
	 	String expResult = properties.getClr();
	 	assertEquals(expResult, actual);
	} 
  
	@Test
	public void testSetClr() { 
	 	System.out.println("testSetClr");
	 	String actual = "green";
	 	properties.setClr(actual);
	 	String expResult = properties.getClr();
	 	assertEquals(expResult, actual);
	}   

	@Test
	public void testGetReserveClr() { 
	 	System.out.println("testGetReserveClr"); 
	 	String actual = "pink";
	 	properties.setReserveClr(actual);
	 	String expResult = properties.getReserveClr();
	 	assertEquals(expResult, actual);
	}   

	@Test
	public void testSetReserveClr() { 
	 	System.out.println("testSetReserveClr"); 
	 	String actual = "gray";
	 	properties.setReserveClr(actual);
	 	String expResult = properties.getReserveClr();
	 	assertEquals(expResult, actual);
	}   

	@Test
	public void testGetCoords() { 
	 	System.out.println("testGetCoords"); 
	 	List<Coords> actual = new ArrayList();
	 	actual.add(new Coords());
	 	properties.setCoords(actual);
	 	assertSame(properties.getCoords(), actual); 
	}   

	@Test
	public void testSetCoords() { 
	 	System.out.println("testSetCoords"); 
	 	List<Coords> actual = new ArrayList();
	 	actual.add(new Coords());
	 	properties.setCoords(actual);
	 	assertSame(properties.getCoords(), actual); 
	} 
  
	@Test
	public void testGetTargets() { 
	 	System.out.println("testGetTargets");
	 	List<String> actual = new ArrayList();
	 	properties.setTargets(actual);
	 	assertSame(properties.getTargets(), actual); 
	}  

	@Test
	public void testSetTargets() { 
	 	System.out.println("testSetTargets"); 
	 	List<String> actual = new ArrayList();
	 	actual.add("Test");
	 	properties.setTargets(actual);
	 	assertSame(properties.getTargets(), actual); 
	} 
  
 
 	@Configuration
	static class PropertiesTestConfiguration{
	 
 		@Bean
 		public Properties properties(){
 			return new Properties();
 		}
 		
 		@Bean
 		public Coords coords(){
 			return new Coords();
 		}
 		
 		@Bean
 		public TargetType targetType(){
 			return new TargetType();
 		}
	 
 }
}
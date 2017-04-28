package couplingviz.web.services;

import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import couplingviz.web.config.WebAppContextConfig;
import couplingviz.web.domain.Collaborator;
import couplingviz.web.domain.Coords;
import couplingviz.web.domain.Properties;
import couplingviz.web.domain.TargetType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ WebAppContextConfig.class})
public class VizDataTest {
	
	@Autowired
	private Coords coords;
	@Autowired
	private TargetType targetType;
	@Autowired
	private Properties properties;
	@Autowired
	private Collaborator collaborator;
	@Autowired
	private VizData vizData;
	
	private  String ROOT_DIR = "J:\\APACHE\\apache-tomcat-7.0.61\\test\\root\\";
	private  String LOG_DIR = "J:\\APACHE\\apache-tomcat-7.0.61\\test\\log\\"; 
	private  String JSON_DIR = "J:\\APACHE\\apache-tomcat-7.0.61\\test\\json\\";
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		vizData.setLogDir(LOG_DIR);
		vizData.setRootDir(ROOT_DIR); 
		vizData.setCollab(this.collaborator);
		vizData.setTargetType(this.targetType);
		vizData.setCoord(this.coords); 
		vizData.setProperties(this.properties); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetVizData() throws Exception{ 
		System.out.println("testGetVizData"); 
		ArrayList<Collaborator>[] collabs = vizData.getVizData();
		System.out.println("collabs " + collabs[0].size()); 
		assertEquals(collabs[0].size(), 63);
	} 
 	
	@Test
	public void testSerializeVizData() throws Exception{ 
		System.out.println("testSerializeVizData"); 
		String [] jsonArrays = vizData.serializeVizData();
		assertSame(jsonArrays[0].isEmpty(), false);
	} 
 	
	@Test
	public void testGetRootDir() { 
		System.out.println("testGetRootDir"); 
		String actual = this.ROOT_DIR;
		String expected = vizData.getRootDir();
		assertEquals(expected, actual);
	} 
	 
	@Test
	public void testSetRootDir() { 
		System.out.println("testSetRootDir");
		String actual =  "J:\\APACHE\\apache-tomcat-7.0.61"; //System.getProperty("catalina.home");
		vizData.setRootDir(actual); 
		String expected = vizData.getRootDir();
		assertEquals(expected, actual);
	} 
	 
	@Test
	public void testGetLogDir() { 
		System.out.println("testGetLogDir"); 
		String actual = this.LOG_DIR;
		String expected = vizData.getLogDir();
		assertEquals(expected, actual);
	} 
	 
	@Test
	public void testSetLogDir() { 
		System.out.println("testSetLogDir"); 
		String actual = "J:\\APACHE\\apache-tomcat-7.0.61";
		vizData.setRootDir(actual); 
		String expected = vizData.getRootDir();
		assertEquals(expected, actual);
	} 	 

	@Test
	public void testGetCollab() { 
		System.out.println("testGetCollab"); 
		Collaborator actual = this.collaborator; 
		Collaborator expected = vizData.getCollab();
		assertNotNull(actual);
		assertNotNull(expected);
		assertSame(expected, actual);
	} 
	 
	@Test
	public void testSetCollab() { 
		System.out.println("testSetCollab");
		Collaborator actual = new Collaborator(); 
		vizData.setCollab(actual);
		Collaborator expected = vizData.getCollab();
		assertSame(expected, actual);
	} 	 

	@Test
	public void testGetProperties() { 
		System.out.println("testGetProperties");
		Properties actual = this.properties; 
		Properties expected = vizData.getProperties();
		assertSame(expected, actual);
	} 
	 
	@Test
	public void testSetProperties() { 
		System.out.println("testSetProperties");
		Properties actual = new Properties(); 
		vizData.setProperties(actual);
		Properties expected = vizData.getProperties();
		assertSame(expected, actual);
	} 	 

	@Test
	public void testGetCoord() { 
		System.out.println("testGetCoord"); 
		Coords actual = this.coords; 
		Coords expected = vizData.getCoord();
		assertSame(expected, actual);
	} 
	 
	@Test
	public void testSetCoord() { 
		System.out.println("testSetCoord"); 
		Coords actual = new Coords(); 
		vizData.setCoord(actual);
		Coords expected = vizData.getCoord();
		assertSame(expected, actual);
	} 
	 
	@Test

	public void testGetTargetType() { 
		System.out.println("testGetTargetType"); 
		TargetType actual = this.targetType; 
		TargetType expected = vizData.getTargetType();
		assertSame(expected, actual);
	} 
	 
	@Test
	public void testSetTargetType() { 
		System.out.println("testSetTargetType"); 
		TargetType actual = new TargetType(); 
		vizData.setTargetType(actual);
		TargetType expected = vizData.getTargetType();
		assertSame(expected, actual);
	} 
	 	
	@Test
	public void testCreateJson() throws Exception{ 
		System.out.println("testCreateJson");
		String [] jsonArrays = vizData.serializeVizData();
		String jsonStr = jsonArrays[0] +";" + jsonArrays[1];
		vizData.createJson(jsonStr, JSON_DIR);
		String[] fileNames = new File(this.JSON_DIR).list();
		int expected = 2;
		int actual = fileNames.length;
		assertEquals(expected, actual);
	} 
	 
}

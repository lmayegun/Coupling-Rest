package couplingviz.web.services;

import static org.junit.Assert.*;
import java.io.File;
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
import couplingviz.web.controller.FileProcessController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ WebAppContextConfig.class})
public class UnzipUtilityTest {

	private String rootPath = "J:\\APACHE\\apache-tomcat-7.0.61\\test\\unzipUtilityTest"; 
	private String testFilePath = rootPath  + File.separator + "CouplingViz.zip" ;
	private String unzipDir =   rootPath + File.separator + "unzip"; 
	private String destDir = unzipDir  + "CouplingViz"; 
	private File udestDir;
		
	@Autowired
	private UnzipUtility unzipUtility;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		udestDir = new File(destDir);
        if (!udestDir.exists())
        	udestDir.mkdirs();
	}

	@After
	public void tearDown() throws Exception {
		FileProcessController.deleteFolder(udestDir);
	}

	@Test
	public void testUnzip() throws Exception { 
		System.out.println("testUnzip"); 
			unzipUtility.unzip(testFilePath,  unzipDir);
			String[] fileNames = udestDir.list();
			int actual = 6;
			int expected = fileNames.length;
			
			assertEquals(expected, actual); 
	} 
	 


}

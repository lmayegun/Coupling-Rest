package couplingviz.web.controller;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import couplingviz.web.config.WebAppContextConfig;
import couplingviz.web.domain.Collaborator;
import couplingviz.web.domain.Coords;
import couplingviz.web.domain.Properties;
import couplingviz.web.domain.TargetType;
import couplingviz.web.services.VizData;
import couplingviz.web.services.UnzipUtility;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={ WebAppContextConfig.class})
public class FileProcessControllerTest {
	private MockMvc mockMvc;
	private String str =  System.getProperty("catalina.HOME");
	private String rootPath = "J:\\APACHE\\apache-tomcat-7.0.61\\test\\fileProcessControllerTest"; 
	private String uploadPath = rootPath  +  File.separator + "upload"  + File.separator;
	private String unzipPath =  rootPath  +  File.separator + "unzipDest"  + File.separator;
	private String testFilePath = rootPath  + File.separator + "CouplingViz.zip";
	private String uploadedFilePath = uploadPath + "CouplingViz.zip";
	private File unzipDir;
	private MockMultipartFile toUpload;
		
	
	@Autowired
	private UnzipUtility unzipUtility;
	@Autowired
	private VizData vizData;
	
	@Autowired
	private FileProcessController fileProcessController;
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		 
		unzipDir = new File(unzipPath);
        if (!unzipDir.exists())
        	unzipDir.mkdirs();
		byte[] fileData = IOUtils.toByteArray(new FileInputStream(new File(testFilePath)));
		this.toUpload = new MockMultipartFile("file", "CouplingViz.zip", "application/zip", testFilePath.getBytes());
		mockMvc = MockMvcBuilders.standaloneSetup(this.fileProcessController).build();
		fileProcessController.setJsonPath("catalina.home");
		str = fileProcessController.getJsonPath();
		
	}

	@After
	public void tearDown() throws Exception {
		FileProcessController.deleteFolder(new File(uploadedFilePath));
	}

	
	@Test
	public void testProcessFile () throws Exception {
		System.out.println(str);
		assertNotNull(unzipUtility);
		assertNotNull(vizData);
	
		MockMultipartFile toUpload = new MockMultipartFile("file", "CouplingViz.zip", "application/zip", testFilePath.getBytes());
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.fileProcessController).build();
		MockMultipartHttpServletRequest request = new MockMultipartHttpServletRequest();
		String boundary = "q1w2e3r4t5y6u7i8o9";
		request.setContentType("multipart/form-data; boundary="+boundary);
        request.setMethod(RequestMethod.POST.name()); 
        request.addHeader("Content-Type", "multipart/form-data"); 
        request.setRequestURI("/fileProcess.html"); 
        request.addFile(toUpload); 
        request.addParameter("username", "Aschalew");
        request.addParameter("filename", "couplingviz"); 
        
        ServletFileUpload upload = new ServletFileUpload();
       
        
        assertTrue(upload.isMultipartContent(request));
        
	
		//mockMvc.perform(MockMvcRequestBuilders.fileUpload("/fileProcess.html").file(toUpload).param("username", "Aschalew").param("filename", "Velocity"));
				    
        MultipartFile mpf = request.getFile("file");
        mpf.transferTo(new File(uploadedFilePath));
        
        String[] zipFileNames = new File(uploadPath).list();
        
        assertEquals(zipFileNames.length,1);
              
       
        try{
        	unzipUtility.unzip(testFilePath,unzipPath);
        } catch(IOException ioE){
			System.out.println(ioE.getMessage());
			
		}
        String[] unzippedFileNames = new File(unzipPath).list();
        
        assertEquals(unzippedFileNames[0],"CouplingViz");
        
        String[] collabs = new String[2];
        vizData.setLogDir(rootPath);
        vizData.setRootDir(unzipPath);
        collabs = vizData.serializeVizData();
        int expected = collabs[0].length();
        int actual = 2;
        
        assertTrue(expected > 100);
        System.out.println( "CATALINA.HOME  " + str );
     
	}
	
	@Configuration
	static class FileProcessorControllerTestConfiguration{
		
		@Bean
		public VizData  vizData(){
			return new  VizData();
		}
		@Bean
		public UnzipUtility unzipUtility(){
			return new UnzipUtility();
		}
		
		
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
		
		@Bean
		public TargetType targetType(){
			return new TargetType();	
		}
	}
	
}

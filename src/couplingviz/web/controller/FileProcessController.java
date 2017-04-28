package couplingviz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import couplingviz.web.services.*;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import java.io.File;
import java.io.IOException;

/**
 * A controller that handles the user's request after posting the zipped file
 * @author L. Mayegun
 * @version 1.0, April 2017
 */
@Controller
public class FileProcessController {
	
	private String zipPath;
	private String destinationDir;
	private String jsonPath;
	private VizData vizData;
	private UnzipUtility unzipUtil;
	
	/**
	 * A constructor that takes vizData and unzipUtility objects and initialises 
	 * the corresponding fields.
	 * @param vizData passed in as VizData
	 * @param unzipUtil passed in as UnzipUtility
	 */
	@Autowired
	public FileProcessController(VizData vizData, UnzipUtility unzipUtil){
		this.vizData = vizData;
		this.unzipUtil = unzipUtil;
	}
	
	/**
	 * A default constructor.
	 */
	public FileProcessController(){
		
	}
	
	/**
	 * Handles the POST request of the URL /fileProcess.html by calling methods from the model
	 * classes and processing the file that is passed to it as parameter. The resulting data as JSON
	 * from the methods of the model classes is associated with the view name.
	 * @param file passed in as MultipartFile
	 * @param username passed in as String
	 * @return a ModelAndView object containing the JSON and the view name Display as ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value= "/rjsonfanin", method = RequestMethod.POST)
	@ExceptionHandler
	public @ResponseBody String processFanin(@RequestPart("TheFile") MultipartFile file) throws Exception{
		String msg2 = "";
		String orgFileName = file.getOriginalFilename();
		String orgFileNameWithoutExt = orgFileName.substring(0, orgFileName.lastIndexOf('.'));
		String rootPath = System.getProperty("catalina.home");
		jsonPath = rootPath + File.separator + "tmpFiles" + File.separator + "lukmon" +  File.separator  + orgFileNameWithoutExt  +"_JSON" + File.separator;;
		zipPath = rootPath + File.separator + "tmpFiles" + File.separator + "lukmon" +  File.separator;
		destinationDir =  rootPath + File.separator + "tmpFiles" + File.separator + "lukmon" +  File.separator + orgFileNameWithoutExt + File.separator;
		zipPath = zipPath  + orgFileName;
		
		// create a destination directory for storing the unzipped source codes.
		File dir = new File(destinationDir);
         if (!dir.exists())
             dir.mkdirs();
         
         // create a directory for storing the JSON files
        File jsonDir = new File(jsonPath);
         if (!jsonDir.exists())
        	 jsonDir.mkdirs();
        // create a path where the zip file transferred and assign msg2 the appropriate message     
        File zipPathNFile = new File(zipPath);
        
        long tStart = System.currentTimeMillis();
        
        // Use of the transferTo method of the File class to upload the zip file
		try{
			file.transferTo(zipPathNFile);
			msg2 = "lukmon" + ": You successfully uploaded your zipped source code, " + file.getOriginalFilename() ;
		}catch(IOException e){
			System.out.println(e.getMessage());
			msg2 =  "You failed to upload " + e.getMessage();
		}
		
		// unpackaging the zipped source codes to the destination directory 
		System.out.println("booyah");
		try{
			unzipUtil.unzip(zipPath,destinationDir);
			
		} catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		
		// deleting the folder containing the zip files
		zipPathNFile.delete();
		
		System.out.println("file is unzipped.");
		
		// Setting the RootDir and LogDir fields of the vizData object
		vizData.setRootDir(destinationDir);
		vizData.setLogDir(destinationDir);
		
		// create an array of two strings
		String [] collaboratorArrays = new String[2];
		
		// get the visualization data by calling the serializeVizData method of the Class VizData and 
		// assigning the return value to string array created earlier.
		try{
			System.out.println("Wrtinig Jacksons JSON...  ");
			collaboratorArrays = vizData.serializeVizData();
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}catch(ParseException ex){
			System.out.println(ex.getMessage());
		}
		
		// combine the two strings from the array to one string separated by semicolon ; and pass 
		// the resulting string to the createJson method of the VizData class.
		String jsonStr = collaboratorArrays[0] + ";" +  collaboratorArrays[1];
		//vizData.createJson(jsonStr, jsonPath);  
		
        deleteFolder(dir);
		
		//System.out.println("this is the name of file" + file.getOriginalFilename());

		return collaboratorArrays[0];
	}
	
	/**
	 * Handles the POST request of the URL /fileProcess.html by calling methods from the model
	 * classes and processing the file that is passed to it as parameter. The resulting data as JSON
	 * from the methods of the model classes is associated with the view name.
	 * @param file passed in as MultipartFile
	 * @param username passed in as String
	 * @return a ModelAndView object containing the JSON and the view name Display as ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value= "/rjsonfanout", method = RequestMethod.POST)
	@ExceptionHandler
	public @ResponseBody String processFanout(@RequestPart("TheFile") MultipartFile file) throws Exception{
		String msg2 = "";
		String orgFileName = file.getOriginalFilename();
		String orgFileNameWithoutExt = orgFileName.substring(0, orgFileName.lastIndexOf('.'));
		String rootPath = System.getProperty("catalina.home");
		jsonPath = rootPath + File.separator + "tmpFiles" + File.separator + "lukmon" +  File.separator  + orgFileNameWithoutExt  +"_JSON" + File.separator;;
		zipPath = rootPath + File.separator + "tmpFiles" + File.separator + "lukmon" +  File.separator;
		destinationDir =  rootPath + File.separator + "tmpFiles" + File.separator + "lukmon" +  File.separator + orgFileNameWithoutExt + File.separator;
		zipPath = zipPath  + orgFileName;
		
		// create a destination directory for storing the unzipped source codes.
		File dir = new File(destinationDir);
         if (!dir.exists())
             dir.mkdirs();
         
         // create a directory for storing the JSON files
        File jsonDir = new File(jsonPath);
         if (!jsonDir.exists())
        	 jsonDir.mkdirs();
        // create a path where the zip file transferred and assign msg2 the appropriate message     
        File zipPathNFile = new File(zipPath);
        
        long tStart = System.currentTimeMillis();
        
        // Use of the transferTo method of the File class to upload the zip file
		try{
			file.transferTo(zipPathNFile);
			msg2 = "lukmon" + ": You successfully uploaded your zipped source code, " + file.getOriginalFilename() ;
		}catch(IOException e){
			System.out.println(e.getMessage());
			msg2 =  "You failed to upload " + e.getMessage();
		}
		
		// unpackaging the zipped source codes to the destination directory 
		System.out.println("booyah");
		try{
			unzipUtil.unzip(zipPath,destinationDir);
			
		} catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		
		// deleting the folder containing the zip files
		zipPathNFile.delete();
		
		System.out.println("file is unzipped.");
		
		// Setting the RootDir and LogDir fields of the vizData object
		vizData.setRootDir(destinationDir);
		vizData.setLogDir(destinationDir);
		
		// create an array of two strings
		String [] collaboratorArrays = new String[2];
		
		// get the visualization data by calling the serializeVizData method of the Class VizData and 
		// assigning the return value to string array created earlier.
		try{
			System.out.println("Wrtinig Jacksons JSON...  ");
			collaboratorArrays = vizData.serializeVizData();
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}catch(ParseException ex){
			System.out.println(ex.getMessage());
		}
		
		// combine the two strings from the array to one string separated by semicolon ; and pass 
		// the resulting string to the createJson method of the VizData class.
		String jsonStr = collaboratorArrays[0] + ";" +  collaboratorArrays[1];
		//vizData.createJson(jsonStr, jsonPath);  
		
        deleteFolder(dir);
		
		//System.out.println("this is the name of file" + file.getOriginalFilename());

		return collaboratorArrays[1];
	}
	
	/**
	 * A method that deletes folders of the uploaded zipped files and their unpacked versions
	 * @param folder passed in as A File
	 */
	public static void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if(files!=null) { 
	        for(File f: files) {
	            if(f.isDirectory()) {
	                deleteFolder(f);
	            } else {
	                f.delete();
	            }
	        }
	    }
	    folder.delete();
	}

	public String getJsonPath() {
		return jsonPath;
	}

	public void setJsonPath(String jsonPath) {
		this.jsonPath = jsonPath;
	}	
}

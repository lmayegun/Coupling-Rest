package couplingviz.web.services;


import java.awt.Color;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import couplingviz.web.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lsbu.ac.uk.couplingviz.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * This Class generates the visualisation data and serialises it into JSON format.
 * It creates also JSON files of the generated visualisation data. 
 * @version 1.0, April 2017
 */
@Component
public class VizData {
	
	private String rootDir;
	private String logDir;
	private Collaborator collab;
	private Properties properties;
	private Coords coord;
	private TargetType targetType;
	
	/**
	 * A default constructor
	 */
	public VizData(){
	
	/**
	 * A constructor that takes two strings as parameter and initialises the rootDir and logDir
	 * fields
	 */
	}
	public VizData(String rootDir, String logDir){
		this.rootDir = rootDir;
		this.logDir = logDir;
	}
	
	/**
	 * A constructor that takes four autowired objects of the given classes and initialises the 
	 * corresponding fields. 
	 * @param collab passed in as Collaborator
	 * @param properties passed in as Properties
	 * @param coord passed in as Coords
	 * @param targetType passed in as TargetType
	 */
	@Autowired
	public VizData(Collaborator collab, Properties properties, Coords coord, TargetType targetType){
		this.collab = collab;
		this.properties = properties;
		this.coord = coord;
		this.targetType = targetType;
		
	}
	
	/**
	 * Gets ArrayList of the visualization data by utilising the existing CouplingViz program 
	 * which is integrated as JAR and accomodates them in the objects of the POJO classes which 
	 * are aggregated into one another.
	 * @return the visualisation data as an array of ArrayList of the Collaborator objects
	 * @throws IOException
	 */
	public  ArrayList<Collaborator>[] getVizData() throws IOException {
		 ArrayList<Collaborator>[] vizArray = new ArrayList[2];
		 try {
	           
	            Metrics metrics;
	            FileProcessor fp = new FileProcessor(rootDir, logDir);
	            System.out.println("In JsonSerializer " ); 
	            System.out.println(rootDir ); 
	            ArrayList<Line> linesIn = new ArrayList<>();
	            ArrayList<Line> linesOut = new ArrayList<>();
	    
	            fp.runProcessing();
	            linesIn = fp.getLinesFanin();
	            linesOut = fp.getLinesFanout();
	            ArrayList<Line>[] linesArray = new ArrayList[2];
	            linesArray[0] = linesIn;
	            linesArray[1] = linesOut;
	            int count = 0;
	            int foreign = 0;
	            int dirct = 0;
	            int nativ = 0; 
	            int intrface = 0; 
	            int birdsEyeTreshold = 50;
	            int numberOfTypeOfFans = 2;
	            int loopCount = 0;
	            ArrayList<Collaborator> faninArray = new ArrayList<>(); 
	            ArrayList<Collaborator> fanoutArray = new ArrayList<>(); 
	            
	            
	            for(int a = 0; a <linesArray.length; a++) {   
	                ArrayList<Collaborator> collabArrayList = new ArrayList<>();
	                
	                final long tStart  = System.currentTimeMillis();
	                int countOut = 0;
	                for(Line aLine: linesArray[a]){
	                	collab = new Collaborator();
	                	properties = new Properties();
	                	coord = new Coords();
	                	targetType = new TargetType();
		                countOut += 1;
		                metrics = aLine.getMetrics();
		                foreign = metrics.getInheritanceForeign();
		                dirct = metrics.getDirect();
		                nativ = metrics.getInheritanceNative();
		                intrface = metrics.getCBOWithAbstract();
		                String clsName1 = aLine.getClassName();
		                int pos1 = clsName1.indexOf('$');
		                if(pos1 == -1){
		                	clsName1 = "ID_" + clsName1.substring(pos1 +1);
	                    }else{
	                    	while(clsName1.contains("$")){
	                    		clsName1 = clsName1.substring(0, pos1) + clsName1.substring(pos1 + 1);
	                    		pos1 = clsName1.indexOf('$');
	                    	}
	                    	clsName1 = "ID_" + clsName1;
	                    }
		              
		                collab.setId(clsName1); 		             
		                collab.setPackagename(aLine.getPackageName());             
		                properties.setName(aLine.getClassName()); 
		                properties.setIsInterface(aLine.isInterface());
		                properties.setIsInnercalss(metrics.isInnerClass()); 
		                properties.setCBOCouplingViz(metrics.getCBOCouplingViz()); 
		                properties.setCBOTargetsOnly(metrics.getCBOTargetsOnly()); 
		                properties.setCBONoInheritance(metrics.getCBONoInheritance()); 
		                properties.setNoOfDirectcalss(metrics.getDirect()); 
		                properties.setNoOfCalssWithForeignInheritance(metrics.getInheritanceForeign()); 
		                properties.setNoOfCalssWithNativeInheritance(metrics.getInheritanceNative()); 
		                properties.setNoOfInterfaces(metrics.getCBOWithAbstract()); 
		                properties.setNoOfInterfaceDependencies(metrics.getInterfaceDependencies()); 
		                properties.setNoOfInterfaceOrAbstract(metrics.getInterfaceOrAbstract()); 
		                properties.setNoOfTotalCouples(metrics.getTotalCouples()); 
		                properties.setCouplingConstructors(metrics.getCouplingConstructors()); 
		                properties.setNoOfAncestorMethods(metrics.getAncestorMethods()); 
		                properties.setCBOWithAbstract(metrics.getCBOWithAbstract()); 

		                int rgb = 0;		               
		                if(metrics.getCBOWithAbstract() < birdsEyeTreshold){
		                    rgb = 255 - (metrics.getCBOWithAbstract()) * 255 / birdsEyeTreshold;
		                }else{
		                    rgb = 0;
		                }
		                Color c = new Color(rgb,rgb,rgb);
		                String hex  = Integer.toHexString(c.getRGB());		              
		                hex = hex.substring(2, hex.length());
		                hex = "#" + hex;   
		                
		                properties.setClr(hex); 
		                properties.setReserveClr("gray"); 

		                coord.setX(0); 
		                coord.setY(0); 

		                List<Coords> coords = new ArrayList<>();
		                coords.add(coord);
		                properties.setCoords(coords); 
		                
		                List<String>targets = new ArrayList<>();		              
		                final Set<String> destClasses1 = metrics.getCBOCouplingVizDetails();
		                String[] methodsList = null;
		                for(String dstCls:destClasses1){
		                	aLine.setTarget(true); 
		                	properties.setIsTarget(aLine.isTarget()); 
		                    String tempDstCls = dstCls;
		                    int pos2 = tempDstCls.lastIndexOf('.');
		                    tempDstCls = tempDstCls.substring(pos2 +1);
		                    pos2 = tempDstCls.lastIndexOf('$');
		                    String clsName ="";
		                    targetType = new TargetType();
		                    if(pos2 == -1){
		                    	tempDstCls = "ID_" + tempDstCls.substring(pos2 +1);
		                    }else{
		                    	while(tempDstCls.contains("$")){
		                    		tempDstCls = tempDstCls.substring(0, pos2) + tempDstCls.substring(pos2 + 1);
		                    		pos2 = tempDstCls.indexOf('$');
		                    	}		                    	
		                    	tempDstCls = "ID_" + tempDstCls;
		                    	if(tempDstCls.equalsIgnoreCase("ID_Task")){
		                    		System.out.println("ID_");
		                    	}
		                    	
		                    }
		                    clsName = tempDstCls.substring(3, tempDstCls.length());
		                    if(metrics.inDirectSet(dstCls)) {
	                    		 targetType.setIsDirectTarget(metrics.inDirectSet(dstCls));
		                    }else
		                    {
		                    	targetType.setIsDirectTarget(metrics.inDirectSet(dstCls));
		                    }
	                    	 if (metrics.inInterfaceSet(dstCls)) {
	                    		 targetType.setIsInterfaceTarget(metrics.inInterfaceSet(dstCls));
	                         }else
			                    {
	                        	 targetType.setIsInterfaceTarget(metrics.inInterfaceSet(dstCls));
			                    }
	                         if (metrics.inNativeInheritanceSet(dstCls)) {
	                        	 targetType.setIsLocalInheritanceTarget(metrics.inNativeInheritanceSet(dstCls));
	                         }else
			                    {
	                        	 targetType.setIsLocalInheritanceTarget(metrics.inNativeInheritanceSet(dstCls));
			                    }
	                         if (metrics.inForeignInheritanceSet(dstCls)) {
	                        	 targetType.setIsForeignInheritanceTarget(metrics.inForeignInheritanceSet(dstCls));
	                         }else
			                    {
	                        	 targetType.setIsForeignInheritanceTarget(metrics.inForeignInheritanceSet(dstCls));
			                    }
	                         
	                         properties.addTargetTypes(clsName, targetType); 
	                    	
	                         targetType = null;
	                         
		                  
		                    targets.add(tempDstCls);
		                   
		                    aLine.setTarget(false); 
		                    properties.setTargets(targets); 		                  
		                    List<String> targetMethodsOrFields = new ArrayList<String>();
		                    targetMethodsOrFields = metrics.getTargetCallsOrFieldAccessesFull(dstCls);
		                    ArrayList<String> methdsStr = new ArrayList<>();
		                    methodsList = new String[targetMethodsOrFields.size()];
		                    int countMethods = 0;
		                    for(String aMethod:targetMethodsOrFields){
		                        if(aMethod.contains("(") || aMethod.contains("(")){
		                          aMethod = aMethod.substring(0, aMethod.indexOf('(') + 1); 
		                          aMethod = aMethod + ")";
		                          
		                        }else{
		                          aMethod = aMethod.substring(0, aMethod.indexOf(" "));
		                          aMethod = aMethod + "()";
		                        }
		                        
		                        methdsStr.add(aMethod);
		                        methodsList[countMethods] = aMethod;
		                        countMethods++;

		                    }
		                     properties.addTargetMethods(tempDstCls, methdsStr);
		                 }
			             collab.setProperties(properties); 
			             
			             collabArrayList.add(collab);
			             
	            }
	            String[] lineArray = new String[2];
	            final long tFinish;
	        
	            System.out.println("Two lineArray lists ");
	            if(a == 0){
	            	faninArray = collabArrayList;
	            	vizArray[0] = collabArrayList;
	            	tFinish = System.currentTimeMillis() - tStart;
	            	System.out.println("Fanin processing time is gfgf" + tFinish);
	        
	            }else{
	            	fanoutArray = collabArrayList;
	            	vizArray[1] = collabArrayList;
	            	tFinish = System.currentTimeMillis() - tStart;
	            	System.out.println("Fanout processing time is dfdf " + tFinish);
	         
	            }
	        }  
	           
	            
	            System.out.println("Fanin lists new");

		 } catch (IOException ex) {
			 System.out.println(ex.getMessage());
	     }
		 return vizArray;
	}
	
	/**
	 * Serialises the visualisation data  into JSON format
	 * @return the JSON formatted visualisation data as an array of JSON strings
	 * @throws IOException
	 * @throws ParseException
	 */
	public String[] serializeVizData() throws IOException, ParseException{
		 ObjectMapper mapper = new ObjectMapper();
		 String[] collaboratorArrays = new String[2];
		 ArrayList<Collaborator>[] vizArray = new ArrayList[2];
		 
		 mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
         mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
         mapper.setSerializationInclusion(Include.NON_EMPTY);
         
         
         vizArray = getVizData();
         collaboratorArrays[0] = mapper.writeValueAsString(vizArray[0]);
         collaboratorArrays[1] = mapper.writeValueAsString(vizArray[1]);
         
       
        String jsonStr = collaboratorArrays[0] + ";" +  collaboratorArrays[1];
        createJson(jsonStr, rootDir);
       
         
         return collaboratorArrays;

	}
	
	/**
	 * Creates JSON files from the visualisation data and stores them in a dedicated directory
	 * @param jsonString JSON formatted visualisation data passed as string
	 * @param destinationDir destination directory for storing the JSON files passed as string
	 */
	public void createJson(String jsonString, String destinationDir){
		String fileName = destinationDir.substring(0,destinationDir.length()-1);
		int pos = fileName.lastIndexOf(File.separator.charAt(0)); 
		System.out.println("The pos1 is: " + pos + File.separator.charAt(0));
		
		System.out.println("The file name is at 0: " + fileName);
		System.out.println("The pos2 is: " + pos);
		fileName = destinationDir.substring(pos,fileName.length());
		System.out.println("The file name is at pos2: " + fileName);
		String fanin = destinationDir +   fileName + "_fanin.json";  
		String fanout =  destinationDir + fileName + "_fanout.json"; 
		System.out.println("The file names are: " + fanin + "   and   " + fanout);
		jsonString = jsonString.trim();
		String[] jsonStrArray =  jsonString.split(";");
		String fanIn = jsonStrArray[0];
		String fanOut = jsonStrArray[1];
		try{			
			byte[] buffer = fanIn.getBytes();
			byte[] buffer1 = fanOut.getBytes();
			
			FileOutputStream outputStream =
	                new FileOutputStream(fanin);
			FileOutputStream outputStream1 =
	                new FileOutputStream(fanout);
			
			 outputStream.write(buffer);
			 outputStream1.write(buffer1);
			 outputStream.close(); 
			 outputStream1.close();
		}catch(IOException ex){

			System.out.println(ex.getMessage()); 
		}

	
	}
	
	
	public String getRootDir() {
		return rootDir;
	}

	public void setRootDir(String rootDir) {
		this.rootDir = rootDir;
	}

	public String getLogDir() {
		return logDir;
	}

	public void setLogDir(String logDir) {
		this.logDir = logDir;
	}

	public Collaborator getCollab() {
		return collab;
	}
	public void setCollab(Collaborator collab) {
		this.collab = collab;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public Coords getCoord() {
		return coord;
	}
	public void setCoord(Coords coord) {
		this.coord = coord;
	}
	
	public TargetType getTargetType() {
		return targetType;
	}
	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
	}
	
}

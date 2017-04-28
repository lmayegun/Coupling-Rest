package couplingviz.web.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import couplingviz.web.controller.FileProcessController;
import couplingviz.web.domain.Collaborator;
import couplingviz.web.domain.Coords;
import couplingviz.web.domain.Properties;
import couplingviz.web.domain.TargetType;
import couplingviz.web.services.VizData;
import couplingviz.web.services.UnzipUtility;

/**
 * A configuration class with ComponentScan scanning for classes to be created as beans. 
 * @author L. Mayegun
 * @version 1.0, April 2017
 */
@Configuration
@ComponentScan(basePackageClasses = { VizData.class, UnzipUtility.class, FileProcessController.class, 
									  Collaborator.class, Coords.class, Properties.class, TargetType.class})		
public class WebAppContextConfig {

}

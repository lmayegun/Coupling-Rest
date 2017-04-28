package couplingviz.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Registers and configures DispatcherServlet 
 * @author Lukmon Mayegun 
 * @version 1.0, April 2017
 */
@Configuration
public class CouplingVizWebApplicationInitializer implements WebApplicationInitializer{

	private static final Class<?>[] configurationClasses = new Class<?>[] { WebMvcContextConfiguration.class, WebAppContextConfig.class}; 
	private static final String DISPATCHER_SERVLET_NAME = "couplingvizmvcweb-dispatcher";
	
	/**
	 * Overrides the OnStartup method of the interface to initialise the web application
	 * by configuring the DispatcherServlet with WebMvcContextConfiguration and WebAppContextConfig
	 * as application contexts. Adds also some mappings to the dispatcher. 
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootCtx = new AnnotationConfigWebApplicationContext();
		rootCtx.register(configurationClasses);
		
		servletContext.addListener(new ContextLoaderListener(rootCtx));
		AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext(); 
		webCtx.register(configurationClasses);
		DispatcherServlet dispatcherServler = new DispatcherServlet(webCtx);
		 
		ServletRegistration.Dynamic servlet = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServler);
		servlet.addMapping("/");
		servlet.addMapping("/resources/*");
		servlet.addMapping("/CouplingVizMVCWeb/");
		 
		servlet.setLoadOnStartup(1);
		
	}
	
	
		
}

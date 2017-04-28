package  couplingviz.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * A configuration class that enables the MVC feature of the web application.
 * @author L. Mayegun
 * @version 1.0, April 2017
 */
@Configuration			// setting this file as configuration file
@EnableWebMvc			// enabling Spring MVC
public class WebMvcContextConfiguration extends WebMvcConfigurerAdapter {

	/**
	 * configuring handler mapping for routing requests to the right controller
	 * @return the handler mapping as BeanNameUrlHandlerMapping
	 */
	@Bean
	BeanNameUrlHandlerMapping handlerMapping (){
		BeanNameUrlHandlerMapping beanNameUrlHandlerMapping = new BeanNameUrlHandlerMapping();
		return beanNameUrlHandlerMapping;
	}
	
	/**
	 * configuring static content handling
	 */
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
			configurer.enable();
			}

	/**
	 * setting the maximum upload size
	 * @return the multipart resolver as CommonsMultipartResolver
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cmpr = new CommonsMultipartResolver();
		cmpr.setMaxUploadSize(50000000);
		return cmpr;
	}	
}

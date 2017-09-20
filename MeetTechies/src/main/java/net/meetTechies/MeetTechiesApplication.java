package net.meetTechies;

//import net.meetTechies.customDispatchers.DispatcherServletInitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableAutoConfiguration
public class MeetTechiesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MeetTechiesApplication.class, args);
		//System.out.println(REQUEST_HEADER_ACCESS_CONTROL_REQUEST_METHOD);
	}
	
	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DispatcherServletInitializer.class,MeetTechiesApplication.class);
    }*/
}

package com.example.demo;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@SpringBootApplication
@RestController
@EnableAutoConfiguration

public class Springbootdemo1Application  extends SpringBootServletInitializer {

	@RequestMapping("/")
	String home() {
		return " demo1 home jpa ";
	}
	
	@RequestMapping("/new")
	String newCall() {
		return " demo1 new ";
	}
	
	@RequestMapping("/sqldb/{usr}/{psw}")
	String sqldb(@PathVariable String usr, @PathVariable String psw) {
		Sqldbsetting s = new Sqldbsetting();
		Sqldbsetting.savesetting(usr,psw);
		String r = s.getsetting();
		return r;
	}
	
	public String setApplicationContext(ApplicationContext applicationContext) {
	        //System.out.println(applicationContext.getClass().getName());
			String s=applicationContext.getClass().toString();
	        return s+applicationContext.getClass().getName();
	}
	
	  
    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	      return builder.sources(Springbootdemo1Application.class);
	  }
	
	
	public static void main(String[] args) {
		SpringApplication.run(Springbootdemo1Application.class, args);
	}
	
	
  
	

}

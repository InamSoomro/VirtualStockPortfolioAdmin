package com.webmedia.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestController {
	
	
	public static void main(String args[]){
	       
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
		        new String[] {"applicationContext.xml"});
		// of course, an ApplicationContext is just a BeanFactory
		BeanFactory factory = (BeanFactory) appContext;
		
		com.webmedia.service.PortfolioItemManager manager = (com.webmedia.service.PortfolioItemManager)factory.getBean("securityManager");
		manager.getPortfolioItems();
		System.out.print(manager.getPortfolioItems().size());
		        
    }
	

}

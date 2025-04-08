/**
 * 
 */
package com.webmedia.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.webmedia.controller.PortfolioController;
import com.webmedia.dao.InMemoryPortfolioItemDAO;
import com.webmedia.domain.PorfolioItem;
import com.webmedia.service.PortfolioItemManagerImp;

import junit.framework.TestCase;

/**
 * @author inam
 *
 */
public class PortfolioControllerTest extends TestCase {
	
	
	public void testHandleRequestView() throws Exception{
        PortfolioController controller = new PortfolioController();
        PortfolioItemManagerImp portfolioItemManager = new PortfolioItemManagerImp();
        portfolioItemManager.setPortfolioItemDAO(new InMemoryPortfolioItemDAO(new ArrayList<PorfolioItem>()));
        controller.setPortfolioItemManager(portfolioItemManager);
        //controller.setSecurityManager(new SecurityManagerImp() );
        ModelAndView modelAndView = controller.handleRequest(null, null);
        assertEquals("portfolio", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        //String nowValue = (String) modelAndView.getModel().get("now");
        @SuppressWarnings("unchecked")
		Map<String,Object> modelMap = (Map<String,Object>) modelAndView.getModel().get("securitymodel");
        PorfolioItem nowValue = (PorfolioItem) modelMap.get("securitymodel");
        assertNull(nowValue);
    }
	
	

}

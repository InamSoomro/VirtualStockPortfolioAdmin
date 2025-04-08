/**
 * 
 */
package com.webmedia.service;

import java.util.ArrayList;
import java.util.List;

import com.webmedia.dao.PortfolioItemDAO;
import com.webmedia.dao.InMemoryPortfolioItemDAO;
import com.webmedia.domain.PorfolioItem;
import com.webmedia.service.PortfolioItemManagerImp;

import junit.framework.TestCase;

/**
 * @author inam
 *
 */
public class PortfolioItemManagerImpTest extends TestCase {

	
	 private PortfolioItemManagerImp portfolioItemManager;
    
	 private List<PorfolioItem> pItems;
	    
	    private static int COUNT = 2;
	    
	    private static Double BUYING1 = new Double(20.50);
	    private static Double SELLING1 = new Double(21.50);
	    private static String SYMBOL1 = "DELL";
	    
	    private static Double BUYING2 = new Double(22.50);
	    private static Double SELLING2 = new Double(23.50);
	    private static String SYMBOL2 = "EBAY";
	    
	 
	 
	    protected void setUp() throws Exception {
	    	
	    	portfolioItemManager = new PortfolioItemManagerImp();
	        pItems = new ArrayList<PorfolioItem>();
	        
	        // stub up a list of portfolio ITems
	        PorfolioItem pItem = new PorfolioItem();
	        pItem.setSelling(SELLING1);
	        pItem.setBuying(BUYING1);
	        pItem.setSymbol(SYMBOL1);
	        pItems.add(pItem);
	        
	        pItem = new PorfolioItem();
	        pItem.setSelling(SELLING2);
	        pItem.setBuying(BUYING2);
	        pItem.setSymbol(SYMBOL2);
	        pItems.add(pItem); 
	    
	        PortfolioItemDAO portfolioItemDAO = new InMemoryPortfolioItemDAO(pItems);
		    portfolioItemManager.setPortfolioItemDAO(portfolioItemDAO);

	    
	    }
	    
	    
	    public void testGetPortfolioItemsWithNoPortfolioItems() {
	    	portfolioItemManager = new PortfolioItemManagerImp();
	    	portfolioItemManager.setPortfolioItemDAO(new InMemoryPortfolioItemDAO(null));
	        assertNull(portfolioItemManager.getPortfolioItems());
	    }

	    
	    public void testGetPortfolioItems() {
	        List<PorfolioItem> porfolioItem = portfolioItemManager.getPortfolioItems();
	        assertNotNull(porfolioItem);        
	        assertEquals(portfolioItemManager.getPortfolioItems().size(), portfolioItemManager.getPortfolioItems().size());
	        
	    }   
	
	
}

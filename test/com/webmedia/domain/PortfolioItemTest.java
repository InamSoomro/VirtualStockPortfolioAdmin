package com.webmedia.domain;

import com.webmedia.domain.PorfolioItem;

import junit.framework.TestCase;

public class PortfolioItemTest extends TestCase {
	
	
	 private PorfolioItem pItem;

	    protected void setUp() throws Exception {
	    	pItem = new PorfolioItem();
	    }

	    public void testSetAndGetSelling() {
	        double testSelling = 0.0;
	        assertEquals(0, 0, 0);
	        pItem.setSelling(testSelling);
	        assertEquals(testSelling, pItem.getSelling(),0);
	    }
	    
	    public void testSetAndGetBuying() {
	        double testBuying = 100.0;
	        assertEquals(0, 0, 0); 
	        pItem.setBuying(testBuying);
	        assertEquals(testBuying, pItem.getBuying(),0);
	    }

	    public void testSetAndGetCompany() {
	        String company = "DELL Inc";
	        assertNull(pItem.getSymbol());    
	        pItem.setCompany(company);
	        assertEquals(company, pItem.getCompany());
	    }
	    
	    public void testSetAndGetSymbol() {
	        String testSymbol = "NYK";
	        assertNull(pItem.getSymbol());
	        pItem.setSymbol(testSymbol);
	        assertEquals(testSymbol, pItem.getSymbol());
	    }

}

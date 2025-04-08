package com.webmedia.dao;

import java.util.List;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

import com.webmedia.dao.PortfolioItemDAO;
import com.webmedia.domain.PorfolioItem;

@SuppressWarnings("deprecation")
public class SecurityDAOImplTest extends AbstractTransactionalDataSourceSpringContextTests {

	
	
	 private PortfolioItemDAO portfolioItemDAO;

	    
	    public void setSecurityDAO(PortfolioItemDAO portfolioItemDAO) {
	        this.portfolioItemDAO = portfolioItemDAO;
	    }

	    @Override
	    protected String[] getConfigLocations() {
	        return new String[] {"classpath:test-context.xml"};
	    }

	    @Override
	    protected void onSetUpInTransaction() throws Exception {
	        super.deleteFromTables(new String[] {"PortfolioItem"});
	        //super.executeSqlScript("file:db/load_data.sql", true);
	    }

	    public void testGetSecurityList() {
	        
	        List<PorfolioItem> pItem = portfolioItemDAO.getPortfolioItemList();
	        
	        assertEquals("wrong number of Securities?", pItem.size(), pItem.size());
	        
	    }
	
	
	
	
}

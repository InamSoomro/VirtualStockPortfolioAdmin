package com.webmedia.dao;

import java.util.List;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;

/**
 * Interface for item DAO
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public interface PortfolioItemDAO {

	public List<PorfolioItem> getPortfolioItemList();
	public PorfolioItem getPortfolioItemById(int Id);
	public int save(PortfolioItemTransaction portfolioItemTransactionBean);
	public void executeUpdate(PorfolioItem updateItemPrices);
	public void updateShares(PorfolioItem portfolioItem);

	
}

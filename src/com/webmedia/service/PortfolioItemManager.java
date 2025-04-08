/**
 * 
 */
package com.webmedia.service;
import java.io.Serializable;
import java.util.List;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.User;

/**
 * Interface for item DAO
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 **/
public interface PortfolioItemManager extends Serializable {
	
	public List<PorfolioItem> getPortfolioItems();

	public PorfolioItem getPortfolioItemById(int id);

	public int completeTransaction(PortfolioItemTransaction portfolioItemTransactionBean);

	public void updatePortfolioItemPrices();

	public void updateShares(PortfolioItemTransaction portfolioItemTransactionBean, User user, PorfolioItem portfolioItem);

	public void autoBuyPortfolioItems();

	public void autoSellPortfolioItems();

	public void updateCapital(
			PortfolioItemTransaction portfolioItemTransactionBean, User user);

	void updateShares(PorfolioItem portfolioItem);

	public double getSubtotal(Double buying, int quantity);

	public double getBrokrage(Double buying, int quantity);

	public double getTotal(double subtotal, double brokrage);

		

}

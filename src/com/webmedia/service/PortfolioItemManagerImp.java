package com.webmedia.service;

import java.sql.SQLException;
import java.util.List;

import com.webmedia.dao.PortfolioItemDAO;
import com.webmedia.dao.PortfolioItemDAOImp;

import com.webmedia.domain.PorfolioItem;
import com.webmedia.domain.PortfolioItemTransaction;
import com.webmedia.domain.User;

/**
 * A class responsible for any business logic for making the transactions
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class PortfolioItemManagerImp implements PortfolioItemManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PorfolioItem> portfolioItems;
	PorfolioItem portfolioItem;
	private PortfolioItemDAO portfolioItemDAO;
	private UserManager userManager;

	/**
	 * Method will return PortfolioItems
	 * 
	 * @param None
	 * @return A list of ItemPortfolio
	 * 
	 **/
	@Override
	public List<PorfolioItem> getPortfolioItems() {
		return portfolioItemDAO.getPortfolioItemList();
	}

	public PortfolioItemDAO getPortfolioItemDAO() {
		return portfolioItemDAO;
	}

	/**
	 * Setter Method for injecting PortfolioItemDAO object
	 * 
	 * @param portfolioItemDAO
	 * @return None
	 **/
	public void setPortfolioItemDAO(PortfolioItemDAO portfolioItemDAO) {
		this.portfolioItemDAO = portfolioItemDAO;
	}

	/**
	 * Method will return PortfolioItem by ID
	 * 
	 * @param id
	 * @return A Single object of ItemPortfolio
	 * 
	 **/
	@Override
	public PorfolioItem getPortfolioItemById(int id) {
		return portfolioItemDAO.getPortfolioItemById(id);
	}

	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * Setter Method for injecting UserManager object
	 * 
	 * @param portfolioItemDAO
	 * @return None
	 **/
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * Method will processes the transaction and completes it
	 * 
	 * @param PortfolioItemTransaction
	 * @return int
	 **/
	@Override
	public int completeTransaction(
			PortfolioItemTransaction portfolioItemTransactionBean) {
		return portfolioItemDAO.save(portfolioItemTransactionBean);

	}

	/**
	 * Method will update item prices, it is also called from autojob task that
	 * randomly updates the prices
	 * 
	 * @param PortfolioItemTransaction
	 * @return int
	 **/
	@Override
	public void updatePortfolioItemPrices() {
		// checks if injections work, if not it will create an instance.
		if (this.portfolioItemDAO == null) {
			this.portfolioItemDAO = new PortfolioItemDAOImp();
		}
		List<PorfolioItem> portfolioItems = portfolioItemDAO
				.getPortfolioItemList();

		for (PorfolioItem portfolioItem : portfolioItems) {
			this.updatePortfolioItems(portfolioItem);
		}
	}

	/**
	 * Method will update items and is called from updatePortfolioItemPrices()
	 * 
	 * @param PorfolioItem
	 * @return None
	 **/
	private void updatePortfolioItems(PorfolioItem portfolioItem) {
		PorfolioItem pitem = this.updateItemPrices(portfolioItem);
		portfolioItemDAO.executeUpdate(pitem);

	}

	/**
	 * Method will update items prices, it will update the prices randomly
	 * 
	 * @param PortfolioItem
	 *            ;
	 * @return updatedPortfolioItem;
	 **/
	private PorfolioItem updateItemPrices(PorfolioItem currentPortfolioItem) {

		PorfolioItem updatedPortfolioItem = currentPortfolioItem;

		double randomPriceChange = (Math.random() * 100);
		double currentBuyingPrice = updatedPortfolioItem.getBuying();
		double currentSellingPrice = updatedPortfolioItem.getSelling();
		double updatedBuyingPrice;
		double updatedSellingPrice;

		if (currentBuyingPrice < 50 && currentSellingPrice < 50) {
			updatedBuyingPrice = currentBuyingPrice + randomPriceChange;
			updatedSellingPrice = currentSellingPrice + randomPriceChange;
		} else {
			updatedBuyingPrice = currentBuyingPrice - randomPriceChange;
			updatedSellingPrice = currentSellingPrice - randomPriceChange;
		}

		updatedPortfolioItem.setId(currentPortfolioItem.getId());
		updatedPortfolioItem.setBuying(updatedBuyingPrice < 0 ? 10.0
				: updatedBuyingPrice);
		updatedPortfolioItem.setSelling(updatedSellingPrice < 0 ? 11.0
				: updatedSellingPrice);

		return updatedPortfolioItem;
	}

	/**
	 * Method will Call the DAO and persist the updated value
	 * 
	 * @param PortfolioItem
	 *            ;
	 * @return updatedPortfolioItem;
	 **/
	@Override
	public void updateShares(PorfolioItem portfolioItem) {
		portfolioItemDAO.updateShares(portfolioItem);

	}

	/**
	 * Method is resposible for auto-transaction
	 * 
	 * @param None
	 * @return None
	 **/
	@Override
	public void autoBuyPortfolioItems() {
		List<PorfolioItem> pItem = this.portfolioItemDAO.getPortfolioItemList();
		PortfolioItemTransaction portfolioItemTransactionBean;
		for (PorfolioItem portfolioItem : portfolioItems) {
			if (portfolioItem.getAutoBuy() == 1) {
				if (portfolioItem.getAutoBuyLimit() == portfolioItem
						.getBuying()) {
					portfolioItemTransactionBean = new PortfolioItemTransaction();
					portfolioItemTransactionBean
							.setPortfolioItemId(portfolioItem.getId());
					portfolioItemTransactionBean.setPortfolioUserId(2);
					portfolioItemTransactionBean.setQuantity(1);
					portfolioItemTransactionBean.setTransactionType("BUY");
					this.completeTransaction(portfolioItemTransactionBean);
				}

			}

			this.updatePortfolioItems(portfolioItem);
		}

	}

	/**
	 * Method is resposible for auto-transaction
	 * 
	 * @param None
	 * @return None
	 **/
	@Override
	public void autoSellPortfolioItems() {
		// TODO Auto-generated method stub

	}

	/**
	 * Method is resposible for updating the shares, by deducting and adding the
	 * current shares
	 * 
	 * @param PortfolioItemTransaction
	 *            , User,PorfolioItem
	 * @return None
	 **/
	public void updateShares(
			PortfolioItemTransaction portfolioItemTransactionBean, User user,
			PorfolioItem pItem) {

		PorfolioItem portfolioItem = pItem;
		Integer currentShares = portfolioItem.getShares();
		Integer updatedShares;
		Integer currentQuantity = portfolioItemTransactionBean.getQuantity();

		if (portfolioItemTransactionBean.getTransactionType().equals("BUY")) {
			updatedShares = currentShares + currentQuantity;
		} else {
			updatedShares = currentShares - currentQuantity;
		}
		portfolioItem.setShares(updatedShares);
		this.updateShares(portfolioItem);

	}

	/**
	 * Method is resposible for updating the Capital, by deducting and adding
	 * the current Capital
	 * 
	 * @param PortfolioItemTransaction
	 *            , User,PorfolioItem
	 * @return None
	 **/
	public void updateCapital(
			PortfolioItemTransaction portfolioItemTransactionBean, User usr) {
		User user = usr;
		Double currentCapital = user.getCurrentCapital();
		Double currentTotal = portfolioItemTransactionBean.getTotal();
		Double updatedCapital;
		if (portfolioItemTransactionBean.getTransactionType().equals("BUY")) {
			updatedCapital = currentCapital - currentTotal;

		} else {
			updatedCapital = currentCapital + currentTotal;
		}
		user.setCurrentCapital(updatedCapital);
		// update the capital in userTable
		this.userManager.updateCurrentCapital(user);

	}

	/**
	 * method for calculating the total price for transaction
	 * 
	 * @param double subtotal, double brokerage
	 * @return addition of params
	 **/
	@Override
	public double getTotal(double subtotal, double brokerage) {
		return subtotal + brokerage;
	}

	/**
	 * method for calculating the subtotal for transaction
	 * 
	 * @param double buying, int quantity
	 * @return unit price multiply with quantity
	 **/
	@Override
	public double getSubtotal(Double buying, int quantity) {
		return buying * quantity;

	}

	/**
	 * method for calculating the broker fees for transaction
	 * 
	 * @param double buying, int quantity
	 * @return 15% of subtotal
	 **/
	@Override
	public double getBrokrage(Double buying, int quantity) {
		return ((getSubtotal(buying, quantity) * 15) / 100);
	}
}

package com.webmedia.domain;

import java.io.Serializable;


/**
 * This is a class for PortfolioItems reflecting the portfolioitem table in the database.
 * containing the getter and setter methods of the variables defined
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
  
public class PorfolioItem implements Serializable {
				//PortfolioSecurityBean
	/**
	 * 
	 */
	private static final long serialVersionUID = 6100068519975786655L;
	
	/**
	 * bean defination of the PortfolioItem also reflecting the table fields
	 */
	private int id;
	private String company;
	private String symbol;
	private Integer shares;
	private Double buying;
	private Double selling;
	private Integer quantity;
	private Integer autoBuy;
	private Integer autoSell;
	private Double autoBuyLimit;
	private Double autoSellLimit;
	
	
	
	
	public int getId() {
		return id;
	}
	/**
	 * setter Method for PortfolioItem ID
	 * @param ID
	 * @return None
	 **/
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSymbol() {
		return symbol;
	}
	/**
	 * setter Method for portfolio Item Symbol
	 * @param Symbol
	 * @return None
	 **/
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public Double getBuying() {
		return buying;
	}
	/**
	 * setter Method for buying portfolioitem
	 * @param buying
	 * @return None
	 **/
	public void setBuying(Double buying) {
		this.buying = buying;
	}
	public Double getSelling() {
		return selling;
	}
	/**
	 * setter Method for selling portfolioitem
	 * @param selling
	 * @return None
	 **/
	public void setSelling(Double selling) {
		this.selling = selling;
	}
	
	 public Integer getQuantity() {
		return quantity;
	}
	 /**
		 * setter Method for Quantity of the PortfolioItems
		 * @param quantity
		 * @return None
		 **/
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public String getCompany() {
		return company;
	}
	/**
	 * setter Method for CompanyName
	 * @param company
	 * @return None
	 **/
	public void setCompany(String company) {
		this.company = company;
	}
	public Integer getShares() {
		return shares;
	}
	/**
	 * setter Method for shares for PortfolioItem
	 * @param PortfolioItemManager
	 * @return None
	 **/
	public void setShares(Integer shares) {
		this.shares = shares;
	}
	
	
	public Integer getAutoBuy() {
		return autoBuy;
	}
	/**
	 * setter Method for AutoBuy portfolioItem
	 * @param autoBuy
	 * @return None
	 **/
	public void setAutoBuy(Integer autoBuy) {
		this.autoBuy = autoBuy;
	}
	public Integer getAutoSell() {
		return autoSell;
	}
	/**
	 * setter Method for AutoSell portfolioItem
	 * @param autoSell
	 * @return None
	 **/
	public void setAutoSell(Integer autoSell) {
		this.autoSell = autoSell;
	}
	public Double getAutoBuyLimit() {
		return autoBuyLimit;
	}
	/**
	 * setter Method for AutoBuyLimit portfolioItem
	 * @param autoBuyLimit
	 * @return None
	 **/
	public void setAutoBuyLimit(Double autoBuyLimit) {
		this.autoBuyLimit = autoBuyLimit;
	}
	public Double getAutoSellLimit() {
		return autoSellLimit;
	}
	
	/**
	 * setter Method for AutoSell limit portfolioItem
	 * @param autoselllimit
	 * @return None
	 **/
	public void setAutoSellLimit(Double autoSellLimit) {
		this.autoSellLimit = autoSellLimit;
	}
	
	public String toString() {
	        StringBuffer buffer = new StringBuffer();
	        buffer.append("Buying: " + this.buying);
	        buffer.append("Selling: " + this.selling + ";");
	        
	        return buffer.toString();
	    }
	
	
	

}

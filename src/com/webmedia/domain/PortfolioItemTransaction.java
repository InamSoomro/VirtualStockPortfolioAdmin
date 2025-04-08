/**
 * 
 */
package com.webmedia.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * A class for PortfolioItemTransaction reflecting the portfolioitemTransaction table in the database.
 * containing the getter and setter methods of the variables defined
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/

public class PortfolioItemTransaction implements Serializable {

	
	private int id;
	private int portfolioUserId;
	private int portfolioItemId;
	private int quantity;
	private double brokarage;
	private double tax;
	private double subtotal;
	private double total;
	private String transactionType;
	private Date transactionDate;
	
	public int getId() {
		return id;
	}
	/**
	 * setter Method for PortfolioItemTransaction ID
	 * @param ID
	 * @return None
	 **/
	public void setId(int id) {
		this.id = id;
	}
	public int getPortfolioUserId() {
		return portfolioUserId;
	}
	/**
	 * setter Method for PortfolioUser ID
	 * @param ID
	 * @return None
	 **/
	public void setPortfolioUserId(int portfolioUserId) {
		this.portfolioUserId = portfolioUserId;
	}
	public int getPortfolioItemId() {
		return portfolioItemId;
	}
	/**
	 * setter Method for PortfolioItem ID
	 * @param ID
	 * @return None
	 **/
	public void setPortfolioItemId(int portfolioItemId) {
		this.portfolioItemId = portfolioItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	/**
	 * setter Method for PortfolioItem quantity
	 * @param quantity
	 * @return None
	 **/
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getBrokarage() {
		return brokarage;
	}
	/**
	 * setter Method for PortfolioItem brokerage 
	 * @param brokerage
	 * @return None
	 **/
	public void setBrokarage(double brokarage) {
		this.brokarage = brokarage;
	}
	public double getTax() {
		return tax;
	}
	/**
	 * setter Method for PortfolioItem Tax
	 * @param tax
	 * @return None
	 **/
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getSubtotal() {
		return subtotal;
	}
	/**
	 * setter Method for PortfolioItem subtotal
	 * @param subtotal
	 * @return None
	 **/
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTotal() {
		return total;
	}
	/**
	 * setter Method for PortfolioItem total
	 * @param total
	 * @return None
	 **/
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * setter Method for TransactionType
	 * @param TransactionType
	 * @return None
	 **/
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	/**
	 * setter Method for TransactionDate
	 * @param ID
	 * @return None
	 **/
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

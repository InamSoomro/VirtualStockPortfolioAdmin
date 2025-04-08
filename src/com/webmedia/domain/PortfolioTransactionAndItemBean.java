package com.webmedia.domain;

/**
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 *
 **/
public class PortfolioTransactionAndItemBean {
	
	private Integer id;
	private Integer portfolioUserId;
	private Integer portfolioItemId;
	private Integer quantity;
	private Double subtotal;
	private String transactionDate;
	private String transactionType;
	private Double brokarage;
	private Double total;
	private String companyName;
	private String symbol;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPortfolioUserId() {
		return portfolioUserId;
	}
	public void setPortfolioUserId(Integer portfolioUserId) {
		this.portfolioUserId = portfolioUserId;
	}
	public Integer getPortfolioItemId() {
		return portfolioItemId;
	}
	public void setPortfolioItemId(Integer portfolioItemId) {
		this.portfolioItemId = portfolioItemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getBrokarage() {
		return brokarage;
	}
	public void setBrokarage(Double brokarage) {
		this.brokarage = brokarage;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	
	

}

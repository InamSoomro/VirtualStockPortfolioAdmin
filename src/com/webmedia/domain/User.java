/**
 * 
 */
package com.webmedia.domain;

/**
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 *
 */
public class User {
	
	private int Id;
	private String userName;
	private String password;
	private double startupCapital;
    private double currentCapital;	
	
	public int getId() {
		return Id;
	}
	
	/**
	 * setter Method for UserId
	 * @param ID
	 * @return None
	 **/
	public void setId(int id) {
		Id = id;
	}
	
	public String getUserName() {
		return userName;
	}
	
	/**
	 * setter Method for UserName
	 * @param userName
	 * @return None
	 **/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	/**
	 * setter Method for Userpassword
	 * @param ID
	 * @return None
	 **/
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public double getStartupCapital() {
		return startupCapital;
	}

	/**
	 * setter Method for StartupCapital
	 * @param ID
	 * @return None
	 **/
	public void setStartupCapital(double startupCapital) {
		this.startupCapital = startupCapital;
	}

	public double getCurrentCapital() {
		return currentCapital;
	}

	/**
	 * setter Method for currentCapital
	 * @param ID
	 * @return None
	 **/
	public void setCurrentCapital(double currentCapital) {
		this.currentCapital = currentCapital;
	}	
	
	
	
	

}

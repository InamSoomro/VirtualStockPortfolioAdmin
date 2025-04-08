/**
 * 
 */
package com.webmedia.quartzscheduler;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.webmedia.service.PortfolioItemManager;
import com.webmedia.service.PortfolioItemManagerImp;

/**
 * A class is responsible for autojob, automatically updating the prices of PortfolioItems * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class JobScheduler implements Job {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	private PortfolioItemManager portfolioItemManager;

	/*
	 * 
	 * (non-Javadoc)
	 * @Param JobExecutionContext
	 * @throws JobExecutionException, Exception
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext context)throws JobExecutionException {

		logger.info("context.getFireTime(): " + context.getFireTime());
		logger.info("context.getJobDetail(): " + context.getJobDetail());
		logger.info("context.getNextFireTime(): " + context.getNextFireTime());
		logger.info("context.getPreviousFireTime(): "+ context.getPreviousFireTime());

		try {
			if (this.portfolioItemManager == null) {
				this.portfolioItemManager = new PortfolioItemManagerImp();
			}
			this.portfolioItemManager.updatePortfolioItemPrices();
			// this.portfolioItemManager.autoBuyPortfolioItems();
			// this.portfolioItemManager.autoSellPortfolioItems();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public PortfolioItemManager getPortfolioItemManager() {
		return portfolioItemManager;
	}


	/**
	 * setter Method for injecting the UserManager Object
	 * @param UserManager
	 * @return None
	 **/
	public void setPortfolioItemManager(PortfolioItemManager portfolioItemManager) {
		this.portfolioItemManager = portfolioItemManager;
	}

}

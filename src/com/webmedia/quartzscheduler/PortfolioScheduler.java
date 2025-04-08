/**
 * 
 */
package com.webmedia.quartzscheduler;

import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;


/**
 * A Servlet class overriding the init method, automatically called from the deployement descriptor
 * 
 * @author Inam Soomro
 * @version 1.0
 * @since 2011-12
 * 
 **/
public class PortfolioScheduler extends HttpServlet{
	
	/** Logger for this class and subclasses */
    protected final  Log logger = LogFactory.getLog(getClass());
    
    
    @Override
    public void init(){
    	startJob();
    }
    
    /**
	 * Method for starting the autojob and setting the preferences for event to be trigger
	 *  on particular time of instance 
	 * @param None
	 * @return None
	 **/    
	public  void startJob(){
		try{
			 logger.info("Scheduler started successfully");
			JobScheduler task = new JobScheduler();
			 
	    	//scheduler task details
	    	JobDetail job = new JobDetail();
	    	job.setName("PortfolioSchedulerJob");
	    	job.setJobClass(JobScheduler.class);
	 
	    	Map dataMap = job.getJobDataMap();
	    	dataMap.put("PortfolioSchedulerJobTask", task);
	 
	    	//configure the scheduler time
	    	SimpleTrigger trigger = new SimpleTrigger();
	    	trigger.setName("PortfolioScheduler");
	    	trigger.setStartTime(new Date(System.currentTimeMillis() + 1000L));
	    	trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
	    	//	trigger.setRepeatInterval(1000L); // fire on each second
	     	trigger.setRepeatInterval(60000L);
	   	 
	    	//schedule it
	    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
	    	logger.info(" Scheduler Job Start");	
	    	scheduler.start();
	    	scheduler.scheduleJob(job, trigger);

		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	

	}

	
}

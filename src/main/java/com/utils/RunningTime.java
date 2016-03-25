package com.utils;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RunningTime {
	public Date startDate(){
	 Date dt= new Date(System.currentTimeMillis());
		//System.out.println("\n"+dt);
	 return dt;
	}
	public  String timetaken(Date startdate){
		System.out.println("\n-->"+startdate.getTime());
		Date enddate = new Date(System.currentTimeMillis());
		System.out.println("\n"+System.currentTimeMillis());
		long duration  = enddate.getTime() - startdate.getTime();
		System.out.println("\nIn millsec:"+duration);
		 String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(duration),
		            TimeUnit.MILLISECONDS.toMinutes(duration) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(duration)),
		            TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
		return hms;
	}
	
	public  long timeTakenInMillSec(long starttime){
		long endtime = System.currentTimeMillis();
		System.out.println("\n Start time:"+starttime);
		System.out.println("Ending time:"+endtime);
		long duration= endtime-starttime;
		return duration;
	}

}

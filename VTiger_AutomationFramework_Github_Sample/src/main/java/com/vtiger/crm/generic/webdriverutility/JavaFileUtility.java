package com.vtiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaFileUtility {
	public int getRandomNumber()
	{
		Random r=new Random();
		int randomNum=r.nextInt(5000);
		return randomNum;
	}
	public String getSysDateInYYYYMMDD()
	{
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String reqFormat=sim.format(d);
		return reqFormat;
	}
	public String getRequiredDateYYYYMMDD(int days)
	{
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(d);
		Calendar c=sim.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(c.getTime());
		return reqDate;
	}
}

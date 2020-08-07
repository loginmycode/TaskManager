package com.learing.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import com.learing.constonts.Constonts;

public class Logger
{
	public void log(final String data)
	{
		BufferedWriter bw = null;
		
		try
		{
			bw= new BufferedWriter(new FileWriter(Constonts.LOGPATH+".log",true)); 
			Date dt= new Date();
			bw.write(data +" : "+dt);
			bw.newLine();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(bw!=null)
			{
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static Logger obj=null;
	
	
	public static Logger getinstance()
	{
		if(obj==null)
		{
			obj= new Logger();
		}
		return obj;
	}
	
	
}



package com.learing.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.learing.bean.TaskBean;
import com.learing.constonts.Constonts;

public class TaskModel {
	String line;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public String addTask(TaskBean bean, String cName)
	{
		BufferedWriter bw= null;
		
		try
		{
			bw=new BufferedWriter(new FileWriter(Constonts.PATH+cName+".todo",true));//True will replace 
			bw.write(bean.getTaskNmae()+" : "+bean.getDiscriptiion()+" : "+bean.getStatus()+" : "+bean.getPriority()+" : "+bean.getTags()+" : "+sdf.format(bean.getStartDate())+" : "+sdf.format(bean.getEndDate()));
			bw.newLine(); 
			return Constonts.SUCCESS;
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			
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
		return cName;
		
	}
	public List<TaskBean> getTask(String cName) throws NumberFormatException, ParseException
	{
		BufferedReader br = null;
		TaskBean bean = null;
		List<TaskBean> list = new ArrayList<TaskBean>();
		try
		{
			File f = new File(Constonts.PATH+cName+".todo");
			if(f.exists())
			{
				br = new BufferedReader(new FileReader(f));
				while((line= br.readLine())!=null)
				{
				String[] arr =line.split(" : ");
				Date sdate=sdf.parse(arr[5]);
				Date edate=sdf.parse(arr[6]);
				//TaskBean bean=new TaskBean(taskName,discription, status, priority, tags, startDate, eDate);
				bean = new TaskBean(arr[0],arr[1],arr[2],Integer.parseInt(arr[3]),arr[4],sdate,edate);
				list.add(bean);
				}
			}
			else
			{
			return list;
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
		
		
	}
	public boolean updateTask(List<TaskBean> list, String category) {
		
		
		BufferedWriter bw = null;
		
		try
		{
			bw = new BufferedWriter(new FileWriter(Constonts.PATH+category+".todo"));
			for(TaskBean bean :list)
			{
				bw.write(bean.getTaskNmae()+" : "+bean.getDiscriptiion()+" : "+bean.getStatus()+" : "+bean.getPriority()+" : "+bean.getTags()+" : "+sdf.format(bean.getStartDate())+" : "+sdf.format(bean.getEndDate()));
				bw.newLine();
			}
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
		return true;
	}
		
		public List<TaskBean> removeTask(List<TaskBean> lst, String taskName, String category) {
			
			for(int i = 0; i<lst.size(); i++)
			{
				if(lst.get(i).equals(taskName))
				{
					lst.remove(i);
				}
				
			}
			return lst;
			
			
		}
		
		public boolean searchTask(List<TaskBean> l2, String taskName, String category) {
			
			for(int i=0; i<l2.size(); i++)
			{
				if(l2.get(i).equals(taskName))
				{
					return true;
				}
				return false;
			}
			return false;

		}
		public File[] loadCategory()
		{
			
			
			File f = new File("G:\\work-spaces\\TMContent");
			File [] ff=f.listFiles();
			return ff;
			
		}
		
	
		
		
		
	
}

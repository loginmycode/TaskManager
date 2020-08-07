package com.learing.main.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.learing.bean.TaskBean;
import com.learing.constonts.Constonts;

public class TaskUtil {
 
	String line="";
	public static boolean isValidName(String str)
	{
		if(str==null||str.trim().equals(" "))
		
			return false;
		
		if(str.length()>=15||str.split(" ").length>1)
			return false;
		
		if(!(Character.isLetter(str.charAt(0))))
			return false;
		if(str.length()==0)
			return false;
			
		else
			return true;
	}

	public static boolean isDuplicate(String cName) {
		
		File f = new File(Constonts.PATH+cName+".todo");
		if(f.exists())
		{
		return false;
		}
		return true;
	}


	

}

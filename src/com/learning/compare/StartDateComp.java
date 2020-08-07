package com.learning.compare;

import java.util.Comparator;

import com.learing.bean.TaskBean;

public class StartDateComp implements Comparator<TaskBean> {

	@Override
	public int compare(TaskBean o1, TaskBean o2) {
		// TODO Auto-generated method stub
		return o1.getStartDate().compareTo(o2.getStartDate());
	}
	
	

}

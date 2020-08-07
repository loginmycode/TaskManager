package com.learning.compare;

import java.util.Comparator;

import com.learing.bean.TaskBean;

public class EndDateComp implements Comparator<TaskBean> {

	@Override
	public int compare(TaskBean o1, TaskBean o2) {
		// TODO Auto-generated method stub
		return o1.getEndDate().compareTo(o2.getEndDate());
	}
	

}

package com.learning.compare;

import java.util.Comparator;

import com.learing.bean.TaskBean;
import com.learing.model.TaskModel;

public class TaskNameCompareator implements Comparator<TaskBean>{

	@Override
	public int compare(TaskBean o1, TaskBean o2) {
		
		return o1.getTaskNmae().compareTo(o2.getTaskNmae());
	}

}

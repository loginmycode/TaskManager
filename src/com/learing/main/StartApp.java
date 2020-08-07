package com.learing.main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import com.learing.bean.TaskBean;
import com.learing.logger.Logger;
import com.learing.main.util.TaskUtil;
import com.learing.model.TaskModel;
import com.learning.compare.EndDateComp;
import com.learning.compare.LongTimeComp;
import com.learning.compare.StartDateComp;
import com.learning.compare.TaskNameCompareator;

public class StartApp {

	public static void main(String[] args) throws ParseException {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int ch1 = 0, ch2 = 0, ch3 = 0, ch4 = 0;
		String msg;
		String category = "", taskName = "", tags, status, discription, stDate, endDate;
		int priority = 0;
		Date eDate, startDate;
		TaskBean bean = null;
		boolean res = false;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TaskModel model = new TaskModel();
		Logger log = new Logger();
		while (ch1 != 6) {
			log.log("Starting");
			System.out.println("Enter 1 for CREATE category");
			System.out.println("Enter 2 for LOAD category");
			System.out.println("Enter 3 for LIST category");
			System.out.println("Enter 4 for SEARCH category");
			System.out.println("Enter 5 to EXIT");
			System.out.println("------------------------");
			System.out.println("Enter your choice  it should be on number");

			while (!sc1.hasNextInt()) {
				ch1 = sc1.nextInt();
				System.out.println("Enter crrect input");

			}
			ch1 = sc1.nextInt();
			switch (ch1) {
			case 1:

				System.out.println("Enter category name ");
				category = sc2.next();
				res = TaskUtil.isValidName(category);
				System.out.println(res);
				while (!res) {
					System.out.println("Ente proper category name");
					category = sc2.next();
					TaskUtil.isValidName(category);
				}
				res = TaskUtil.isDuplicate(category);
				System.out.println(res);
				while (!res) {
					System.out.println("Ente proper category name");
					category = sc2.next();
					TaskUtil.isDuplicate(category);
				}

				while (ch2 != 7) {
					System.out.println("Enter 1 for ADD task name");
					System.out.println("Enter 2 for EDIT a task");
					System.out.println("Enter 3 for REMOVE the task ");
					System.out.println("Enter 4 for LIST the task ");
					System.out.println("Enter 5 for search the task");
					System.out.println("Enter 6 for Exit");
					System.out.println("-----------------------------------------");
					System.out.println("Enter your choice");

					while (!sc1.hasNextInt()) {
						ch3 = sc1.nextInt();
						System.out.println("Enter correct number");
					}
					ch2 = sc1.nextInt();
					switch (ch2) {
					case 1:

						System.out.println("Enter tasak name");
						taskName = sc2.next();
						res = TaskUtil.isValidName(taskName);
						while (!res) {
							System.out.println("Enter proper name");
							taskName = sc2.next();
							res = TaskUtil.isValidName(taskName);

						}
						System.out.println("Enter the discription ");
						discription = sc2.next();
						System.out.println("Enter the priority");
						priority = sc1.nextInt();
						System.out.println("Enter the status");
						status = sc1.next();
						System.out.println("Enter tags comma separated");
						tags = sc2.next();
						System.out.println("Enter start date");
						startDate = new Date();
						System.out.println("Ente end date");
						endDate = sc2.next();
						eDate = sdf.parse(endDate);
						bean = new TaskBean(taskName, discription, status, priority, tags, startDate, eDate);
						msg = model.addTask(bean, category);
						break;

					case 2:

						System.out.println("Update the task");
						List<TaskBean> list = model.getTask(category);
						for (int i = 0; i < list.size(); i++) {
							System.out.println(list.get(i) + " " + i);
						}
						System.out.println("Select the  number which task u need to edit");
						int pos = 0;
						while (!sc1.hasNextInt()) {
							pos = sc1.nextInt();
							System.out.println("Enter prper number");
						}
						pos = sc1.nextInt();
						TaskBean tb = list.get(pos);

						while (ch3 != 6) {
							System.out.println("Enter 1 for Edit task");
							System.out.println("Enter 2 for Edit Discription");
							System.out.println("Enter 3 for Edit status");
							System.out.println("Enter 4 for Edit tags");
							System.out.println("Enter 5 for Edit startDate");
							System.out.println("Enter 6 for Edit EndDate");
							System.out.println("----------------------------");
							System.out.println("Enter your option");
							while (!sc1.hasNextInt()) {
								System.out.println("Enter integer number only");
								ch3 = sc1.nextInt();
							}
							ch3 = sc1.nextInt();
							switch (ch3) {
							case 1:

								System.out.println("Enter the new taskname");
								taskName = sc2.next();
								res = TaskUtil.isValidName(taskName);
								while (!res) {
									System.out.println("Enter proper name");
									taskName = sc2.next();
									res = TaskUtil.isValidName(taskName);
								}
								res = TaskUtil.isDuplicate(taskName);
								while (!res) {
									System.out.println("Enter unique  names bcz its already exist");
									taskName = sc2.next();
									res = TaskUtil.isValidName(taskName);
								}
								tb.setTaskNmae(taskName);
								model.updateTask(list, category);
								break;
							case 2:
								System.out.println("Enter new Discription");
								discription = sc2.next();
								tb.setDiscriptiion(discription);
								model.updateTask(list, category);
								break;
							case 3:
								System.out.println("Enter new Status");
								status = sc2.next();
								tb.setTags(status);
								model.updateTask(list, category);
								break;
							case 4:
								System.out.println("Enter new Tags");
								tags = sc2.next();
								break;
							case 5:
								System.out.println("Enter new statDate ");
								startDate = new Date();
								tb.setStartDate(startDate);
								break;
							case 6:
								System.out.println("Enter new endDate");
								endDate = sc2.next();
								eDate = sdf.parse(endDate);
								tb.setEndDate(eDate);
								break;
							case 7:
								System.out.println("EXIT");
							default:
								System.out.println("WRONG INPUT ENTER B/W 1 to 7");
								break;
							}
						}
						break;
					case 3:
						System.out.println("Enter the task y to rou want to remove");
						List<TaskBean> lst = model.getTask(category);
						taskName = sc2.next();
						List<TaskBean> l = model.removeTask(lst, taskName, category);
						model.updateTask(l, category);
						break;
					case 4:
						System.out.println("LIST THE TASK");
						int ch5 = 0;
						while (ch5 != 5) {
							System.out.println("LIST Alphabetically");
							System.out.println("LIST as for the StartDate ");
							System.out.println("LIST as for the endDate ");
							System.out.println("LIST as for the Longest Time ");
							while (!sc1.hasNextInt()) {
								ch5 = sc1.nextInt();
								System.out.println("Enter the number");
							}
							ch5 = sc1.nextInt();
							switch (ch5) {
							case 1:
								List<TaskBean> l2 = model.getTask(category);
								TaskNameCompareator tc = new TaskNameCompareator();
								Collections.sort(l2, tc);
								System.out.println(l2);
								break;
							case 2:
								System.out.println("Compare as for the startDate");
								List<TaskBean> li = model.getTask(category);
								StartDateComp sdc = new StartDateComp();
								Collections.sort(li, sdc);
								break;
							case 3:
								System.out.println("EndDate Compare");
								EndDateComp edc = new EndDateComp();
								List<TaskBean> lis = model.getTask(category);
								Collections.sort(lis, edc);
								break;
							case 4:
								System.out.println("Compare long time process task");
								List<TaskBean> lss = model.getTask(category);
								LongTimeComp ltc = new LongTimeComp();
								break;
							case 5:
								System.out.println("EXIT");
							default:
								System.out.println("Give proper input");

								break;
							}

						}
					case 5:
						System.out.println("Search the task it Exist or not");
						List<TaskBean> l2 = model.getTask(category);
						System.out.println("Give the task Name which u need to search");
						taskName = sc2.next();
						res = model.searchTask(l2, taskName, category);
						if (res == true) {
							System.out.println("The given  task is exist");
						}
						System.out.println("The Does not exist give proper task name");
						break;

					case 6:
						System.out.println("Exiting the task");
					default:
						System.out.println("Wrong number please provide proper number");
						break;

					}
				}
				break;
			case 2:
				System.out.println("Load the category");
				System.out.println("---------------LoAD-------------------------------");
				break;
			case 3:
				int ch5 = 0;
				while (ch5 != 3) 
				{
					
					System.out.println("Enter 1 for List the category");
					System.out.println("Enter 2 for list the category based on alpa order");
					System.out.println("Choose your option");
					while (!sc1.hasNextInt()) {
						ch5 = sc1.nextInt();
						System.out.println("Enter only number");
					}
					ch5 = sc1.nextInt();
					switch (ch5) 
					{
					case 1:
						System.out.println("List the category"); 
						 File[] f= model.loadCategory();
						  String [] arr= new String[f.length];
						  for(File ff:f)
						  {
						  String s=ff.getName().toString(); String file=s.replaceAll(".todo", "");
						 
						  System.out.println(file);
						  }

					break;
					
					case 2:
						List l = new ArrayList<>();
						TreeSet<String> ts = new TreeSet<String>();
						System.out.println("List the cateogory as for the aplphabetical");
						TaskNameCompareator tsc= new TaskNameCompareator();
						 File[] f1= model.loadCategory();
						  String [] arr1= new String[f1.length];
						  for(File ff:f1)
						  {
						  String s=ff.getName().toString();
						  String file=s.replaceAll(".todo", "");
						  ts.add(file);
						 
						  }
						
						System.out.println("List based on alphabetically");
						System.out.println(ts);
						break;
					case 3:
						System.out.println("Exit");
						default:
							System.out.println("Invalid input");
					}

				}
			case 4:
				System.out.println("Search category");
				System.out.println("-----------------------");
				System.out.println("Enter the category need to search");
				category= sc2.next();
				File [] arr =model.loadCategory();
				for(File f:arr)
				{
					String cat=f.getName().toString().replaceAll(".todo", "");
					if(cat.equals(category))
					{
						System.out.println(category + " Exist Successfully");
						res=true;
						break;
					}
					
				}
				if(!res)
				{
					System.out.println(category +" Not exist");
				}
				break;

			case 5:
				System.out.println("GOOD BYE");

			break;
			default:
				System.out.println("Invalid number please give range bw 1 to 5");
				break;
			}

			

		}
		
	}

	
}

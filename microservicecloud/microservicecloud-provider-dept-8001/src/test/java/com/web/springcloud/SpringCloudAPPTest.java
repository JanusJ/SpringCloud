package com.web.springcloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class SpringCloudAPPTest {
	
	public  boolean match( String str) {
		String regex="^.*\\d*.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	public  boolean matchNum( String charAt) {
		String regex="^\\d$";
		Pattern pattern = Pattern.compile(regex);
		
		Matcher matcher = pattern.matcher(charAt);
		return matcher.matches();
	}
	
//	@Test
	public void test(){
//		String carCard = "A1023,NB127,D12ZG";
//		String carCard = "A1023,NB123,D12ZG";
//		int limitDate = 3;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入限号日期:");
		int limitDate=input.nextInt();
		
		System.out.println("请输入车牌号:");
		String carCard=input.next();
		/**
		 * 1 6 周一--1
		 * 2 7 周二--2
		 * 3 8 周三--3
		 * 4 9 周四--4
		 * 5 0 周五--5
		 * 周六周日不限行，取车牌后五位，倒序找数字，输入错误车牌号则返回error，输入正确车牌号则返回限行车牌号，若无限行时间内车牌号返回空
		 */
		// 判断是否在限行时间内，如果不在则直接返回空
		if(limitDate>5||limitDate<1){
			System.out.println("");
		}
		// 如果在限行时间内则开始判断车牌号
		if(carCard==null||carCard.equals("")){
			System.out.println("error");
		}
		//获取车牌号数组
		String[] cars = null;
		if(carCard.indexOf(",")>-1){
			// 根据逗号分割数组
			cars= carCard.split(",");
		}else{
			cars = new String[1];
			cars[0]=carCard;
		}
		List<String> carList = new ArrayList<String>();
		//判断数组中每个字符串后五位是否包含数字，将没有数字的清除掉
		for(String carNum:cars){
			String carSubstring = carNum.substring(carNum.length()-5, carNum.length());
			boolean match = match(carSubstring);
			if(match){
				carList.add(carNum);
			}
		}
		List<String> result = new ArrayList<String>();
		
		// 对list中的每个string，进行倒序数字获取
		for(int i=0;i<carList.size();i++){
			String carNumber = carList.get(i);
			Map<String,String> carNumMap = new HashMap<String,String>();
			for (int j = carNumber.length()-1; j >= 0; j--) {
				char charAt = carNumber.charAt(j);
				if(matchNum(String.valueOf(charAt))){
					System.out.println("该字符为数字："+charAt);
					carNumMap.put(String.valueOf(charAt), carNumber);
					break;
				}
			}
			System.out.println("获取的map为 ： "+carNumMap);
			String checkNum = checkNum(limitDate,carNumMap);
			if(checkNum!=null&&checkNum!=""){
				result.add(checkNum);
			}
		}
		System.out.println("最终结果 ： "+result);
	}
	public String checkNum( int limitDate,Map<String,String> carNumMap ){
		String result = "";
		//判断限行车牌号
		switch(limitDate){
		case 1:
			// 取出数字为1 6
			for(String key : carNumMap.keySet()){
				if(key.equals("1")||key.equals("6")){
					return carNumMap.get(key);
				}
			}
			break;
		case 2:
			// 取出数字为2 7 
			for(String key : carNumMap.keySet()){
				if(key.equals("2")||key.equals("7")){
					return carNumMap.get(key);
				}
			}
			break;
		case 3:
			//取出数字为3 8
			for(String key : carNumMap.keySet()){
				if(key.equals("3")||key.equals("8")){
					return carNumMap.get(key);
				}
			}
			break;
		case 4:
			// 取出数字为4 9
			for(String key : carNumMap.keySet()){
				if(key.equals("4")||key.equals("9")){
					return carNumMap.get(key);
				}
			}
			break;
		case 5:
			// 取出数字为5 0
			for(String key : carNumMap.keySet()){
				if(key.equals("5")||key.equals("0")){
					return carNumMap.get(key);
				}
			}
			break;
		}
		return result;
	}

}

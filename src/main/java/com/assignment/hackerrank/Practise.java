package com.assignment.hackerrank;

public class Practise {

	public static void main(String[] args) {
	
		int N=6;
		
		for(int i=1;i<=N;i++){
			
			for(int j=1;j<=N;j++){
				if(j<N-i+1){
					System.out.print(" ");
				}else{
					System.out.print("#");
				}
				if(j==N){
					System.out.println("");
				}
			}
		}
		
	}
	public static void militaryHourConvertor(){
		 String time = "12:01:23AM";
	        String[] hours=time.split(":");
	        if(hours[2].endsWith("PM")){
	          time= time.replaceAll("PM", "");
	          int x=(12+Integer.parseInt(hours[0]));
	            time=time.replaceFirst(hours[0], Integer.toString(x==24?12:x));
	        }else{
	        	 time=time.replaceAll("AM", "");
	        	 if(hours[0].equals("12")){
	        		 time=time.replaceFirst(hours[0], "00");
	        	 }
	        }
	        System.out.println(time);
	}

}

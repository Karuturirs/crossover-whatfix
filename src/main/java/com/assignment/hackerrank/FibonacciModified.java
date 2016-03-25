package com.assignment.hackerrank;

import java.util.Scanner;

import com.utils.RunningTime;


/*
 * A series is defined in the following manner:
Given the nth and (n+1)th terms, the (n+2)th can be computed by the following relation 
Tn+2 = (Tn+1)2 + Tn

Given three integers A, B and N, such that the first two terms of the series (1st and 2nd terms) are A and B respectively, compute the Nth term of the series.

Input Format

You are given three space separated integers A, B and N on one line.

Input Constraints 
0 <= A,B <= 2 
3 <= N <= 20

Output Format

One integer. 
This integer is the Nth term of the given series when the first two terms are A and B respectively.

Note

Some output may even exceed the range of 64 bit integer.
Sample Input

0 1 5  
Sample Output

5
 */
public class FibonacciModified {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunningTime rt=new RunningTime();
		//long starttime = System.currentTimeMillis();
    	Scanner in = new Scanner(System.in);
    	 long a = in.nextLong();
    	 long b = in.nextLong();
    	 long n = in.nextLong();
    	 long[] obj= {a,b,3,n};
    	 
    	 obj= findTheSeries(obj);
    	 System.out.println(obj[1]);
    	 //long x=290287121823L;
    	 //System.out.println(Math.pow(x,2));
    	// System.out.println("\n Time Taken in millsec: "+rt.timeTakenInMillSec(starttime)+ " "); 
	}
	public static long[] findTheSeries(long[] obj){
		
		long x=obj[1];
		long a = Math.round(Math.pow(x,2))+ obj[0];
		//System.out.println("--"+a);
		
		obj[1]=a;
		obj[0]=x;
		obj[2]++;
		//System.out.print(obj[1]+ " ");
			
		if(obj[2]<=obj[3]){
			findTheSeries(obj);
		}
		
		return obj;
	}
	

}

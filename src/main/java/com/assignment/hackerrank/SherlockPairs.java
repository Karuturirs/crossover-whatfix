package com.assignment.hackerrank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import com.utils.RunningTime;

/*
 * Problem Statement

Sherlock is given an array of N integers (A0, A1 ... AN−1 by Watson. Now Watson asks Sherlock how many different pairs of indices i and j exist such that i is not equal to j but Ai is equal to Aj.

That is, Sherlock has to count the total number of pairs of indices (i,j) where Ai =Aj AND i≠j.

Input Format 
The first line contains T, the number of test cases. T test cases follow. 
Each test case consists of two lines; the first line contains an integer N, the size of array, while the next line contains N space separated integers.

Output Format 
For each test case, print the required answer on a different line.

Constraints 
1≤T≤10 
1≤N≤10^5 
1≤A[i]≤10^6

Sample input

3
3
1 2 3
4
1 1 2 2
6
1 2 2 4 6 2

Sample output

0
2
Explanation 
In the first test case, no two pair of indices exist which satisfy the given condition. 
In the second test case as A[0] = A[1] = 1, the pairs of indices (0,1) and (1,0) satisfy the given condition.
 */

public class SherlockPairs {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	RunningTime rt=new RunningTime();
		long starttime = System.currentTimeMillis();
    	Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
           int n = in.nextInt();
           long[] ar=new long[n];
         
           for(int i = 0; i < n; i++){
               ar[i]= in.nextLong(); 
            }
       
           long count=0;
           for(int i = 0; i < n; i++){
        	   for(int j = i+1; j < n ; j++){
        		   //System.out.println(i+"--"+j);
             	  if(ar[i]==ar[j] && i!=j){
             		//System.out.println("("+i+","+j+")");  
             		count++;
             	  }
            	   
               } 
           }
           System.out.println((long)(count*2));
           
        }
        System.out.println("\n Time Taken in millsec: "+rt.timeTakenInMillSec(starttime)+ " ");
    }
}
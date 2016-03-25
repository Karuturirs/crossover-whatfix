package com.assignment.hackerrank;

import java.io.IOException;
import java.util.Random;

import com.utils.RunningTime;

/*
 * Xorq has invented an encryption algorithm which uses bitwise XOR operations extensively. This encryption algorithm uses a sequence of non-negative integers x1,x2,⋯xn as key. To implement this algorithm efficiently, Xorq needs to find maximum value of (a⊕xj) for given integers a, p and q, such that, p⩽j⩽q. Help Xorq implement this function.

Input Format 
First line of input contains the number of test cases, T (1<=T<=6). T test cases follow. 
First line of each test case contains two space separated integers N and Q (1<= N<=100,000; 1<=Q<= 50,000). Next line contains N space separated integers x1,x2,⋯xn (0<=xi< 215). Each of next Q lines describes a query which consists of three integers ai, pi and qi (0<=ai< 215, 1<=pi<=qi<= N).

Output Format 
For each query, print in a new line the maximum value for (ai⊕xj), such that, pi⩽j⩽qi.

Sample Input

1  
15 8  
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15  
10 6 10  
1023 7 7  
33 5 8  
182 5 10  
181 1 13  
5 10 15  
99 8 9  
33 10 14

Sample Output

13  
1016  
41  
191  
191  
15  
107  
47
Explanation

First Query (10 6 10): x6⊕10=12,x7⊕10=13,x8⊕10=2,x9⊕10=3,x10⊕10=0, therefore answer for this query is 13.

Second Query (1023 7 7): x7⊕1023=1016, therefore answer for this query is 1016.

Third Query (33 5 8): x5⊕33=36,x6⊕33=39,x7⊕33=38,x8⊕33=41, therefore answer for this query is 41.

Fourth Query (182 5 10): x5⊕182=179,x6⊕182=176,x7⊕182=177,x8⊕182=190,x9⊕182=191,x10⊕182=188, therefore answer for this query is 191.
 */
public class XORkey{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		RunningTime rt=new RunningTime();
		long starttime = System.currentTimeMillis();
		// BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        int t = 1;
        		//Integer.parseInt(bufferRead.readLine().trim()); //(1<=T<=6)
       
        for(int a0 = 0; a0 < t; a0++){
          //(1<= N<=100,000; 1<=Q<= 50,000)
        	 //String npar= bufferRead.readLine().trim();
             int n= 100000;
            		 //Integer.parseInt(npar.split(" ")[0]);
             int q= 40000;
            		// Integer.parseInt(npar.split(" ")[1]);
             //String num=bufferRead.readLine();
             String[] xi= new String[n];
            		 //num.split(" ");
             Random rand = new Random();
            
             for(int i=0;i<n;i++){
 
            	 xi[i]= Integer.toString(rand.nextInt((100000 - 1) + 1) + 1);
             }
           // System.out.println(xi.length);
             for(int i=0;i<q;i++){
            	// String qnum= bufferRead.readLine().trim();
            	 int g=rand.nextInt(n);
                 long ai=Long.parseLong( xi[g]);
                		 //Long.parseLong(qnum.split(" ")[0]);
                 
                 long pi= (long)(rand.nextInt(((g) - 0) + 1) + 0);
                 //Long.parseLong(qnum.split(" ")[1]);
                 long qi=  (long)(rand.nextInt((n - g) + 1) + g);
                 //Long.parseLong(qnum.split(" ")[2]);
                 long max =0;
               //  System.out.println(g+"  "+ai+"   "+pi+"   "+qi);
                 for(int j=(int)(pi);j<qi;j++){
                	 //System.out.println(j);
                	 long xpi=Long.parseLong(xi[j]);
                	 long res= (ai ^ xpi);
                	 //System.out.println("--"+res);
                	 if(res>=max){
                		 max=res;
                	 }
                 }
                 System.out.println(i+"-->"+max);
             }
        }
        System.out.println("\n Time Taken in millsec: "+rt.timeTakenInMillSec(starttime)+ " ");
	}

}

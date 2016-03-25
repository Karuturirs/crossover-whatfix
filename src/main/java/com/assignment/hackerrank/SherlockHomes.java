package com.assignment.hackerrank;
/*
 * Problem Statement

Sherlock Holmes suspects his archenemy, Professor Moriarty, is once again plotting something diabolical. Sherlock's companion, Dr. Watson, suggests Moriarty may be responsible for MI6's recent issues with their supercomputer, The Beast.

Shortly after resolving to investigate, Sherlock receives a note from Moriarty boasting about infecting The Beast with a virus; however, he also gives him a clue—a number, N. Sherlock determines the key to removing the virus is to find the largest Decent Number having N digits.

A Decent Number has the following properties:

Its digits can only be 3's and/or 5's.
The number of 3's it contains is divisible by 5.
The number of 5's it contains is divisible by 3.
Moriarty's virus shows a clock counting down to The Beast's destruction, and time is running out fast. Your task is to help Sherlock find the key before The Beast is destroyed!

Constraints
1≤T≤20
1≤N≤100000


Input Format

The first line is an integer, T, denoting the number of test cases.

The T subsequent lines each contain an integer, N, detailing the number of digits in the number.

Output Format

Print the largest Decent Number having N digits; if no such number exists, tell Sherlock by printing -1.

Sample Input

4
1
3
5
11
Sample Output

-1
555
33333
55555533333
Explanation

For N=1, there is no such number.
For N=3, 555 is the only possible number.
For N=5, 33333 is the only possible number.
For N=11, 55555533333 and all permutations of these digits are valid numbers; among them, the given number is the largest one.
 * 
 */
import java.util.Scanner;

public class SherlockHomes {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ts = in.nextInt();
        for(int a0 = 0; a0 < ts; a0++){
           int n = in.nextInt();
           boolean flag= false;
        	for(int x=n,y=0;x>=0;x--,y++){
        		//System.out.println(x+" "+y);
        		if(x%3==0 && y%5==0){
        			//System.out.println(x);
        			StringBuffer g=new StringBuffer();
        			for(int a=0;a<x;a++){
        				g.append("5");
        			}
        			for(int b=0;b<y;b++){
        				g.append("3");
        			}
        			System.out.println(g.toString());
        			flag= false;
        			break;
        		}else{
        			 flag=true;	
        		}
        	}
        	if(flag){
            	System.out.println("-1");
            }
        }
    }
}

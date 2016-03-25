package com.assignment.hackerrank;

import java.util.Scanner;

/*
 * Input Format 
First line contains three space separated integers, M, N and R, where M is the number of rows, N is number of columns in matrix, and R is the number of times the matrix has to be rotated. 
Then M lines follow, where each line contains N space separated positive integers. These M lines represent the matrix.

Output Format 
Print the rotated matrix.

Constraints 
2 <= M, N <= 300 
1 <= R <= 109 
min(M, N) % 2 == 0 
1 <= aij <= 108, where i ∈ [1..M] & j ∈ [1..N]

Sample Input #00

4 4 1
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
Sample Output #00

2 3 4 8
1 7 11 12
5 6 10 16
9 13 14 15
 * 
 * 
 */
public class MatrixRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner in = new Scanner(System.in);
	        int m = in.nextInt();
	        int n = in.nextInt();
	        int r = in.nextInt();
	        int a[][] = new int[m][n];
	        int b[][] = new int[m][n];
	        for(int a_i=0; a_i < m; a_i++){
	            for(int a_j=0; a_j < n; a_j++){
	                a[a_i][a_j] = in.nextInt();
	                System.out.print("-- "+a[a_i][a_j]);
	            }
	            System.out.println();
	        }
	        
	        int circles=(m<n?m:n)/2;
	        System.out.println(circles);
	        for(int a_i=0; a_i <= m-1; a_i++){
	            for(int a_j=0; a_j <= n-1-r; a_j++){
	                //a[a_i][a_j];
	            	int target=	findShiftCell(10*a_i+a_j,m-1,n-1,r);
	            }
	            System.out.println();
	        }
	        
	}

	private static int findShiftCell(int i, int m,int n, int r) {
		// TODO Auto-generated method stub
		
		int a_i=i/10;     int a_j=i%10;
		int itemcircle =
		int b_i = (a_i)-r<0? : ;
		if(a_i-r<0){
			
		}else if(){
			
		}
		return 0;
	}

}

package com.assignment.hackerrank;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class MRSolution
{
   
   public static void main(String []argh)
   {
      JSONObject inputdata= new JSONObject();
      Scanner sc=new Scanner(System.in);
      int Nr=sc.nextInt();
      int Ns=sc.nextInt();
      int []R=new int[Nr];
      int []S=new int[Ns];
      int c=0;
      for(int i=0;i<Nr;i++)
      {
         
         Map obj=new LinkedHashMap();
         R[i]=sc.nextInt();
         obj.put("value","R");
         obj.put("key",R[i]);
         inputdata.put(c,obj);
         c++;
      }
      
      for(int i=0;i<Ns;i++)
      {
         Map obj=new LinkedHashMap();
         S[i]=sc.nextInt();
         obj.put("value","S");
         obj.put("key",S[i]);
         inputdata.put(c,obj);
         c++;
      }
      
      
      MapReduce mapred= new MapReduce();
      JSONObject result=mapred.execute(inputdata); 
   
      for(int i=0;i<result.size();i++)
      {
         LinkedHashMap record=(LinkedHashMap)result.get(i);
         System.out.println(record.get("key"));

      }
   
   }
   
}

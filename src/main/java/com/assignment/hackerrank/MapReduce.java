package com.assignment.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

class MapReduce
{
   private LinkedHashMap intermediate;
   private JSONObject finalResult = new JSONObject();
   private int resultCount;
   MapReduce()
   {
      resultCount=0;
      finalResult = new JSONObject();
      intermediate=new LinkedHashMap();
   }
   
   JSONObject execute(JSONObject inputdata)
   {
      for(int i=0;i<inputdata.size();i++)
      {
         LinkedHashMap record=(LinkedHashMap)inputdata.get(i);
         mapper(record);
      }
      
      Iterator it = intermediate.entrySet().iterator();
      while (it.hasNext()) {
         Map.Entry pair = (Map.Entry)it.next();
         reducer((int)pair.getKey(), (HashSet)pair.getValue());
         it.remove();
      }
      return finalResult;
      
      
   }
   private void emit(LinkedHashMap obj)
   {
      finalResult.put(resultCount++,obj);
   }
   private void reducer(int key, HashSet value)
   {
      List<String> list = new ArrayList<String>(value);
      if(list.size()==1 && !list.contains(new String("S")))
      {
         LinkedHashMap obj=new LinkedHashMap();
         obj.put("key",key);
         emit(obj);
      }
   }
   private void mapper(LinkedHashMap record)
   {
      String value=(String)record.get("value");
      int key=(int)record.get("key");
      emitIntermediate(key,value);
      
   }
   private void emitIntermediate(int key, String value)
   {
      if(!intermediate.containsKey(key))
         intermediate.put(key,new HashSet());

      HashSet temp=(HashSet)intermediate.get(key);
      temp.add(value);
      intermediate.put(key,temp);
   }
}
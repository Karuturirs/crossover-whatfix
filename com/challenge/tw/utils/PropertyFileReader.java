package com.challenge.tw.utils;

import java.io.*;
import java.util.*;

import com.challenge.tw.manager.Billing;


/**************************************************************************************************** 
 *  A singletone class, for  Loading all the property files 
 *  @author: Ravi Sankar Karuturi
 *  @createddate: 25/08/2016
 *****************************************************************************************************/
public  class PropertyFileReader {
	 Properties props;
	 private static volatile PropertyFileReader propload = null;

		private PropertyFileReader(){
			
		}
		 public static PropertyFileReader getInstance() {
				if (propload == null) {
					synchronized (PropertyFileReader.class) {
						if (propload == null) {
							propload = new PropertyFileReader();
							propload.props = new Properties();
						}
					}
				}
				return propload;
			}
    /**
     *  loads all property files values
     * @param propfile
     * @throws FileNotFoundException
     * @throws IOException
     */
	public void loadPropertyFileReader(String propfile) throws FileNotFoundException, IOException{
		
         File currentDirFile = new File(".");
 		 String helper = currentDirFile.getAbsolutePath().replace("\\.", "");
         String propertyFilePath = helper+Billing.PATH_SEPARATOR+propfile;
       //  System.out.println("Loading property file:"+propertyFilePath);
         props.load(new FileInputStream(propertyFilePath));
       //  System.out.println(props);
	}
	
	/**
	 * 
	 * @param key
	 * @return value of the property key
	 */
	 public String getProperty(String key)
     {
        String keyValue = props.getProperty(key);
        return keyValue;
     }
	     
}

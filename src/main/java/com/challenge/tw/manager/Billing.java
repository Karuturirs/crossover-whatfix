package com.challenge.tw.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.challenge.tw.bean.Inventory;
import com.challenge.tw.utils.PropertyFileReader;

/****************************************************************************************************
 *  Helps to calculate the final prices of all the purchases after discounts
 *  Reads the input from input/inventory.csv
 *  @author: Ravi Sankar Karuturi
 *  @createddate: 25/08/2016
 *****************************************************************************************************/
public class Billing {
	/**
	 * 
	 * @param args
	 */
	public static final String CVS_SEPARATOR = ",";
	public static final String PATH_SEPARATOR = "/";
	
    public static void main(String[] args) {
    	//Contains listing all product info with key id
   	 	HashMap<Integer,Inventory> listallproducts = new HashMap<Integer,Inventory>();
    	try{
    		// Load all property files related to categories and brands
    		PropertyFileReader propload = loadAllProperties();
    		processingInventory(propload,listallproducts);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Process all the required property files
     * @return PropertyFileReader obj
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static PropertyFileReader loadAllProperties() throws FileNotFoundException, IOException {
		
		PropertyFileReader propload =PropertyFileReader.getInstance();
		propload.loadPropertyFileReader("config/Manage.properties");
		propload.loadPropertyFileReader("input/brands.properties");
		propload.loadPropertyFileReader("input/categories.properties");
		
		return propload;
		
	}
    
    /**
     * Read all input form the input/inventory.csv one after other and displays the prices of the purchases
     * @param propload
     * @param listallproducts
     * @throws NumberFormatException
     * @throws IOException
     */
    public static void processingInventory(PropertyFileReader propload, HashMap<Integer, Inventory> listallproducts) throws NumberFormatException, IOException {
    	
    	String line = "";
		int totalinventory =-1;
		int productscount=1;
		boolean setinventory = false;
		boolean setpurchases = false;
		int totalpurchases =0;
		int purchasecount =1;
		File currentDirFile = new File(".");
		String helper = currentDirFile.getAbsolutePath().replace("\\.", "");
		String csvFile = helper+Billing.PATH_SEPARATOR+propload.getProperty("inventoryfile");
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		
        while ((line = br.readLine()) != null) {
        	if(!line.equals("")){
        		if(!setinventory){
        			totalinventory = Integer.parseInt(line);
        			setinventory=true;
        		}else{
        			if(productscount<=totalinventory){
        				productscount++;
        				String[] items= line.split(Billing.CVS_SEPARATOR);
        				// System.out.println("-->"+line);
        				Inventory invtry = new Inventory();
        				invtry.setId(Integer.parseInt(items[0].trim()));
        				invtry.setBrand(items[1].trim());
        				invtry.setCategory(items[2].trim());
        				invtry.setPrice(Integer.parseInt(items[3].trim()));
        				invtry.setCategorypath(propload.getProperty(items[2].trim()).split(":")[0]);
        				invtry.setDiscount(calcDiscount(invtry,propload)); 
        				// System.out.println(invtry.getDiscount());
        				listallproducts.put(invtry.getId(), invtry);
        				
        			}else{
        				if(!setpurchases){
        					totalpurchases = Integer.parseInt(line);
        					setpurchases=true;
        				}else{
        					if(purchasecount<= totalpurchases){
        						purchasecount++;
	        					String[] x = line.split(Billing.CVS_SEPARATOR);
	        					double totalcost = 0;
	        					for (int i = 0; i < x.length; i++) {
	        						totalcost = totalcost + listallproducts.get(formatinput(x[i])).getFinalprice();
								}
	        					System.out.println((int)totalcost);
        					}else{
        						System.out.println("Invalid input to process.");
        					}
        				}
        				
        			}
        			
        		}
        		//System.out.println(line);
        	}
        }
		
	}
	
    /**
     * Calculates the final discount value on all the conditions and returns the discount value
     * @param invtry
     * @param propload
     * @return integer discount value with out %
     */
	public static int calcDiscount(Inventory invtry, PropertyFileReader propload){
		int brand_disc = formatinput(propload.getProperty(invtry.getBrand()));
		int category_disc = formatinput(propload.getProperty(invtry.getCategory()).split(":")[1]);
		int parents_disc = 0;
		String path = invtry.getCategorypath();
		if(path.contains("/")){
			String[] g = path.split("/");
			for (int i = 0; i < g.length; i++) {
				int pt = formatinput(propload.getProperty(g[i]).split(":")[1]);
				if(pt > parents_disc){
					parents_disc= pt;
				}
			}
		}else{
			parents_disc = 0;
		}
	
		if ( brand_disc > category_disc && brand_disc > parents_disc )
	        return brand_disc;
	      else if ( category_disc > brand_disc && category_disc > parents_disc )
	         return category_disc;
	      else if ( parents_disc > brand_disc && parents_disc > category_disc )
	        return parents_disc;
	      else
	    	return parents_disc;
	     
		
	}
    /**
     *  all the input is passed is converted to int 
     * @param q
     * @return int
     */
    public static int formatinput(String q){
    	int value=0;
    	q=q.toLowerCase();
    	if(q.equals("none")){
    		value=0;
    	}else{
    		value=Integer.parseInt(q);
    	}
    	
    	return value;
    }

}
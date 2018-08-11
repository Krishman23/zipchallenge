package com.wsi.utilities;

import java.util.ArrayList;

public class ZipcodeMerger {
	public ArrayList<ArrayList<Integer>> mergeZip(ArrayList<ArrayList<Integer>> zipArray) {
		// TODO Auto-generated method stub
		//System.out.println(zipArray.size());	
		Integer lower, upper, j=0;
		ArrayList<ArrayList<Integer>> resultZip=new ArrayList<>();
		for (int i = 0; i < zipArray.size(); i++) {
			lower=zipArray.get(i).get(0);
			upper=zipArray.get(i).get(1);
			//System.out.println("i:"+(i)+"lower:"+lower+" upper:"+upper);
			while ((i+1)<zipArray.size() && upper+1>=zipArray.get(i+1).get(0) ){
				//System.out.println("i+1:"+(i+1)+" upper:"+upper+ " ziparray: "+zipArray.get(i+1).get(0)+" : "+zipArray.get(i+1).get(1));
				if(upper<zipArray.get(i+1).get(1)){upper=zipArray.get(i+1).get(1);}
				//System.out.println(" upper:"+upper+ "  ziparray: "+zipArray.get(i+1).get(0)+" : "+zipArray.get(i+1).get(1));
				i++;
				
				
			}
			ArrayList<Integer> arrInner=new ArrayList<>();
			arrInner.add(lower);
			arrInner.add(upper);
			resultZip.add(arrInner);
			
		//	System.out.println(".............................................................................merged["+i+"][0],merged["+i+"][1]"+lower+"-"+upper);
		}
		//System.out.println(resultZip);
		
		return resultZip;
	}
	
}

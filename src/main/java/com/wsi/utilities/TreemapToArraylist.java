package com.wsi.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreemapToArraylist {
	public ArrayList<ArrayList<Integer>> convertZipcodeToArray(TreeMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		List<Map.Entry<Integer, Integer>> entries= new ArrayList<>(map.entrySet());
		ArrayList<ArrayList<Integer>>  arr = new ArrayList<>();
		
	    Iterator entriesIterator = entries.iterator();
		while(entriesIterator.hasNext()){
			
			ArrayList<Integer> arrInner=new ArrayList<>();
			Map.Entry mapping = (Map.Entry) entriesIterator.next();
			arrInner.add((Integer) mapping.getKey());
			arrInner.add((Integer) mapping.getValue());
			arr.add(arrInner);
			
		}
		//System.out.println(arr);
		/*for (ArrayList<Integer> al : arr) {
			System.out.println("al:"+al.get(0)+" : "+al.get(1));
		}*/
	  return arr;
	}

}

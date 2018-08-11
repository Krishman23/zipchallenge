package com.wsi.utilities;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Test;

public class TreemapToArraylistTest {
TreemapToArraylist tToA= new TreemapToArraylist();

@Test
public void testTreemapToArraylist() {	
    System.out.println("Inside testTreemapToArraylist()");    
    //assertEquals(zipcodeMerger.mergeZip(zipArray));  
    //([49679, 52015], [49800, 50000], [51500, 53479], [45012, 46937], [54012, 59607], [45500, 45590], [45999, 47900], [44000, 45000], [43012, 45950])
	    TreeMap <Integer, Integer> map =new TreeMap<Integer, Integer>();
	    
	    map.put(456, 123123);
	    map.put(123, 123123);
	    map.put(856, 123123);
	    map.put(45466, 123123);
	    map.put(1234, 123123);
	    
	    
    	
    	ArrayList<ArrayList <Integer>> arrOuterOutput= new ArrayList<>();

    	
    	ArrayList <Integer> arrInnerInput1= new ArrayList<>();
  	    arrInnerInput1.add(123);
  	    arrInnerInput1.add(123123);
  	    arrOuterOutput.add(arrInnerInput1);
	
       	ArrayList <Integer> arrInnerInput2= new ArrayList<>();
  	    arrInnerInput2.add(456);
  	    arrInnerInput2.add(123123);
  	  arrOuterOutput.add(arrInnerInput2);
  	    
  	    ArrayList <Integer> arrInnerInput3= new ArrayList<>();
  	    arrInnerInput3.add(856);
  	    arrInnerInput3.add(123123);
  	  arrOuterOutput.add(arrInnerInput3);
  	    
  	  ArrayList <Integer> arrInnerInput4= new ArrayList<>();
  	  	arrInnerInput4.add(1234);
  	  	arrInnerInput4.add(123123);
  	  arrOuterOutput.add(arrInnerInput4);
	    
	    ArrayList <Integer> arrInnerInput5= new ArrayList<>();
	    arrInnerInput5.add(45466);
	    arrInnerInput5.add(123123);
	    arrOuterOutput.add(arrInnerInput5);
  	    
  	 	
	    assertEquals(arrOuterOutput, tToA.convertZipcodeToArray(map));
		    
 }

}

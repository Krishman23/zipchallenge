package com.wsi.utilities;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Ignore;

public class ZipcodeMergerTest {
   
	ZipcodeMerger zipcodeMerger = new ZipcodeMerger();
   
   @Test
   public void testValidateZipcode() {	
      System.out.println("Inside testValidateZipcode()");    
      //assertEquals(zipcodeMerger.mergeZip(zipArray));  
      //([49679, 52015], [49800, 50000], [51500, 53479], [45012, 46937], [54012, 59607], [45500, 45590], [45999, 47900], [44000, 45000], [43012, 45950])
	     ArrayList<ArrayList <Integer>> arrOuterInput= new ArrayList<>();
	
	     	ArrayList <Integer> arrInnerInput1= new ArrayList<>();
    	    arrInnerInput1.add(49679);
    	    arrInnerInput1.add(52015);
    	    arrOuterInput.add(arrInnerInput1);
	
         	ArrayList <Integer> arrInnerInput2= new ArrayList<>();
    	    arrInnerInput2.add(49800);
    	    arrInnerInput2.add(50000);
    	    arrOuterInput.add(arrInnerInput2);
    	    
    	    ArrayList <Integer> arrInnerInput3= new ArrayList<>();
    	    arrInnerInput3.add(51500);
    	    arrInnerInput3.add(53479);
    	    arrOuterInput.add(arrInnerInput3);
    	    
    	    //expected o/p [49679, 53479],
    	    ArrayList<ArrayList <Integer>> arrOuterOuput= new ArrayList<>();
    		
	     	ArrayList <Integer> arrInnerOutput1= new ArrayList<>();
    	    arrInnerOutput1.add(49679);
    	    arrInnerOutput1.add(53479);
    	    arrOuterOuput.add(arrInnerOutput1);
    	    System.out.println(zipcodeMerger.mergeZip(arrOuterInput));
    	    assertEquals(arrOuterOuput, zipcodeMerger.mergeZip(arrOuterInput));
		    
   }
}
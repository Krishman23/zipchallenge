package com.wsi.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.wsi.utilities.TreemapToArraylist;
import com.wsi.utilities.ZipcodeMerger;
import com.wsi.utilities.ZipcodeValidator;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,HttpServletRequest request) {
	
		//Read zip range from a file
		InputStream in =  request.getSession().getServletContext().getResourceAsStream("/resources/ziprange.txt");
		 
		 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        StringBuilder out = new StringBuilder();
	        String line;
	        String input="";
	        try {
				while ((line = reader.readLine()) != null) {out.append(line);}
				input=(out.toString());
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    //remove () bracket and remove all white space    
	    input=input.substring(1,input.length()-1).replaceAll(" ", "");
	    
        ZipcodeValidator zipValidator=new ZipcodeValidator();
        ZipcodeMerger zipMerger=new ZipcodeMerger();
        TreemapToArraylist treeToArray= new TreemapToArraylist();
        
        
        List<String> myList = new ArrayList<String>(Arrays.asList(input.split("[\\[\\]]")));
        TreeMap <Integer,Integer> map=new TreeMap<>();
        
        //Tree map will sort by reference to lower range of zip codes
        for (int i = 1; i < myList.size(); i=i+2) {
           String[] zipPair= myList.get(i).split(",");
           //validate zip code
           if(!zipValidator.validateZipcode(zipPair[0]) || !zipValidator.validateZipcode(zipPair[1]) ){
                System.out.println("Invalid format near "+myList.get(i));
                String errorMsg="Invalid format near "+myList.get(i);
                model.addAttribute("inputZip", input );
                model.addAttribute("errorMsg", errorMsg );
                return "home";
           }
            else{
            	//put the zip range in Treemap
            	//make sure lower zip is set as ket of map
            	if(Integer.parseInt(zipPair[0])<Integer.parseInt(zipPair[1])){
                map.put(Integer.parseInt(zipPair[0]),Integer.parseInt(zipPair[1]));
            	}
            	else
            	{
            		map.put(Integer.parseInt(zipPair[1]),Integer.parseInt(zipPair[0]));	
            	}
            }
        }
        

		ArrayList<ArrayList <Integer>> zipArray=new ArrayList<>();
		zipArray= treeToArray.convertZipcodeToArray(map);
		ArrayList<ArrayList <Integer>> mergedZip=new ArrayList<>();
		
		mergedZip=zipMerger.mergeZip(zipArray);
		
		//System.out.println(mergedZip);
		model.addAttribute("inputZip", input );
		model.addAttribute("sortedZip", mergedZip );
		return "home";
	}
	
	
	
}

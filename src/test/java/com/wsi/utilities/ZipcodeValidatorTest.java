package com.wsi.utilities;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;

public class ZipcodeValidatorTest {
   
   ZipcodeValidator zipcodeValidator = new ZipcodeValidator();
   
   @Test
   public void testValidateZipcode() {	
      System.out.println("Inside testValidateZipcode()");    
      assertTrue(zipcodeValidator.validateZipcode("12345"));  
      assertFalse(zipcodeValidator.validateZipcode("1a345"));  
      assertFalse(zipcodeValidator.validateZipcode("1345"));  
      assertFalse(zipcodeValidator.validateZipcode("1444345"));  
   }
}
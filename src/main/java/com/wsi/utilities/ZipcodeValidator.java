package com.wsi.utilities;

public class ZipcodeValidator {

	public boolean validateZipcode(String zip ) {
		// TODO Auto-generated method stub
        return zip.matches("[0-9]{5}");
	}

}

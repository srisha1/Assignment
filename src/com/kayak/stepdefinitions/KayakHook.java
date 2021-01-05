package com.kayak.stepdefinitions;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import com.kayak.base.*;

public class KayakHook extends KayakBase {

	@Before
	public void setup() throws IOException {
		//propertyExtentSetup();
		try {
			createReport();
			initializeDriver();
			openUrl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	@After
	public void tearDown() {
		
		closeBrowser();
		closeReport();
		
	}

}

package com.kayak.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features= "KayakFeatureFile",
glue={"com.kayak.stepdefinitions"}, 
dryRun = false, //if it is true does not execute code just lists if there is any missing mappings for step definition
strict = true, //executes code and then lists if there is any missing mappings for step definition
plugin = { "pretty", "html:test_output","junit:junit_report.cucumber.xml", "json:json.cucumber.json" }, //reports
monochrome = true ) //code readability in output console 

public class KayakRunner {

}








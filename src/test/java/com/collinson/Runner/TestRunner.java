package com.collinson.Runner;


import java.io.*;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import com.cucumber.listener.Reporter;
//import managers.FileReaderManager;
//import com.ntrs.msf.managers.FileReaderManager;



 
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features"
,plugin ="json:target/jsonReports/cucumber-report.json",
glue= {"com.collinson.StepDefinition"})
public class TestRunner {
//tags= {"@DeletePlace"}  compile test verify
}



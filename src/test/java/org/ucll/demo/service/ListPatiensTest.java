package org.ucll.demo.service;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/org/ucll/demo/service/ListPatients.feature"},
        plugin={"html:target/cucumber", "json:target/cucumber.json"}
)
public class ListPatiensTest {}

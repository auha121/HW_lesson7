package ru.gb.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue =
        {"src/test/java/ru/gb/cucumber/steps","src/test/java/ru/gb/cucumber/hooks"})

public class RunnerTest extends AbstractTestNGCucumberTests {
}
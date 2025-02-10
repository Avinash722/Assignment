package com.example.LoginAutomation;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();

String url = "https://www.sourcefuse.com/";

driver.get(url);

String pageTitle = driver.getTitle();

String currentUrl = driver.getCurrentUrl();

System.out.println("Page Title: " + pageTitle);

if (url.equals(currentUrl)) {

System.out.println("URLs match.");

} else {

System.out.println("URLs does not match.");

}

driver.quit();

}

}
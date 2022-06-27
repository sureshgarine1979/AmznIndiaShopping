package com.amazon.shopping.tests;

import amazon.shopping.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class);
    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
        WebDriverManager.chromedriver().setup();

        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        }else if(br.equals("firefox")){
            driver = new FirefoxDriver();
        }
        logger.info("Ths is information Message");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}


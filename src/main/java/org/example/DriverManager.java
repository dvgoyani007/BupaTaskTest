package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import javax.rmi.CORBA.Util;
import java.time.Duration;

public class DriverManager extends Utils{
    public void openBrowser(){
        String browsername = "chrome";

        if (browsername.equalsIgnoreCase("chrome")){
            System.out.println(" Running in Chrome");
            System.setProperty("webdriver.chrome.driver" , "src/test/java/drivers/chromedriver.exe");
            driver = new ChromeDriver();

        }else if (browsername.equalsIgnoreCase("Firefox")){
            System.out.println(" Running in Firefox");
            System.setProperty("webdriver.gecko.driver" , "src/test/java/drivers/geckodriver.exe");
            driver = new ChromeDriver();

        }else if (browsername.equalsIgnoreCase("Edge")){
            System.out.println(" Running in Edge");
            System.setProperty("webdriver.edge.driver" , "src/test/java/drivers/msedgedriver.exe");
            driver = new ChromeDriver();

        }else {
            System.out.println("Either your name is wrong or not provided : " + browsername);
        }

        //Duration to be wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // URL
        driver.get("https://www.bupa.co.uk");
    }
    public void closeBrowser(){
        driver.quit();
    }


}

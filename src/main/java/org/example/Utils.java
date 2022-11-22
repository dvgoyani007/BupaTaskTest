package org.example;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static org.example.BupaTest.driver;

public class Utils extends BasePage {
    public static void ClickOnElement(By by){
        driver.findElement(by).click();

        }
        public static void typeText(By by , String text) {
        driver.findElement(by).sendKeys(text);
        }
        public static String getText(By by){
            driver.findElements(by).clear();
            return null;
        }
        public  static void driverWaitUntilURLToBe(int time, String url){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.urlToBe(url));
        }
        public static void driverWaitsUntilElementToBeClickable(By by,int time){
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        }
        public static void driverWaitUntilVisibilityOfAllElementsLocatedBy(int time, By by) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

        public static void driverWaitUntilVisibilityOfElement(int time, By by){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


        public static String randomDate() {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
            return formatter.format(date);}


        public static void takeSnapShot(String a){

            //convert web driver object to TakeScreenshot
            TakesScreenshot srcShot = ((TakesScreenshot)driver);
            File srcFile = srcShot.getScreenshotAs(OutputType.FILE);


            try{
                FileUtils.copyFile(srcFile,new File("Screenshots\\"+a+randomDate()+".png"));
            } catch (IOException e){
                e.printStackTrace();

            }
    }
}


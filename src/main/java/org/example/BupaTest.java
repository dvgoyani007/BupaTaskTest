package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class BupaTest extends DriverManager {
     By handlecookies=By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
     By healthinsurance=By.xpath("/html/body/div[1]/div[1]/header/div/div[3]/div/div/nav/div/ul[1]/li[1]/a");
     By getquote=By.xpath("//a[contains(text(),'Get a quote')]");
     By validationtitle=By.xpath("//select[@id='Prospect_ApplicantDetails_TitleCode']");
     By selecttitle=By.xpath("//select[@id='Prospect_ApplicantDetails_TitleCode']");
     By validatefirstname=By.xpath("//input[@id='Prospect_ApplicantDetails_FirstName']");
     By typefirstname=By.xpath("//input[@id='Prospect_ApplicantDetails_FirstName']");
     By validatelastname=By.xpath("//input[@id='Prospect_ApplicantDetails_LastName']");
     By typelastname=By.xpath("//input[@id='Prospect_ApplicantDetails_LastName']");
     By policytext=By.xpath("//div[@class=\"col-12 text-center\"]");
     By nextbutton=By.xpath("//button[contains(text(),'Next')]");

     @Test
     public void userShouldBeAbleToSeeQuOte() {

        // Open browser
        openBrowser();

        // Handle cookies
        ClickOnElement(handlecookies);

        // Mouse over on Health Insurance title menu
        Actions action = new Actions(driver);
        WebElement health_insurance = driver.findElement(healthinsurance);
        action.moveToElement(health_insurance).perform();

        // Click on get quote
        ClickOnElement(getquote);
        // get quote link verify in console or print link in console
        System.out.println(driver.getCurrentUrl());


        // validation for title
        driverWaitsUntilElementToBeClickable(validationtitle , 5);
        // Select your title
        Select title = new Select(driver.findElement(selecttitle));
        title.selectByVisibleText("Mrs");


        // Validation for firstname
        driverWaitsUntilElementToBeClickable(validatefirstname,5);
        // Type firstname
        driver.findElement(typefirstname).sendKeys("Haripriyaben");

        // Validation for lastname
        driverWaitsUntilElementToBeClickable(validatelastname,5);
        // Type lastname
        driver.findElement(typelastname).sendKeys("Goyani");

        String text = driver.findElement(policytext).getText();
        System.out.println(text);

        // Click On Next button
        ClickOnElement(nextbutton);

        // Close browser
        closeBrowser();
    }

}


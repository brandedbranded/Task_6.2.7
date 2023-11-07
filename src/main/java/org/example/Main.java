package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driverChrome", "S:\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.edge.driverChrome", "S:\\edgedriver\\msedgedriver.exe");
        System.setProperty("webdriver.firefox.driverChrome", "S:\\firefoxDriver\\geckodriver.exe");
        WebDriver driverChrome = new ChromeDriver();
        WebDriver driverEdge = new EdgeDriver();
        WebDriver driverFirefox = new FirefoxDriver();

        driverChrome.get("https://github.com/brandedbranded?tab=repositories");
        TimeUnit.SECONDS.sleep(1);
        driverChrome.quit();

        driverEdge.get("https://github.com/brandedbranded?tab=repositories");
        TimeUnit.SECONDS.sleep(1);
        driverEdge.quit();

        driverFirefox.get("https://github.com/brandedbranded?tab=repositories");
        TimeUnit.SECONDS.sleep(1);
        driverFirefox.quit();
    }
}
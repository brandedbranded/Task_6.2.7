package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Task_6_2_7 {
    public static void main(String[] args) throws InterruptedException {
        chrome();
        edge();
        firefox();
    }

    public static void chrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "S:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driverChrome = new ChromeDriver();

        driverChrome.get("https://github.com/brandedbranded?tab=repositories");
        TimeUnit.SECONDS.sleep(1);
        driverChrome.quit();
    }

    public static void edge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "S:\\edgedriver\\msedgedriver.exe");
        WebDriver driverEdge = new EdgeDriver();

        driverEdge.get("https://github.com/brandedbranded?tab=repositories");
        TimeUnit.SECONDS.sleep(1);
        driverEdge.quit();
    }

    public static void firefox() throws InterruptedException {
        System.setProperty("webdriver.firefox.driver", "S:\\firefoxDriver\\geckodriver.exe");
        WebDriver driverFirefox = new FirefoxDriver();

        driverFirefox.get("https://github.com/brandedbranded?tab=repositories");
        TimeUnit.SECONDS.sleep(1);
        driverFirefox.quit();
    }
}
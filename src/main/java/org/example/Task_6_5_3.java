package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class Task_6_5_3 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "S:\\chromedriver-win64\\chromedriver.exe");
        actionInsideFrame();
        openNewWindowAndClose();
        popUpAccept();
    }

    public static void actionInsideFrame() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[@href='/iframe']")).click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement writingWindow = driver.findElement(By.xpath("//p"));

        Actions actions = new Actions(driver);
        actions
                .moveToElement(writingWindow)
                .click()
                .click()
                .click()
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("Hello World")
                .click()
                .click()
                .click()
                .build()
                .perform();

        driver.switchTo().defaultContent();
        WebElement buttonB = driver.findElement(By.xpath("//button[@aria-label='Bold']"));
        Actions actions1 = new Actions(driver);
        actions1
                .moveToElement(buttonB)
                .click()
                .build()
                .perform();

        TimeUnit.SECONDS.sleep(4);
        driver.quit();
    }

    public static void openNewWindowAndClose() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://the-internet.herokuapp.com/windows");
        String window1 = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
        Set<String> currentWindows = driver.getWindowHandles();
        String window2 = null;

        for (String window : currentWindows) {
            if (!window.equals((window1))) {
                window2 = window;
                break;
            }
        }

        driver.switchTo().window(window2);
        assertNotEquals(window1, driver.getWindowHandle());
        driver.findElement(By.xpath("//h3[text()='New Window']"));
        driver.close();
        driver.switchTo().window(window1);

        assertEquals(window1, driver.getWindowHandle());

        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }

    public static void popUpAccept() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();
        assertEquals(alert.getText(), "I am a JS Alert");
        alert.accept();
        assertFalse(alertPresent(driver));

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        assertFalse(alertPresent(driver));

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Hello World");
        driver.switchTo().alert().accept();
        assertTrue(driver.getPageSource().contains("You entered: Hello World"));

        TimeUnit.SECONDS.sleep(2);
        driver.quit();
    }

    public static boolean alertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Task_6_3_6 {
    public static void main(String[] args) throws InterruptedException {
        wildBerriesFindAddToCart();
    }

    public static void wildBerriesFindAddToCart() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "S:\\chromedriver-win64\\chromedriver.exe");
        WebDriver driverChrome = new ChromeDriver();

        driverChrome.get("https://www.wildberries.ru/");

        WebElement searchFindByXPath = driverChrome.findElement(By.xpath("//input[@id='searchInput']"));
        WebElement applySearchBtnByXPath = driverChrome.findElement(By.xpath("//button[@id='applySearchBtn']"));
        searchFindByXPath.click();
        TimeUnit.SECONDS.sleep(1);
        searchFindByXPath.sendKeys("Мобильный телефон");

        applySearchBtnByXPath.click();
        TimeUnit.SECONDS.sleep(1);

        WebElement imgByXPath = driverChrome.findElement(By.xpath("//*[@class='product-card__link j-card-link j-open-full-product-card']"));
        imgByXPath.click();
        TimeUnit.SECONDS.sleep(1);

        WebElement addToCartByXPath = driverChrome.findElement(By.xpath("//span[contains(@data-link, 'Добавить в корзину')]"));
        addToCartByXPath.click();
        TimeUnit.SECONDS.sleep(1);

        WebElement goToCartByXPath = driverChrome.findElement(By.xpath("//a[@class='btn-base j-go-to-basket']"));
        goToCartByXPath.click();
        TimeUnit.SECONDS.sleep(1);
        WebElement amountByXPath = driverChrome.findElement(By.xpath("//h1[@data-count='1']"));
        if (amountByXPath.isDisplayed()) {
            TimeUnit.SECONDS.sleep(2);
            driverChrome.quit();
        }
    }
}

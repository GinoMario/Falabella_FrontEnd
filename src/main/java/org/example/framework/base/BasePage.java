package org.example.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By element) throws Exception {
        try {
            performToElement(driver.findElement(element));
            driver.findElement(element).click();
        } catch (Exception e) {
            throw new Exception("No se pudo clickear sobre el elemento: " + element);
        }
    }

    public boolean isDisplayed(WebElement element) throws Exception {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            throw new Exception("No se pudo encontrar el elemento: " + element);
        }
    }

    public String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        } catch (Exception e) {
            throw new Exception("No se pudo obtener el texto del elemento: " + element);
        }
    }

    public void performToElement(WebElement element) throws Exception {
        try {
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            throw new Exception("No se pudo encontrar el elemento" + element);
        }
    }
}

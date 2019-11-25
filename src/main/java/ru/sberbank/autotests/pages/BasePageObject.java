package ru.sberbank.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.sberbank.autotests.utils.DriverManager;

import java.util.List;

public abstract class BasePageObject {

    WebDriverWait wait  = new WebDriverWait(DriverManager.getDriver(), 60);

    public BasePageObject() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public void fillField(WebElement field, String value){
        wait.until(ExpectedConditions.visibilityOf(field));
        field.clear();
        field.sendKeys(value);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }

    public void selectMenuItem(List<WebElement> menuItems, String itemName){
        for (WebElement item : menuItems ){
            if (item.getText().equalsIgnoreCase(itemName)){
                wait.until(ExpectedConditions.visibilityOf(item)).click();
                return;
            }
        }
        Assert.fail("Не найден элмент коллеции - " + itemName);
    }


    public void scrollAndClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("return arguments[0].scrollIntoView(false);", element);
        wait.until(ExpectedConditions.visibilityOf(element)).click();
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getField(WebElement element) {
        return element.getText();
    }


}
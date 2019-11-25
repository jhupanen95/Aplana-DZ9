package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsurancePage extends BasePageObject{

    @FindBy(xpath = "//div[@class='product-teaser-full-width__button']")
    public WebElement buttonToStatement;

}

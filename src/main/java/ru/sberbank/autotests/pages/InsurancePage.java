package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InsurancePage extends BasePageObject{

    @FindBy(xpath = "//a[@class='kit-button  kit-button_default kit-button_type_big analytics-button']")
    public WebElement buttonToStatement;


}

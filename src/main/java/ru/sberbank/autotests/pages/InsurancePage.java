package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.sberbank.autotests.utils.DriverManager;

public class InsurancePage extends BasePageObject{

    @FindBy(xpath = "(//a[@class='kit-button  kit-button_default kit-button_type_big'])[1]")
    public WebElement buttonToStatement;

    public void clickToButton () {
        wait.until(ExpectedConditions.visibilityOf(buttonToStatement));
        String href = buttonToStatement.getAttribute("href");
        DriverManager.getDriver().navigate().to(href);
    }
}

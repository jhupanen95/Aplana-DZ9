package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InsuranceCalsPage extends BasePageObject{

    @FindBy(xpath = "//input[@id='estateCost']")
    public WebElement propertyValue;

    @FindBy(xpath = "//input[@id='initialFee']")
    public WebElement initialPayment;

    @FindBy(xpath = "//input[@id='creditTerm']")
    public WebElement loanPeriod;

    @FindBy(xpath = "//input[@data-test-id='paidToCard']/parent::*")
    public WebElement salaryCardSB;

    @FindBy(xpath = "//input[@data-test-id='canConfirmIncome']/parent::*")
    public WebElement confirmIncome;

    @FindBy(xpath = "//input[@data-test-id='youngFamilyDiscount']/parent::*")
    public WebElement youngFamily;


    @FindBy(xpath = "(//span[@data-test-id='amountOfCredit'])[1]")
    public WebElement amountOfCredit;

    @FindBy(xpath = "(//span[@data-test-id='monthlyPayment'])[1]")
    public WebElement monthlyPayment;

    @FindBy(xpath = "(//span[@data-test-id='requiredIncome'])[1]")
    public WebElement requiredIncome;

    @FindBy(xpath = "(//span[@data-test-id='rate'])[1]")
    public WebElement rate;


    public String getField(WebElement element) {
        return element.getText()
                .replaceAll(" ", "")
                .replaceAll("₽", "")
                .replaceAll("%", "");
    }

    public void fillField(WebElement field, String value){
        wait.until(ExpectedConditions.visibilityOf(field));
        field.clear();
        field.sendKeys(value);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

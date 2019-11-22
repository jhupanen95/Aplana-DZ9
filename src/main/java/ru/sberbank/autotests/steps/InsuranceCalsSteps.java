package ru.sberbank.autotests.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.junit.Assert;
import ru.sberbank.autotests.pages.InsuranceCalsPage;

import java.util.Map;

public class InsuranceCalsSteps {

    @Step("поле \"{0}\" заполняется значением \"{1}\"")
    public void fillField(String fill, String date) {
        InsuranceCalsPage insuranceCalsPage = new InsuranceCalsPage();
        switch (fill) {
            case "Стоимость недвижимости":
                insuranceCalsPage.fillField(insuranceCalsPage.propertyValue, date);
                break;
            case "Первоначальный взнос":
                insuranceCalsPage.fillField(insuranceCalsPage.initialPayment, date);
                break;
            case "Срок кредита":
                insuranceCalsPage.fillField(insuranceCalsPage.loanPeriod, date);
                break;
            default:
                Assert.fail("Не найдено поле - " + fill);
        }
    }

    @When("нажат чекбокс \"(.*)\"")
    public void clickCheck(String checkBox) {

        InsuranceCalsPage insuranceCalsPage = new InsuranceCalsPage();
        switch (checkBox) {
            case "Есть зарплатная карта Сбербанка":
                insuranceCalsPage.scrollAndClick(insuranceCalsPage.salaryCardSB);
                break;
            case "Есть возможность подтвердить доход справкой":
                insuranceCalsPage.scrollAndClick(insuranceCalsPage.confirmIncome);
                break;
            case "Молодая семья":
                insuranceCalsPage.scrollAndClick(insuranceCalsPage.youngFamily);
                break;
            default:
                Assert.fail("Не найден чекбокс - " + checkBox);
        }
    }

    @Step("значение \"{0}\" равно \"{1}\"")
    public void checkField (String field, String value) {
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InsuranceCalsPage insuranceCalsPage = new InsuranceCalsPage();
        switch (field) {
            case "Сумма кредита":
                Assert.assertTrue(value.equals(insuranceCalsPage.getField(insuranceCalsPage.amountOfCredit)));
                break;
            case "Ежемесячный платеж":
                Assert.assertTrue(value.equals(insuranceCalsPage.getField(insuranceCalsPage.monthlyPayment)));
                break;
            case "Необходимый доход":
                Assert.assertTrue(value.equals(insuranceCalsPage.getField(insuranceCalsPage.requiredIncome)));
                break;
            case "Процентная ставка":
                Assert.assertTrue(value.equals(insuranceCalsPage.getField(insuranceCalsPage.rate)));
                break;
            default:
                Assert.fail("Не найден элемент - " + field);
        }
    }

    @When("заполняются поля:")
    public void fillFields(Map<String,String> fields) {
        fields.forEach(
                (k, v) -> {
                    try {
                        fillField(k, v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Then("иформация по кредиту равна:")
    public void checkfillFields(Map<String,String> fields) {
        fields.forEach(
                (k, v) -> {
                    try {
                        checkField(k, v);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );
    }

}

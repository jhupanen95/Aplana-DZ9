package ru.sberbank.autotests.steps;

import cucumber.api.java.en.When;
import ru.sberbank.autotests.pages.InsurancePage;
import ru.sberbank.autotests.pages.MainPage;

public class InsuranceSteps {
    @When("нажата кнопка Подать заявку")
    public void hoverMenuItem() {
        InsurancePage insurancePage = new InsurancePage();
        insurancePage.scrollAndClick(insurancePage.buttonToStatement);
    }
}

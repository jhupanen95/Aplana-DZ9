package ru.sberbank.autotests.steps;

import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import ru.sberbank.autotests.pages.MainPage;

public class MainSteps {

    @When("выбран пункт \"(.*)\" главного меню")
    public void hoverMenuItem(String menuItem) {
        new MainPage().selectMenuItem(menuItem);
    }

    @When("нажат пункт \"(.*)\" выпадающего меню")
    public void clickToItemSubMenu(String subMenuItem){
        new MainPage().selectSubMenuItem(subMenuItem);
    }
}

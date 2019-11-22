package ru.sberbank.autotests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePageObject{

    @FindBy(xpath = "//ul[@class='lg-menu__list']/li")
    List<WebElement> mainMenu;

    @FindBy(xpath = "//a[@class='lg-menu__sub-link']")
    List<WebElement> subMenu;

    public void selectMenuItem(String itemName){
        selectMenuItem(mainMenu, itemName);
    }

    public void selectSubMenuItem(String itemName){
        selectMenuItem(subMenu, itemName);
    }

}

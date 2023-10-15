package com.ilcarro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement title;
    public HomePage isHomePageTitlePresent() {
        assert isElementDisplayed(title);
        return this;
    }

    @FindBy(xpath = "//a[.=' Log in ']")
    WebElement logInLink;
    public LoginPage clickOnLogInLink() {
        click(logInLink);
        return new LoginPage(driver);
    }
}

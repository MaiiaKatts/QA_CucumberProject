package com.ilcarro.pages;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    public LoginPage enterValidData(String email, String password) {
        type(emailInput, email);
        type(passwordInput,password);
        return this;
    }

    @FindBy(css = "[type='submit']")
    WebElement yallaButton;
    public LoginPage clickOnYallaButton() {
        click(yallaButton);
        return this;
    }
    @FindBy(xpath = "//h2[.='Logged in success']")
    WebElement successMessage;
    public LoginPage isLoginMessageDisplayed() {
    assert isElementDisplayed(successMessage);
        return this;
    }

    public LoginPage enterWrongPassword(DataTable dataTable) {
        List<Map<String,String>> table = dataTable.asMaps();

        String userEmail = table.get(0).get("email");
        String userPassword = table.get(0).get("password");

        enterValidData(userEmail,userPassword);
        return this;
    }

    @FindBy(xpath = "//h1[.='Login failed']")
    WebElement failedInputDataMessage;

    public LoginPage getError() {
        Duration timeout = Duration.ofSeconds(10); // Set the timeout to 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        wait.until(ExpectedConditions.visibilityOf(failedInputDataMessage));

        if (!isElementDisplayed(failedInputDataMessage)) {
            throw new AssertionError("Error message not displayed");
        }

        return this;
    }
}
package com.mitigram.pages;

import com.mitigram.utilities.ConfigurationReader;
import com.mitigram.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "input#Email")
    public WebElement emailInput;

    @FindBy(css = "input#Password")
    public WebElement passwordInput;

    @FindBy(xpath = "//span[.=\"Log in\"]")
    public WebElement login;

    @FindBy(css = ".noty_body")
    public WebElement notification;

    @FindBy(xpath = "//a[.='Contact us']")
    public WebElement contactUs;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPassword;

    @FindBy(css = "p.text-center")
    public WebElement confirmationMessage;

    public void selectStore(String store) {
        int i = (store.equals("AppStore")) ? 1 : 2;
        Driver.get().findElement(By.xpath("(//img[@class='img-responsive'])[" + i + "]")).click();
    }

    public void login() {
        emailInput.sendKeys(ConfigurationReader.get("email"));
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        login.click();
    }

}
package com.mitigram.pages;

import com.mitigram.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//a[.=\"Log in\"])[2]")
    public WebElement login;

    @FindBy(css = ".jl-notification-close")
    public WebElement closeNotification;

    @FindBy(css = ".jl-notification-top-right")
    public WebElement notification;

    public void navigateToPage(String page) {
        Driver.get().findElement(By.xpath("//a[.='" + page + "']")).click();
    }
}

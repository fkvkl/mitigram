package com.mitigram.pages;

import com.mitigram.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CareersPage {

    public CareersPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@href=\"#open-positions\"]")
    public WebElement openPositions;

    @FindBy(css = "span#open-positions")
    public WebElement openPositionsHeader;

    @FindBy(xpath = "//div[@class='tm-wrapper'][@style!='display: none;']")
    public List<WebElement> positions;

    public void chooseFilter(String category) {
        Driver.get().findElement(By.xpath("//a[.='" + category + "']")).click();
    }

    public void selectPosition_LearnMore(String position) {
        Driver.get().findElement(By.xpath("//a[.='" + position + "']")).click();
        Driver.get().findElement(By.xpath("//a[.='" + position + "']/..//a[.='Learn more']")).click();
    }

    public void selectPosition_Apply(String position) {
        Driver.get().findElement(By.xpath("//a[.='" + position + "']")).click();
        Driver.get().findElement(By.xpath("//a[.='" + position + "']/..//a[.='Apply for this position']")).click();
    }
}

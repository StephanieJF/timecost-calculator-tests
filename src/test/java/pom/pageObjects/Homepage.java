package pom.pageObjects;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.base.BasePage;

public class Homepage extends BasePage {
    WebDriver driver;

    public Homepage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='accordion-header']/button") WebElement videoAccordionBtn;
    @FindBy(id = "totalAnnualIncome") WebElement annualIncomeFld;
    @FindBy(tagName = "iframe") WebElement iframeWindow;

    public void clickVideoAccordianButton(){
        videoAccordionBtn.click();
    }

    public Dimension getiFrameSize(){
        return iframeWindow.getSize();
    }

    public void enterTotalAnnualIncome(Double incomeNum){
        String incomeEntered = incomeNum.toString();
        annualIncomeFld.sendKeys(incomeEntered);
    }

}

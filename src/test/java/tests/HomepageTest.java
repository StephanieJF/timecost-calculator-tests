package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.base.BaseTest;
import pom.pageObjects.Homepage;

public class HomepageTest extends BaseTest {

    @Test
    public void verifyAccordionOpens() throws InterruptedException {
        Homepage homepage = new Homepage(driver);

        //accordion opens, iframe height > 0
        homepage.clickVideoAccordianButton();
        WebElement accordionVideo = driver.findElement(By.id("collapseOne"));
        wait.until(ExpectedConditions.attributeContains(accordionVideo,"class", "accordion-collapse collapse show"));
        Assert.assertTrue(homepage.getiFrameSize().height > 0);

        //accordion closes, iframe height = 0
        homepage.clickVideoAccordianButton();
        wait.until(ExpectedConditions.attributeContains(accordionVideo, "class", "accordion-collapse collapse"));
        Assert.assertEquals(homepage.getiFrameSize().height, 0);
    }

}

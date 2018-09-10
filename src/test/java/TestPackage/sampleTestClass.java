package TestPackage;

import PageElements.MainPage;
import PageElements.iletisimPage;
import Shared.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class sampleTestClass {

    protected static WebDriver driver;
    private static String OS = System.getProperty("os.name").toUpperCase();


    @Before
    public void Init() {

        if (OS.contains("MAC OS X")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        } else if (OS.contains("WİNDOWS 10")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        }

        driver = new ChromeDriver();

    }

    @Test
    public void sampleTestMethod() throws Exception {

        Utils.startRecording("sampleTestMethod"); // Start Video

        // Test Script
        WebDriverWait wait = new WebDriverWait(driver, 15);
        MainPage element = PageFactory.initElements(sampleTestClass.driver, MainPage.class);

        driver.navigate().to("http://testkalite.com/");
        wait.until(ExpectedConditions.elementToBeClickable(element.iletisimMenu));
        element.iletisimMenu.click();

        iletisimPage iletisim = PageFactory.initElements(sampleTestClass.driver, iletisimPage.class);

        List<String> expectedInputsID = new ArrayList<String>();
        expectedInputsID.add("item-vfb-5");
        expectedInputsID.add("item-vfb-7");
        expectedInputsID.add("item-vfb-8");
        expectedInputsID.add("item-vfb-10");

        List<String> actualInputsID = new ArrayList<String>();
        for (WebElement test : iletisim.iletisimMenuInputs) {
            actualInputsID.add(test.getAttribute("id"));
        }

        Assert.assertEquals(expectedInputsID, actualInputsID);

    }

    @After
    public void Teardown() throws Exception {

        Utils.stopRecording(); // Stop Video

        if (driver != null) {
            driver.quit();
        }

    }
}

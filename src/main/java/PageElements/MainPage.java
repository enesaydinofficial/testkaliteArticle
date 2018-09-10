package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = "//ul[@id='menu-ust-menuler-1']//a[contains(text(), 'İletişim')]")
    public WebElement iletisimMenu;
}

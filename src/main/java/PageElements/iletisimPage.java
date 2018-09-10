package PageElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class iletisimPage {

    @FindBy(css = ".vfb-section-1 li")
    public List<WebElement> iletisimMenuInputs;
}

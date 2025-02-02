import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    @BeforeMethod
    public void setUp(){
        Configuration.baseUrl = "https://www.finalsurge.com/";
        Configuration.browser = "safari";
        Configuration.timeout = 20000;
        Configuration.clickViaJs = true; //прожимает кнопки, которые скрываются за элементам
    }
}

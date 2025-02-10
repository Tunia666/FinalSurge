package test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp(){
        Configuration.headless = true;
        Configuration.baseUrl = "https://www.finalsurge.com/";
        Configuration.browser = "chrome";
        Configuration.timeout = 20000;
        Configuration.clickViaJs = true; //прожимает кнопки, которые скрываются за элементам
    }
}

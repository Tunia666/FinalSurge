package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginPage {
    public LoginPage openAuthorization(){
        open("https://www.finalsurge.com/");
        $x("//span[contains(text(), 'Log In')]").click();
        Selenide.sleep(2000);
        return this;
    }
    public LoginPage loginUser(String login, String password){
        $("input[name='email']").shouldBe(Condition.visible).setValue(login);
        $("input[name='password']").shouldBe(Condition.visible).setValue(password);
        $("div.check-option__box").shouldBe(Condition.visible).click();
        $("button[type='submit'][class*='action-button--primary']")
                .shouldBe(Condition.visible)
                .click();
        Selenide.sleep(2000);
        return this;
    }
}

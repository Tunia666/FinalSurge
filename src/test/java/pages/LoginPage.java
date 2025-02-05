package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginPage {
    private final SelenideElement loginButton = $x("//span[contains(text(), 'Log In')]");
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement passwordInput = $("input[name='password']");
    private final SelenideElement checkBox = $("div.check-option__box");
    private final SelenideElement submitButton = $("button[type='submit'][class*='action-button--primary']");

    public LoginPage openAuthorization() {
        open("https://www.finalsurge.com/");
        loginButton.click();
        Selenide.sleep(2000);
        return this;
    }

    public LoginPage loginUser(String login, String password) {
        emailInput.shouldBe(Condition.visible).setValue(login);
        passwordInput.shouldBe(Condition.visible).setValue(password);
        checkBox.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.visible).click();
        Selenide.sleep(2000);
        return this;
    }
}

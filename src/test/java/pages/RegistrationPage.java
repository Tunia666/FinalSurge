package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public RegistrationPage openRegistration() {
        open("https://www.finalsurge.com/");
        $("a[href='/signup'].action-button--primary").shouldBe(visible).click();
        $("h1.h4").shouldHave(Condition.text("Begin your account as..."));
        $("div.check-option__box[data-v-21593069]").shouldBe(Condition.visible)
                .click();
        $("button.action-button--primary[type='submit']").shouldBe(Condition.visible).click();
        $("h1.h4.sign-up-form-inputs__label").shouldHave(Condition.text("Create Athlete Account"));
        return this;
    }

    public RegistrationPage registrationUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        $("input[name='firstName'].text-field--required").shouldBe(visible).setValue(firstName);
        $("input[name='lastName'].text-field--required").shouldBe(visible).setValue(lastName);
        $("input[name='_none'].text-field--required").shouldBe(visible).setValue(email);
        $("input[name='new-password'].text-field--required").shouldBe(visible).setValue(password);
        $("input[name='repeatPassword'].text-field--required").shouldBe(visible).setValue(repeatPassword);
        $("button.action-button--primary[type='submit']").shouldBe(visible).click();
        return this;
    }

    public RegistrationPage checkErrorMessage(String expectedError) {
        $("div.field-footer__error").shouldBe(visible).shouldHave(text(expectedError));
        return this;
    }
}

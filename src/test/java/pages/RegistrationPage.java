package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    SelenideElement registrationButton = $("a[href='/signup'].action-button--primary");
    SelenideElement beginAccountHeader = $("h1.h4");
    SelenideElement checkBox = $("div.check-option__box[data-v-21593069]");
    SelenideElement submitButton = $("button.action-button--primary[type='submit']");
    SelenideElement createAthleteAccountHeader = $("h1.h4.sign-up-form-inputs__label");
    SelenideElement firstNameInput = $("input[name='firstName'].text-field--required");
    SelenideElement lastNameInput = $("input[name='lastName'].text-field--required");
    SelenideElement emailInput = $("input[name='_none'].text-field--required");
    SelenideElement passwordInput = $("input[name='new-password'].text-field--required");
    SelenideElement repeatPasswordInput = $("input[name='repeatPassword'].text-field--required");
    SelenideElement errorMassage = $("div.field-footer__error");
    public RegistrationPage openRegistration() {
        open("https://www.finalsurge.com/");
        registrationButton.shouldBe(visible).click();
        beginAccountHeader.shouldHave(Condition.text("Begin your account as..."));
        checkBox.shouldBe(Condition.visible).click();
        submitButton.shouldBe(Condition.visible).click();
        createAthleteAccountHeader.shouldHave(Condition.text("Create Athlete Account"));
        return this;
    }

    public RegistrationPage registrationUser(String firstName, String lastName, String email, String password, String repeatPassword) {
        firstNameInput.shouldBe(visible).setValue(firstName);
        lastNameInput.shouldBe(visible).setValue(lastName);
        emailInput.shouldBe(visible).setValue(email);
        passwordInput.shouldBe(visible).setValue(password);
        repeatPasswordInput.shouldBe(visible).setValue(repeatPassword);
        submitButton.shouldBe(visible).click();
        return this;
    }

    public RegistrationPage checkErrorMessage(String expectedError) {
        errorMassage.shouldBe(visible).shouldHave(text(expectedError));
        return this;
    }
}

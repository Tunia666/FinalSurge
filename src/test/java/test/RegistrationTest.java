package test;

import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test(testName = "Регистрация валидного пользователя",
            description = "Выполнено 1 раз для регистрации пользователя")
    public void registeringUser() {
        registrationPage.openRegistration().
                registrationUser("Tunia", "Prilepskaya", "truda1999@gmail.com",
                        "Password12345!", "Password12345!");
    }

    @Test(testName = "Имя при регистрации отсутствует",
            description = "Отсутствие имени при регистрации")
    public void registeringInvalidUserName() {
        registrationPage.openRegistration().
                registrationUser("", "Prilepskaya", "truda1999@gmail.com",
                        "Password12345!", "Password12345!")
                .checkErrorMessage("First Name is required");
    }

    @Test(testName = "Email не соответствует требованиям",
            description = "Неправильная почта при регистрации")
    public void registeringInvalidUserEmail() {
        registrationPage.openRegistration()
                .registrationUser("Tunia", "Prilepskaya", "truda1999gmail.com",
                        "Password12345!", "Password12345!")
                .checkErrorMessage("Email is not valid");
    }

    @Test(testName = "Пароль не соответствует требованиям",
            description = "Неправильная почта при регистрации")
    public void registeringInvalidUserPassword() {
        registrationPage.openRegistration()
                .registrationUser("Tunia", "Prilepskaya", "truda1999@gmail.com",
                        "Password", "Password12345!")
                .checkErrorMessage("Must be 7-15 characters long, must include: " +
                        "upper-case letter, lower-case letter, number.");
    }

    @Test(testName = "Пароли не совпадают",
            description = "Повторный пароль не соответствует введенному ранее")
    public void registeringInvalidUserRepeatPassword() {
        registrationPage.openRegistration()
                .registrationUser("Tunia", "Prilepskaya", "truda1999@gmail.com",
                        "Password12345!", "Password!54321")
                .checkErrorMessage("Repeated password does not match original one.");
    }
}

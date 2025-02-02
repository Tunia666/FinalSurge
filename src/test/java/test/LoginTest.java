package test;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    LoginPage loginPage = new LoginPage();
    @Test(testName = "Авторизация пользователя",
            description = "Валидная авторизация пользователя")
    public void validUser(){
        loginPage.openAuthorization().loginUser("truda1999@mail.com","Password12345!");
    }
}

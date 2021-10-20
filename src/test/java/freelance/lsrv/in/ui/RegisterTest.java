package freelance.lsrv.in.ui;

import freelance.lsrv.in.BaseTest;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegister() {
        openAppSelenide("register");
        RegisterPage registerPage = new RegisterPage();
        registerPage.setUsername("Username1");
        registerPage.setName("Name1");
        registerPage.setLastName("Last Name1");
        registerPage.setPassword("Password1");
        registerPage.setConfirmPassword("Password1");
        registerPage.clickRegisterButton();
    }
}
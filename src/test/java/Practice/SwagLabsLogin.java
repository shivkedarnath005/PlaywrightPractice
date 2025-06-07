package Practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class SwagLabsLogin
{
    @Test
    public void loginTest() throws InterruptedException {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://www.saucedemo.com/v1/");
        Locator username = page.locator("//input[@id='user-name']");
        Locator password = page.locator("//input[@id='password']");
        Locator login_button = page.locator("//input[@id='login-button']");

        username.fill("standard_user");
        password.fill("secret_sauce");
        login_button.click();

        System.out.println("Swag Labs Login has been Successful");
        Thread.sleep(2000);

    }
}

package MultipleBrowsers;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class MultiBrowsersTesting
{
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page ;

    @Test
    public void loginTestChrome()
    {
        initBrowser("chromium");
        page.navigate("https://www.saucedemo.com/v1/");
        Locator username = page.getByPlaceholder("Username");
        username.fill("standard_user");
        Locator password = page.getByPlaceholder("Password");
        password.fill("secret_sauce");
        Locator loginButton = page.locator("//input[@id='login-button']");
        loginButton.click();
        System.out.println("Swag Labs Login Successful Chrome");
        closeBrowser();

    }

    @Test
    public void loginTestFirefox()
    {
        initBrowser("firefox");
        page.navigate("https://www.saucedemo.com/v1/");
        Locator username = page.getByPlaceholder("Username");
        username.fill("standard_user");
        Locator password = page.getByPlaceholder("Password");
        password.fill("secret_sauce");
        Locator loginButton = page.locator("//input[@id='login-button']");
        loginButton.click();
        System.out.println("Swag Labs Login Successful Firefox");
        closeBrowser();

    }

    @Test
    public void loginTestWebKit()
    {
        initBrowser("webkit");
        page.navigate("https://www.saucedemo.com/v1/");
        Locator username = page.getByPlaceholder("Username");
        username.fill("standard_user");
        Locator password = page.getByPlaceholder("Password");
        password.fill("secret_sauce");
        Locator loginButton = page.locator("//input[@id='login-button']");
        loginButton.click();
        System.out.println("Swag Labs Login Successful WebKit");
        closeBrowser();

    }

    public static void initBrowser(String browserName)
    {
        playwright = Playwright.create();

        switch (browserName.toLowerCase())
        {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("firefox"));
                break;

            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("webkit"));
                break;

            default :
                System.out.println("No browser input selected");

        }
        context = browser.newContext();
        page = context.newPage();
    }

    public static void closeBrowser()
    {
        if(browser != null)
        {
            browser.close();
        }
        if(playwright != null)
        {
            playwright.close();
        }
    }

}

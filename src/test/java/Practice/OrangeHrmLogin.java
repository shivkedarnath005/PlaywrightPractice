package Practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class OrangeHrmLogin {
    @Test
    public void loginTest() throws InterruptedException {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext context = bw.newContext();
        Page page = context.newPage();

        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        page.getByPlaceholder("Username").fill("Admin");
        page.getByPlaceholder("Password").fill("admin123");
        //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
        page.getByText("Login").first().click();
        System.out.println("Orange HRM Login has been successful");
        Thread.sleep(5000);
        pw.close();

    }

    @Test
    public void login()
    {
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"))
                  .newContext().newPage();
        page.navigate("url");
    }
}

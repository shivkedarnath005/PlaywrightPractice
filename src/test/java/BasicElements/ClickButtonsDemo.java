package BasicElements;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class ClickButtonsDemo
{

    @Test
    public void clickButtonTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/");

        //way 1
        page.click("//button[normalize-space()='SKIP LOGIN']");
        //way 2
        page.locator("//button[normalize-space()='SKIP LOGIN']").click();

        Thread.sleep(3000);
        pw.close();
    }
}

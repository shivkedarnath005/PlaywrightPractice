package BasicElements;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class RadioButtonClick
{

    @Test
    public void clickRadioButtonTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/form");

        //way 1
        page.check("//input[@value='Female']");

        //way 2
        page.locator("//input[@value='automation_testing']").check();

        //way 3
        page.locator("//input[@value='automation_testing']").click();

        Thread.sleep(3000);
        pw.close();
    }
}

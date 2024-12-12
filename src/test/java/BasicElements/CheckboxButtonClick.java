package BasicElements;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class CheckboxButtonClick
{

    @Test
    public void clickCheckboxButtonTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/form");

        //way 1
        page.check("//input[@value='true']");
        page.uncheck("//input[@value='true']");

        page.locator("//input[@value='automation_testing']").check();

        if(page.locator("//input[@value='automation_testing']").isChecked())
        {
            page.uncheck("//input[@value='automation_testing']");
            System.out.println("Checkbox handled");
        }

        Thread.sleep(3000);
        pw.close();
    }
}

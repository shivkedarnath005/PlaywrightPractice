package BasicElements;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingTextBoxTest
{

    @Test
    public void textBoxTypeMethod() throws InterruptedException {
        Playwright pw = Playwright.create();
        Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();

        page.navigate("https://dev.automationtesting.in/form");

        //way 1
        page.fill("//input[@id=':r0:']", "Amol");

        //way 2
        page.locator("//input[@id=':r1:']").fill("Deokar");

        String address = "Alandi Road Digihi Pune 411015";
        page.fill("//textarea[@id=':r2:']",address, new Page.FillOptions().setTimeout(500));
        //page.locator("//textarea[@id=':r2:']").fill(address);
        Thread.sleep(5000);
    }
}

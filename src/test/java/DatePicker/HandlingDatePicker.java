package DatePicker;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingDatePicker
{
    //Two types of date picker
    //Enabled and Disabled Date Picker
    @Test
    public void datePickerTest() throws InterruptedException
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();

        page.navigate("https://demo.automationtesting.in/Datepicker.html");
        Thread.sleep(3000);

        page.locator("//input[@id='datepicker2']").fill("12/26/2024");
        page.keyboard().press("Enter");
        Thread.sleep(2000);
        System.out.println("Date is selected");
        pw.close();


    }
}

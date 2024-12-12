package DatePicker;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class DisabledDatePicker
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

        //page.evaluate("document.getElementById('datepicker1').value('11/29/2025')");

        page.evaluate("document.querySelector('#datepicker1').value('11/29/2025')");

        Thread.sleep(5000);
        page.close();


    }
}

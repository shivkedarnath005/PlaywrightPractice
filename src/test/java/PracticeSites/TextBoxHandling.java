package PracticeSites;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class TextBoxHandling
{
    @Test
    public void textBoxDemo()
    {
        Playwright pw = Playwright.create();
        BrowserType bwType = pw.chromium();
        Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(1000));
        BrowserContext bwContext = bw.newContext();
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/text-box");

        page.locator("//input[@placeholder='Full Name']").fill("Ravi Jadhav");
        page.locator("//input[@id='userEmail']").fill("ravijadhav@gmail.com");
        String current_address = "Flat no 100, New Archade J M Road ShivajiNagar Pune - 411015";
        page.locator("//textarea[@placeholder='Current Address']").fill(current_address);
        String permnt_address = "At Vadgaon Post Bhoom Tq Bhoom Dist Osmanabad - 413504";
        page.locator("//textarea[@id='permanentAddress']").fill(permnt_address);
        page.locator("//button[normalize-space()='Submit']").click();
        System.out.println("Text Box Elements on the page are handled successfully");

        page.close();
        pw.close();

    }
}

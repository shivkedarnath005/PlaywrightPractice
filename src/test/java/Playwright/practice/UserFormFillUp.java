package Playwright.practice;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class UserFormFillUp {
    Playwright pw = Playwright.create();
    BrowserType bwType = pw.chromium();
    Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bwContext = bw.newContext();
    Page page = bwContext.newPage();

    @Test
    public void userFormFillTest()
    {
        page.navigate("https://demoqa.com/text-box");
        userFormFillUp();
    }

    public void userFormFillUp() {
        try {
            Locator fullName = page.locator("//input[@placeholder='Full Name']");
            Locator email = page.locator("//input[@id='userEmail']");
            Locator currentAddress = page.locator("//textarea[@id='currentAddress']");
            Locator permanentAddress = page.locator("//textarea[@id='permanentAddress']");
            Locator submitBtn = page.locator("//button[@id='submit']");

            fullName.fill("Ravi Sharma");
            email.fill("ravisharma@gmail.com");
            currentAddress.fill("Flat No 101, Sai Park J M Road Shivaji Nagar Pune - 411015");
            permanentAddress.fill("At Vadgaon Tal Ambegaon Dist Pune ");
            submitBtn.click();

        } catch (Exception e) {
            System.out.println("Failed to fill up the User form");
        }
    }
}

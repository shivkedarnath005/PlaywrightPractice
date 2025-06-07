package Practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class PlaywrightTechniques {
    Playwright pw = Playwright.create();
    BrowserType bwType = pw.chromium();
    Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bwContext = bw.newContext();

    @Test
    public void textBoxHandling()
    {
        try {
            Page page = bwContext.newPage();
            page.waitForLoadState();
            page.navigate("https://demoqa.com/text-box");
            Locator fullName = page.getByPlaceholder("Full Name");
            Locator email = page.getByPlaceholder("name@example.com");
            Locator currentAddress = page.getByPlaceholder("Current Address");
            Locator permanentAddress = page.locator("textarea#permanentAddress");
            Locator submitButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));

            fullName.fill("Ravi Sharma");
            email.fill("ravisharma@gmail.com");
            currentAddress.fill("Flat No 101, Sai Park Society, J M Road Shivaji Nagar Pune - 411015");
            System.out.println("User has entered the Current Address");
            permanentAddress.fill("At/Post Vadgaon Taluka Khed Pune - 411015");
            submitButton.click();

        } catch (Exception e) {
            System.out.println("Failed to fill the text box elements with details" + e.getMessage());
        }
    }

    @Test
    public void handlingCheckbox()
    {
        Page page = bwContext.newPage();
        page.waitForLoadState();
        page.navigate("https://demoqa.com/checkbox");
        Locator checkbox = page.locator("//span[@class='rct-checkbox']//*[name()='svg']");
        checkbox.click();
        System.out.println("Checkbox has been selected");
    }
}

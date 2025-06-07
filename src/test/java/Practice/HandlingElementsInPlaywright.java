package Practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class HandlingElementsInPlaywright {
    Playwright pw = Playwright.create();
    BrowserType bwType = pw.chromium();
    Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bwContext = bw.newContext();

    @Test
    public void handlingWebTables()
    {
        try {
            Page page = bwContext.newPage();
            page.waitForLoadState();
            page.navigate("https://demoqa.com/webtables");

            Locator addTable = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add"));
            Locator firstName = page.getByPlaceholder("First Name");
            Locator lastName = page.getByPlaceholder("Last Name");
            Locator userEmail = page.locator("#userEmail");
            Locator userAge = page.getByPlaceholder("Age");
            Locator salary = page.locator("#salary");
            Locator department = page.getByPlaceholder("Department");
            Locator submitBtn = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit"));
            Locator searchBox = page.getByPlaceholder("Type to search");
            Locator searchBtn = page.locator("//span[@id='basic-addon2']//span//*[name()='svg']");
            Locator firstNameSearch = page.locator("//div[normalize-space()='Ravi']");

            addTable.click();
            page.waitForTimeout(3000);
            firstName.fill("Ravi");
            lastName.fill("Sharma");
            userEmail.fill("ravisharma@gmail.com");
            userAge.fill("57");
            salary.fill("100000");
            department.fill("Computer Engineering");
            System.out.println("User has entered all the details in Form");
            submitBtn.click();
            System.out.println("User clicked on the Submit Button");
            searchBox.fill("Sharma");
            searchBtn.click();
            PlaywrightAssertions.assertThat(firstNameSearch).isEnabled();
            System.out.println("WebTable Test has been Successfully Validated");

        } catch (Exception e) {
            System.out.println("Failed to Add the User Details in Web Table" + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

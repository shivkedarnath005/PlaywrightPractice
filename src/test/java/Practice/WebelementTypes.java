package Practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

public class WebelementTypes {
    Playwright pw = Playwright.create();
    BrowserType bwType = pw.chromium();
    Browser bw = bwType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
    BrowserContext bwContext = bw.newContext();

    @Test
    public void mainTestMethod()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/date-picker");
        pickDateInCalendar(page, "2026", "July", "16");
    }
    public void pickDateInCalendar(Page page, String year, String month, String day)
    {
        try {
            Locator calendar = page.locator("#datePickerMonthYearInput");
            calendar.click();
            page.waitForTimeout(2000);
            page.selectOption(".react-datepicker__year-select", new SelectOption().setValue(year));
            System.out.println("Selected the Year In Calendar");
            page.selectOption(".react-datepicker__month-select", new SelectOption().setLabel(month));
            System.out.println("Selected the Month In Calendar");

            page.waitForTimeout(2000);
            Locator dayButton = page.locator("//div[@class='react-datepicker__month']//div[contains(text(),'"+ day + "')]");
            if (dayButton.isVisible()) {
                dayButton.click();
                System.out.println("Selected the Date In Calendar");
            } else {
                System.out.println("Failed to find the date in the Calendar");

            }
        } catch (Exception e) {
            System.out.println("Failed to Pick the Date in the Calendar");
            throw new RuntimeException(e);
        }
    }

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

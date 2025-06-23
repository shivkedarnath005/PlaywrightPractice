package Practice;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.nio.file.Paths;

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

    @Test
    public void takeFullPageScreenshot()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/elements");
        page.waitForLoadState();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("./Screenshots/demoqapage.png"))
                          .setFullPage(true));
        page.waitForTimeout(2000);
        System.out.println("Full page screenshot is taken");
        pw.close();
    }

    @Test
    public void captureElementScreenshot()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/elements");
        page.waitForLoadState();

        page.locator("//img[@src='/images/Toolsqa.jpg']").screenshot(new Locator.ScreenshotOptions()
                     .setPath(Paths.get("./Screenshots/ToolsQA.png")));
        page.waitForTimeout(2000);
        System.out.println("The Element screenshot is taken");
        pw.close();
    }

    @Test
    public void openLinkInNewTab()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/links");
        page.waitForLoadState();

        Locator link = page.locator("//a[@id='simpleLink']");
        Page newPage = page.waitForPopup(() -> link.click());
        newPage.waitForLoadState();
    }

    @Test
    public void uploadFile() {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/upload-download");
        page.waitForLoadState();

        Locator fileInput = page.locator("//input[@id='uploadFile']");
        fileInput.setInputFiles(Paths.get("./Screenshots/ToolsQA.png"));
        pw.close();
    }

    @Test
    public void handlingPromptAlert()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/alerts");
        page.waitForLoadState();

        Locator promptAlert = page.locator("//button[@id='promtButton']");
        promptAlert.click();

        page.onDialog(dialog -> {
            String dialogType = dialog.type();
            System.out.println("Prompt Dialog Type : " + dialogType);
            String dialogMsg = dialog.message();
            System.out.println("Prompt Dialog Message : " + dialogMsg);
            dialog.accept("Amol Deokar");
        });
        pw.close();
    }

    @Test
    public void openNewBrowserTab()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/browser-windows");
        page.waitForLoadState();

        Locator newTab = page.locator("//button[@id='tabButton']");
        Page newPage = page.waitForPopup(()-> newTab.click());
        newPage.waitForLoadState();
        newPage.waitForTimeout(3000);
        newPage.close();
    }

    @Test
    public void handleSingleFrame()
    {
        Page page = Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)
                    .setChannel("chrome")).newPage();
        page.navigate("https://demo.automationtesting.in/Frames.html");
        page.waitForLoadState();

        Locator singleFrameTextBox = page.frameLocator("//iframe[@id='singleframe']")
                .locator("//input[@type='text']").first();
        singleFrameTextBox.fill("Amol Deokar");
        System.out.println("Frame element handled successfully");
        pw.close();
    }

    @Test
    public void handleNestedMultipleFrames()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demo.automationtesting.in/Frames.html");
        page.waitForLoadState();

        page.locator("//a[normalize-space()='Iframe with in an Iframe']").click();
        Locator multipleFramesTextBox = page.frameLocator("//iframe[@src='MultipleFrames.html']")
                .frameLocator("//iframe[@src='SingleFrame.html']").locator("//input[@type='text']").first();
        multipleFramesTextBox.fill("Amol Deokar");
        System.out.println("Nested Frames Text Box Handled successfully");
        page.close();

    }


    @Test
    public void handleSmallModal()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/modal-dialogs");
        page.waitForLoadState();

        Locator smallModal = page.locator("//button[@id='showSmallModal']");
        smallModal.click();
        page.waitForSelector("//div[@class='modal-content']");
        String modalText = page.locator("//div[@class='modal-body']").textContent();
        System.out.println("Small Modal Text : " + modalText);
        page.locator("#closeSmallModal").click();

    }

    @Test
    public void handleAccordionSection()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/accordian");
        page.waitForLoadState();

        Locator largeAccordion = page.locator("//div[@id='section1Heading']");
        largeAccordion.click();
        page.waitForSelector("//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]");
        String accordionText = page.locator("//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]").textContent();
        System.out.println("Large Accordion Text Is : " + accordionText);
        page.close();
    }

    @Test
    public void selectSingleColorAutoComplete()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/auto-complete");
        page.waitForLoadState();

        Locator inputBox = page.locator("//div[@id='autoCompleteSingleContainer']");
        //inputBox.click();
        inputBox.fill("red");
        page.locator("div.auto-complete-container").filter(new Locator.FilterOptions().setHasText("Red")).click();

    }

    // Set a simple date (MM/dd/yyyy)
    @Test
    public void setDate() {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/date-picker");
        page.waitForLoadState();

        String date = "06/15/2025";
        Locator dateInput = page.locator("#datePickerMonthYearInput");
        dateInput.click();
        dateInput.fill(date); // Format: MM/dd/yyyy
        dateInput.press("Enter");
        System.out.println("Date picker Date is set Correctly");
    }

    // Set a date and time (full format)
    @Test
    public void setDateAndTime() {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/date-picker");
        page.waitForLoadState();

        String fullDateTime = "July 10, 2025 3:45 PM";
        Locator dateTimeInput = page.locator("#dateAndTimePickerInput");
        dateTimeInput.click();
        dateTimeInput.fill(fullDateTime); // Format: MMMM d, yyyy h:mm a
        dateTimeInput.press("Enter");
        System.out.println("Date picker Date & Time is set Correctly");
    }

    @Test
    public void handlingProgressBar()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/progress-bar");
        page.waitForLoadState();

        page.locator("#startStopButton").click();
        page.waitForFunction("() => document.querySelector('#progressBar').textContent.trim() === '70%'");
        page.locator("#startStopButton").click();

        String progressVaue = page.locator("//div[@role='progressbar']").textContent().trim();
        System.out.println("Final Progress Value : " +progressVaue);
    }

    @Test
    public void handlingToolTips()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/tool-tips");
        page.waitForLoadState();

        Locator tooltip = page.locator("//button[@id='toolTipButton']");
        tooltip.hover();

        page.waitForSelector(".tooltip-inner");
        String tooltipText = page.locator(".tooltip-inner").textContent().trim();
        System.out.println("Tool Tip Content : " + tooltipText);

    }

    @Test
    public void selectOneDropDown()
    {
        Page page = bwContext.newPage();
        page.navigate("https://demoqa.com/select-menu");
        page.waitForLoadState();

        Locator selectOneDD = page.locator("#selectOne");
        selectOneDD.click();
        selectOneDD.selectOption(new SelectOption().setLabel("Dr."));
        System.out.println("Dropdown value is selected");

    }
}

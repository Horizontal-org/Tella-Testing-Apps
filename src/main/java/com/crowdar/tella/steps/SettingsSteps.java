package com.crowdar.tella.steps;

import com.crowdar.core.PropertyManager;
import com.crowdar.tella.services.HomeService;
import com.crowdar.tella.services.SettingsService;
import com.crowdar.tella.services.UnlockService;
import io.cucumber.java.en.*;

public class SettingsSteps {
    @Given("the user is in Tella home page")
    public void theUserIsInTellaHomePage() {
        UnlockService.isViewLoaded();
        UnlockService.setPassword(PropertyManager.getProperty("password"));
        UnlockService.goTella();
        HomeService.isHomeLoaded();
    }

    @Given("the user is in Tella home page and log in with pin (.*)")
    public void theUserIsInTellaHomePageAndLogInWithPin(String pin) {
        UnlockService.isViewLoaded();
        UnlockService.setNumbers(pin);
        UnlockService.goTella();
        HomeService.isHomeLoaded();
    }

    @And("the user close the app")
    public void theUserCloseTheApp() throws InterruptedException {
        UnlockService.reopenTheApp();
    }

    @When("the user taps the settings icon")
    public void theUserTapsTheSettingsIcon() {
        SettingsService.clickSettingsIcon();
    }
    @And("taps the general option")
    public void tapsTheGeneralOption() {
        SettingsService.clickGeneralIcon();
    }
    @And("taps the language option in the general category")
    public void tapsTheLanguageOption() {
        SettingsService.clickLanguageOptions();
    }
    @And("views the list with all available languages")
    public void viewsTheListWithAllAvailableLanguages() {
        SettingsService.verifyListOfLanguages();
    }
    @And("clicks on the language (.*)")
    public void clicksOnTheLanguage(String language) {
        SettingsService.clickChoosenLanguage(language);
    }
    @Then("views the title (.*) at the top of the page")
    public void viewsTheTitleAlTheTopOfThePage(String title) {
        SettingsService.verifyLanguageTitle(title);
    }

    @When("^clicks on the category (.*)$")
    public void clicksOnTheCategory(String category) {
        SettingsService.clickCategory(category);
    }
    @Then("the user access the category (.*)")
    public void theUserAccessTheCategory(String category) {
        SettingsService.accessCategory(category);
}
    @Then("the user should view a list with the general configurations of the app")
    public void theUserShouldViewAListWithTheGeneralConfigurationsOfTheApp() {
        SettingsService.viewListGeneralConfifuration();
    }
    @And("switch configuration (.*) to enable")
    public void switchConfigurationToEnable(String configuration) {
        SettingsService.switchButtonEnable(configuration);
    }
    @Then("the user sees that the color has changed to green, indicating it is activated (.*)")
    public void theUserSeesThatTheColorHasChangedToGreenIndicatingItIsActivated(String configuration) {
        SettingsService.viewButtonEnable(configuration);
    }
    @Then("view the Tella icon")
    public void viewTheIconTella() {
        SettingsService.viewTellaIcon();
    }
    @And("the number version (.*)")
    public void theNumberVersion(String version) {
        SettingsService.viewVersion(version);
    }
    @And("view a list options")
    public void viewAListOptions() {
        SettingsService.viewList();
    }

    @And("taps the (.*) option")
    public void tapsTheOption(String option) {
        SettingsService.tapTheOption(option);
    }

    @Then("the user is redirected to the (.*)")
    public void theUserIsRedirectedToThe(String site) {
        SettingsService.redirectedSite(site);
    }

    @When("^the user clicks the \"(.*)\" option$")
    public void theUserClicksTheOption(String option) {
        SettingsService.clicksOptions(option);
    }

    @And("^select timeout (.*) option$")
    public void selectTimeoutOption(String timeout) {
        SettingsService.SelectGeneralOption(timeout);
    }

    @And("^taps \"(.*)\" button$")
    public void tapsButton(String button) {
        SettingsService.clickButton(button);
    }

    @Then("^the option timeout (.*) is selected$")
    public void theOptionTimeoutIsSelected(String timeout) {
        SettingsService.selectedTimeout(timeout);
    }

    @And("select attempts (.*) option")
    public void selectAttemptsOption(String attempts) {
        SettingsService.SelectGeneralOption(attempts);
    }

    @And("the user set incorrect (.*) in (.*)")
    public void theUserSetIncorrectIn(String pin, String attempts) {
        SettingsService.setIncorrectPinWithAttempts(pin, attempts);    }


    @And("^select \"(.*)\" option$")
    public void selectOption(String option) {
        SettingsService.selectMethodCamuflage(option);
    }

    @And("select icon (.*) option")
    public void selectIconOption(String icon) {
        SettingsService.selectIcon(icon);
    }

    @Then("^the message \"(.*)\" is displayed$")
    public void theMessageIsDisplayed(String message) {
        SettingsService.showMessage(message);
    }

    @Then("^the (.*) option is changed to status (.*)$")
    public void theOptionIsChangedToStatus(String option, String status) {
        SettingsService.changeStatus(option, status);
    }
    @Then("^the sucessfull message (.*) is displayed$")
    public void theSucessfullMessageIsDisplayed(String message) {
        SettingsService.viewMessage(message);
    }
}

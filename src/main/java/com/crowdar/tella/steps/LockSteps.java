package com.crowdar.tella.steps;

import com.crowdar.tella.constants.UnlockConstants;
import com.crowdar.tella.services.UnlockService;
import com.crowdar.tella.services.LockService;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class LockSteps {

    @When("tap the next button until reaching the lock options")
    public void tapNextButton() {
        UnlockService.clickNextButtons(3);
    }
    @And("tap the password button")
    public void tapThePasswordButton() {
        LockService.clickPasswordButton();
    }
    @And("types a password (.*)")
    public void typesAPassword(String password) {
        LockService.setOnePassword(password);    }
    @And("tap the next button")
    public void tapTheNextButton() {
        LockService.clickNextPasswordButton();    }
    @Then("a message (.*) is displayed to the user")
    public void aMessageIsDisplayedToTheUser(String message) {
        LockService.messageDisplayed(message);
    }
    @Then("the next button remains disabled")
    public void theNextButtonRemainsDisabled() {
        LockService.verifyNextButtonEnabled(UnlockConstants.PASSWORD_RIGHT_BUTTON);
    }
    @And("tap the pin button")
    public void tapThePinButton() {
        LockService.clickPinButton();
    }
    @And("tap the next pin button")
    public void tapTheNextPinButton() {
        LockService.TapNextPinButton();
    }
    @And("types a pin (.*)")
    public void typesAPin(String pin){
        UnlockService.setPin(pin);
    }
    @Then("the next pin button remains disabled")
    public void theNextPinButtonRemainsDisabled() {
        LockService.verifyNextPinButtonEnabled(UnlockConstants.PIN_RIGHT_BUTTON);
    }
}
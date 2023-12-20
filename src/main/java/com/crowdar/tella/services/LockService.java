package com.crowdar.tella.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.tella.constants.UnlockConstants;
import org.testng.Assert;

public class LockService {

    public static String verifyPasswordAttributeEnabled;
    public static String verifyPinAttributeEnabled;

    public static void clickPasswordButton(){
        MobileActionManager.click(UnlockConstants.LOCK_PASSWORD_BUTTON);
    }

    public static void setOnePassword(String password){
        MobileActionManager.setInput(UnlockConstants.PASSWORD_INPUT,password);
    }

    public static void clickNextPasswordButton(){
        MobileActionManager.click(UnlockConstants.PASSWORD_RIGHT_BUTTON);
    }

    public static void messageDisplayed(String message){
        MobileActionManager.waitVisibility(UnlockConstants.LOCK_DONT_MATCH_MSG);
        Assert.assertTrue(MobileActionManager.isVisible(UnlockConstants.LOCK_DONT_MATCH_MSG));
        String errorMessagePage = MobileActionManager.getText(UnlockConstants.LOCK_DONT_MATCH_MSG);
        Assert.assertEquals(message, errorMessagePage);
    }

    public static void verifyNextButtonEnabled(String locator){
        verifyPasswordAttributeEnabled = MobileActionManager.getAttribute(locator, "clickable");
        Assert.assertEquals(verifyPasswordAttributeEnabled , "true");
    }
    public static void clickPinButton(){
        MobileActionManager.click(UnlockConstants.LOCK_PIN_BUTTON);
    }
    public static void TapNextPinButton(){
        MobileActionManager.click(UnlockConstants.PIN_RIGHT_BUTTON);
    }

    public static void verifyNextPinButtonEnabled(String locator){
        verifyPinAttributeEnabled = MobileActionManager.getAttribute(locator, "clickable");
        Assert.assertEquals(verifyPinAttributeEnabled , "true");
    }

}

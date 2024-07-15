package com.crowdar.tella.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.tella.constants.SettingsConstants;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;



public class SettingsService {

    public static void clickSettingsIcon() {
        MobileActionManager.waitVisibility(SettingsConstants.SETTINGS_ICON);
        MobileActionManager.click(SettingsConstants.SETTINGS_ICON);
    }

    public static void clickGeneralIcon() {
        MobileActionManager.waitVisibility(SettingsConstants.GENERAL_BUTTON);
        MobileActionManager.click(SettingsConstants.GENERAL_BUTTON);
    }

    public static void clickLanguageOptions() {
        MobileActionManager.waitVisibility(SettingsConstants.LANGUAGE_BUTTON);
        MobileActionManager.click(SettingsConstants.LANGUAGE_BUTTON);
    }

    public static void verifyListOfLanguages() {
        MobileActionManager.waitVisibility(SettingsConstants.LANGUAGE_LIST);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.LANGUAGE_LIST));
    }

    public static void clickChoosenLanguage(String language) {
        WebElement pedidoEle = DriverManager.getDriverInstance().getWrappedDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                        ".scrollIntoView(new UiSelector()" +
                        ".textMatches(\"" + language + "\").instance(0))"));
        pedidoEle.click();
    }

    public static void verifyLanguageTitle(String title) {
        MobileActionManager.waitVisibility(SettingsConstants.LANGUAGE_TITLE);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.LANGUAGE_TITLE));
        String LanguageTitle = MobileActionManager.getText(SettingsConstants.LANGUAGE_TITLE);
        Assert.assertEquals(LanguageTitle, title);

        MobileActionManager.click(SettingsConstants.BUTTON_BACK_LANG);
        MobileActionManager.waitVisibility(SettingsConstants.TITLE_LANGUAGE_SETTING);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.TITLE_LANGUAGE_SETTING));
    }

    public static void clickCategory(String category) {
        Map<String, String> links = new HashMap<>();
        links.put("General", SettingsConstants.GENERAL_BUTTON);
        links.put("Security", SettingsConstants.SECURITY_BUTTON);
        links.put("Servers", SettingsConstants.SERVERS_BUTTON);
        links.put("About & Help", SettingsConstants.ABOUT_HELP_BUTTON);
        links.put("Feedback", SettingsConstants.FEEDBACK_BUTTON);
        try {
            MobileActionManager.waitVisibility(links.get(category));
            MobileActionManager.click(links.get(category));
        } catch (Exception e) {
            MobileActionManager.click(links.get(category));
        }
    }

    public static void accessCategory(String category) {
        MobileActionManager.waitVisibility(SettingsConstants.CATEGORY_SETTINGS_TITLE);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.CATEGORY_SETTINGS_TITLE));
        String LanguageTitle = MobileActionManager.getText(SettingsConstants.CATEGORY_SETTINGS_TITLE);
        Assert.assertEquals(LanguageTitle, category);
    }

    public static void viewListGeneralConfifuration() {
        MobileActionManager.waitVisibility(SettingsConstants.LANGUAGE_SECTION);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.LANGUAGE_SECTION));
        MobileActionManager.waitVisibility(SettingsConstants.VERIFICATION_MODE);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.VERIFICATION_MODE));
        MobileActionManager.waitVisibility(SettingsConstants.FILES_SECTION);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.FILES_SECTION));
        MobileActionManager.waitVisibility(SettingsConstants.SECTION_TEXT);
        Assert.assertTrue(MobileActionManager.isVisible(SettingsConstants.SECTION_TEXT));
    }

    public static String viewButton(String configuration) {
        Map<String, String> buttons = new HashMap<>();
        buttons.put("Share crash reports", SettingsConstants.SWITCH_LIST_BUTTON + "[1]");
        buttons.put("Verification mode", SettingsConstants.SWITCH_LIST_BUTTON + "[2]");
        buttons.put("Recent files", SettingsConstants.SWITCH_LIST_BUTTON + "[3]");
        buttons.put("Favorite forms", SettingsConstants.SWITCH_LIST_BUTTON + "[4]");
        buttons.put("Favorite templates", SettingsConstants.SWITCH_LIST_BUTTON + "[5]");
        buttons.put("Test justification", SettingsConstants.SWITCH_LIST_BUTTON + "[6]");
        buttons.put("Increase text spacing", SettingsConstants.SWITCH_LIST_BUTTON + "[7]");
        return buttons.get(configuration);
    }

    public static void switchButtonEnable(String configuration) {
        String button = viewButton(configuration);
        MobileActionManager.waitVisibility(button);
        String check = MobileActionManager.getAttribute(button, "checked");
        if (Boolean.parseBoolean(check) != true) {
            MobileActionManager.click(button);
        }
    }

    public static void viewButtonEnable(String configuration) {
        String button = viewButton(configuration);
        MobileActionManager.waitVisibility(button);
        Assert.assertTrue(MobileActionManager.getAttribute(button, "checked").contains("true"));
    }
}

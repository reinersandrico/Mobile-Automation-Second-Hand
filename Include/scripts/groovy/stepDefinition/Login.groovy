package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import internal.GlobalVariable

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

import com.kms.katalon.core.util.KeywordUtil


public class Login {



	@Given("User already open aplication secondhand")
	public void user_already_open_aplication_secondhand() {
		Mobile.startApplication('APK/app-release.apk', true)
	}


	@Given("User already on home page")
	public void user_already_on_home_page() {
		Mobile.tap(findTestObject('home page/verify_telusuri_kategori'), 0)
	}

	@Given("User taps akun on the menu navigation")
	public void user_taps_akun_on_the_menu_nagivation() {
		Mobile.tap(findTestObject('home page/btn_akun'), 0)
	}

	@When("User taps login masuk button")
	public void user_taps_login_masuk_button() {
		Mobile.tap(findTestObject('account page/btn_masuk_account'), 0)
	}

	@When("User input email {string}")
	public void user_input_email(String email) {
		Mobile.setText(findTestObject('login page/input_email_login'), email, 0)
	}

	@When("User input password {string}")
	public void user_input_password(String password) {
		Mobile.setText(findTestObject('login page/input_password_login'), password, 0)
	}

	@When("User taps login button")
	public void user_taps_login_button() {
		Mobile.tap(findTestObject('login page/btn_masuk_login'), 0)
	}

	@Then("User successful login and redirected account page")
	public void user_successful_login_and_redirected_account_page() {
		Mobile.verifyElementVisible(findTestObject('account page/verify_akun_saya'), 0)
	}

	@When("User input email in the fields (.*)")
	public void user_input_email_in_the_fields(String email) {

		if (email =="valid email" || email == "valid") {
			Mobile.setText(findTestObject('login page/input_email_login'),'reiner.sandrico1@gmail.com', 0)
		} else if (email == "invalid") {
			Mobile.setText(findTestObject('login page/input_email_login'),'Reiner.sandrico1@gmail.com', 0)
		} else if (email == "empty") {
			Mobile.setText(findTestObject('login page/input_email_login'),'', 0)
		}else {
			Mobile.setText(findTestObject('login page/input_email_login'),email, 0)
		}
	}

	@When("User input password in the fields (.*)")
	public void user_input_password_in_the_fields(String password) {
		if (password == "valid") {
			Mobile.setText(findTestObject('login page/input_password_login'),'123456789', 0)
		}
		else if (password == "invalid") {
			Mobile.setText(findTestObject('login page/input_password_login'),'1234156789', 0)
		}
		else if (password == "empty") {
			Mobile.setText(findTestObject('login page/input_password_login'),'', 0)
		}
		else  {
			Mobile.setText(findTestObject('login page/input_password_login'),password, 0)
		}
	}


	@Then("User unsuccessfully login and get (.*)")
	public void user_unsuccessfully_login_and_get(String result) {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		if (result == "error message") {
			driver.findElementByXPath("//android.widget.Toast[@text='Email atau kata sandi salah']")
		}
		else {
			Mobile.verifyElementVisible(findTestObject('login page/verify_title_masuk2'), 0)
		}
	}
}

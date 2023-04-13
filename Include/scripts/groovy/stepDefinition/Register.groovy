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
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import internal.GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.util.KeywordUtil
import org.apache.commons.lang.RandomStringUtils



public class Register {
	AppiumDriver<?> driver = MobileDriverFactory.getDriver()



	@When("User taps the Daftar link under the Masuk button")
	public void user_taps_the_Daftar_link_under_the_Masuk_button() {
		Mobile.tap(findTestObject('login page/btn_register_account'), 0)
	}


	@When("User inputs complete name in the field nama")
	public void user_inputs_complete_name_in_the_name_field_nama() {
		Mobile.setText(findTestObject('register page/input_name_register'),RandomStringUtils.randomAlphanumeric(5) + " " + RandomStringUtils.randomAlphanumeric(5), 0)
	}

	@When("User inputs an email according to the email format in the field")
	public void user_inputs_an_email_according_to_the_email_format_in_the_field() {
		Mobile.setText(findTestObject('register page/input_email_register'), RandomStringUtils.randomAlphanumeric(10) + "@gmail.com", 0)
	}

	@When("User inputs Password in the field with six character")
	public void user_inputs_Password_in_the_field_with_six_character() {
		Mobile.setText(findTestObject('register page/input_password_register'), RandomStringUtils.randomAlphanumeric(6), 0)
	}


	@When("User inputs Phone Number on the field")
	public void user_inputs_Phone_Number_on_the_field() {
		Mobile.setText(findTestObject('register page/input_phone_number_register'),RandomStringUtils.randomNumeric(12), 0)
	}

	@When("User inputs City on the field kota")
	public void user_inputs_City_on_the_field_kota(){
		Mobile.setText(findTestObject('register page/input_city_register'), "Kota " + RandomStringUtils.randomAlphanumeric(10), 0)
	}

	@When("User inputs Address on the field alamat")
	public void user_inputs_Address_on_the_field_alamat() {
		Mobile.setText(findTestObject('register page/input_address_register'), "Alamat " + RandomStringUtils.randomAlphanumeric(15), 0)
	}

	@When("User taps Daftar button")
	public void user_taps_Daftar_button() {
		Mobile.scrollToText("Daftar")
		Mobile.tap(findTestObject('register page/btn_register'), 0)
	}

	@Then("User successfully registers")
	public void user_successfully_registers() {
		Mobile.verifyElementVisible(findTestObject('account page/verify_akun_saya'), 0)
		Mobile.closeApplication()
	}

	//start negative case

	@When("User inputs empty name in the field nama")
	public void user_inputs_empty_name_in_the_name_field_nama() {
		Mobile.setText(findTestObject('register page/input_name_register'),"", 0)
	}

	@When("User inputs the email field with (.*)")
	public void user_inputs_the_email_field_with(String email) {

		if (email =="invalid email") {
			Mobile.setText(findTestObject('register page/input_email_register'),'aziz.gmail.com', 0)
		} else if (email == "registered email") {
			Mobile.setText(findTestObject('register page/input_email_register'),'reiner.sandrico1@gmail.com', 0)
		}else {
			Mobile.setText(findTestObject('register page/input_email_register'), RandomStringUtils.randomAlphanumeric(10) + "@gmail.com", 0)
		}
	}

	@When("User inputs Password in the field with less then six character")
	public void user_inputs_the_password_in_the_field_with_less_then_six_character() {
		Mobile.setText(findTestObject('register page/input_password_register'), RandomStringUtils.randomAlphanumeric(4), 0)
	}

	@Then("User failed to register and should see warning information that (.*)")
	public void user_failed_to_register_and_should_see_warning_information_that(String warning) {
		//		def toast = driver.findElementByXPath("//android.widget.Toast[@text='Email sudah digunakan']")
		if (warning =="nama tidak boleh kosong") {
			Mobile.verifyElementVisible(findTestObject('register page/label_nama_kosong'), 0)
			Mobile.closeApplication()
		} else if (warning == "email tidak valid") {
			Mobile.verifyElementVisible(findTestObject('register page/label_invalid_email'), 0)
			Mobile.closeApplication()
		} else if (warning == "Email sudah digunakan") {
			driver.findElementByXPath("//android.widget.Toast[@text='Email sudah digunakan']")
			//Mobile.verifyElementVisible(findTestObject('toast'), 0)
			Mobile.closeApplication()
		}else {
			Mobile.verifyElementVisible(findTestObject('register page/label_password_kurang'), 0)
			Mobile.closeApplication()
		}
	}

}

package stepDefinition
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class detailproduct {
	@Given("User launch the app")
	public void user_launch_the_app() {
		Mobile.startApplication('APK/secondhand.apk', true)
	}

	@When("User tap one of product in the list product")
	public void user_tap_one_of_product_in_the_list_product() {
		Mobile.delay(25);
		Mobile.waitForElementPresent(findTestObject('home page/btn_pilih_product'), 0)
		Mobile.tap(findTestObject('home page/btn_pilih_product'), 0)
	}

	@And("User tap Saya Tertarik dan Ingin Nego button")
	public void user_tap_Saya_Tertarik_dan_Ingin_Nego_button() {
		Mobile.verifyElementExist(findTestObject('detail and bid page/detail_image_product'), 0)
		Mobile.tap(findTestObject('detail and bid page/btn_bid'), 0)
	}

	@And("User can see detail product page")
	public void user_can_see_detail_product_page() {
		Mobile.verifyElementExist(findTestObject('detail and bid page/detail_image_product'), 0)
		Mobile.verifyElementExist(findTestObject('detail and bid page/product_description'), 0)
	}

	@Then("User redirected to login page")
	public void user_redirected_to_login_page() {
		Mobile.verifyElementExist(findTestObject('login page/input_email_login'), 0)
		Mobile.verifyElementExist(findTestObject('login page/btn_masuk'), 0)
	}

	@And("User tap beranda button")
	public void user_tap_beranda_button() {
		Mobile.tap(findTestObject('home page/beranda'), 0)
	}
}
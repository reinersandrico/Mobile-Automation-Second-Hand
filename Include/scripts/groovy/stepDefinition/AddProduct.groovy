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

import ch.qos.logback.core.joran.conditional.ElseAction
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import groovy.json.StringEscapeUtils
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

public class AddProduct {

	@When("User click + button")
	public void user_click_add_button() {
		Mobile.tap(findTestObject('home page/btn_add-product'), 0)
	}

	@When("User input product name")
	public void user_input_product_name() {
		Mobile.setText(findTestObject('product page/add product page/field_nama-produk'),'H4RTA', 0)
	}

	@When("User input product price")
	public void user_input_product_price() {
		Mobile.setText(findTestObject('product page/add product page/field_harga-produk'),'1000', 0)
	}

	@When("User choose the category")
	public void user_choose_the_category() {
		Mobile.tap(findTestObject('product page/add product page/dropdown_kategori-produk'), 0)
		Mobile.tap(findTestObject('product page/add product page/option_kategori-elektronik'), 0)
	}

	@When("User input location")
	public void user_input_location() {
		Mobile.setText(findTestObject('product page/add product page/field_lokasi-produk'),'Rumah', 0)
	}

	@When("User input description")
	public void user_input_description() {
		Mobile.setText(findTestObject('product page/add product page/field_deskripsi-produk'), 'ased', 0)
	}

	@When("User browse and choose product photo")
	public void user_browse_and_choose_product_photo() {
		Mobile.tap(findTestObject('product page/add product page/btn_image-selection'), 0)
		Mobile.tap(findTestObject('product page/add product page/btn_galeri'), 0)
		Mobile.tap(findTestObject('product page/add product page/image_1st-image'), 0)
	}

	@When("User click Terbitkan button")
	public void user_click_Terbitkan_button() {
		Mobile.tap(findTestObject('product page/add product page/btn_terbitkan'), 0)
	}

	@When("User click masuk button")
	public void user_click_masuk_button() {
		Mobile.tap(findTestObject('product page/add product page/btn_masuk-add-product'), 0)
	}

	@Then("User Should be Redirected to Daftar Jual Saya page")
	public void user_Should_be_redirected_to_daftar_jual_saya_page() {
		Mobile.verifyElementVisible(findTestObject('product page/daftar jual saya page/text_Daftar Jual Saya'), 0)
	}

	@Then("User will be redirected to add product page for logging in")
	public void user_redirected_to_add_product_page_for_logging_in() {
		Mobile.verifyElementVisible(findTestObject('product page/add product page/btn_masuk-add-product'), 0)
	}

	@When("User input registration product field with empty(.*)")
	public void user_input_registration_product_field_with(String val) {
		if(val == "name") {
			// without name
			user_input_product_price()
			user_choose_the_category()
			user_input_location()
			user_input_description()
			user_browse_and_choose_product_photo()
			user_click_Terbitkan_button()
		}
		else if(val == "price") {
			// without price
			user_input_product_name()
			user_choose_the_category()
			user_input_location()
			user_input_description()
			user_browse_and_choose_product_photo()
			user_click_Terbitkan_button()
		} else {
			// without description
			user_input_product_name()
			user_input_product_price()
			user_choose_the_category()
			user_input_location()
			user_browse_and_choose_product_photo()
			user_click_Terbitkan_button()
		}
	}

	@Then("User should be able to see warning on (.*) field")
	public void user_should_be_able_to_see_warning_on_field(String val) {
		if(val == "name") {
			Mobile.verifyElementVisible(findTestObject('product page/add product page/warn-img_nama-produk'), 0)
			Mobile.verifyElementVisible(findTestObject('product page/add product page/warn-msg_nama-produk'), 0)
		}
		else if( val == "price") {
			Mobile.verifyElementVisible(findTestObject('product page/add product page/warn-img_harga'), 0)
			Mobile.verifyElementVisible(findTestObject('product page/add product page/warn-msg_harga'), 0)
		} else {
			Mobile.verifyElementVisible(findTestObject('product page/add product page/warn-img_deskripsi'), 0)
			Mobile.verifyElementVisible(findTestObject('product page/add product page/warn-msg_deskripsi'), 0)
		}
	}
}

package stepDefinition

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.eclipse.persistence.jpa.jpql.parser.ElseExpressionBNF

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
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration





public class EditProduct {
	@Given("User already in account page")
	public void user_already_in_account_page() {
		Mobile.verifyElementVisible(findTestObject('account page/verify_akun_saya'), 0)
	}

	@When("User taps list menu daftar jual saya")
	public void user_taps_list_menu_daftar_jual_saya() {
		Mobile.tap(findTestObject('account page/list_product_for_sale'), 0)
	}

	@When("User taps categories product")
	public void user_taps_categories_product() {
		Mobile.tap(findTestObject('edit product page/navmenu_product'), 0)
	}

	@When("User choose product want to edit and taps product")
	public void user_choose_product_want_to_edit_and_taps_product() {
		Mobile.delay(15)
		Mobile.tap(findTestObject('edit product page/product1'), 0)
	}

	@When("User choose product want to edit and taps product negative case")
	public void user_choose_product_want_to_edit_and_taps_product_negative_case() {
		Mobile.delay(10)
		Mobile.tap(findTestObject('edit product page/product1'), 0)
		Mobile.delay(5)
		Mobile.pressBack()
		Mobile.delay(5)
		Mobile.tap(findTestObject('edit product page/product1'), 0)
	}

	@When("User change product name {string}")
	public void user_change_product_name(String name) {
		Mobile.tap(findTestObject('edit product page/input_name_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_name'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.setText(findTestObject('edit product page/input_name_product'), name, 0)
	}

	@When("user change product price {string}")
	public void user_change_product_price(String price) {

		Mobile.tap(findTestObject('edit product page/input_price_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_price'), 0)
		Mobile.setText(findTestObject('edit product page/input_price_product1'), price, 0)
	}

	@When("User selects the new product category")
	public void user_selects_the_new_product_category() {

		Mobile.tap(findTestObject('edit product page/tap_menu_category'), 0)
		Mobile.tap(findTestObject('edit product page/category_elektronik'), 0)
	}

	@When("User changes the location of the product {string}")
	public void user_changes_the_location_of_the_product(String location) {
		Mobile.tap(findTestObject('edit product page/input_location_productid'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_location'), 0)
		Mobile.setText(findTestObject('edit product page/input_location_product'), location, 0)
	}

	@When("User change product description {string}")
	public void user_change_product_description_deskripsi(String description) {

		Mobile.tap(findTestObject('edit product page/input_description_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_description'), 0)
		Mobile.setText(findTestObject('edit product page/input_description_product'), description, 0)
		Mobile.pressBack()
	}

	@When("User choose new image product")
	public void user_choose_new_image_product() {

		Mobile.tap(findTestObject('edit product page/tap_image'), 0)
		Mobile.tap(findTestObject('edit product page/btn_galery'), 0)
		Mobile.tap(findTestObject('edit product page/image_product'), 0)
	}

	@When("User taps perbarui produk button")
	public void user_taps_perbarui_produk_button() {
		Mobile.tap(findTestObject('edit product page/btn_update_product'), 0)
	}

	@Then("User successfully update product and redirected to the product list page")
	public void user_successful_update_product_and_redirected_to_the_product_list_page() {
		Mobile.verifyElementVisible(findTestObject('edit product page/verify_daftar_jual'), 0)
	}

	@Then("User edit the product back to the initial value")
	public void user_edit_the_product_back_to_the_initial_value() {
		Mobile.delay(10)
		Mobile.pressBack()
		Mobile.tap(findTestObject('account page/list_product_for_sale'), 0)
		Mobile.delay(10)
		Mobile.tap(findTestObject('edit product page/product1'), 0)

		Mobile.tap(findTestObject('edit product page/input_name_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_name'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.setText(findTestObject('edit product page/input_name_product'), 'Ban Motor', 0)

		Mobile.tap(findTestObject('edit product page/input_price_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_price'), 0)
		Mobile.setText(findTestObject('edit product page/input_price_product1'), '200', 0)

		Mobile.tap(findTestObject('edit product page/delete_category_EL'), 0)

		Mobile.tap(findTestObject('edit product page/input_location_productid'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_location'), 0)
		Mobile.setText(findTestObject('edit product page/input_location_product'), 'Jambi', 0)

		Mobile.tap(findTestObject('edit product page/input_description_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_delete_description'), 0)
		Mobile.setText(findTestObject('edit product page/input_description_product'), 'produk belum di edit', 0)
		Mobile.pressBack()

		Mobile.tap(findTestObject('edit product page/tap_image'), 0)
		Mobile.tap(findTestObject('edit product page/btn_galery'), 0)
		Mobile.tap(findTestObject('edit product page/image_product'), 0)
		Mobile.tap(findTestObject('edit product page/btn_update_product'), 0)

		Mobile.verifyElementVisible(findTestObject('edit product page/verify_daftar_jual'), 0)
	}



	@When("User User delete (.*)")
	public void user_User_delete_empty_product_name(String data) {
		if (data=="empty product name") {
			Mobile.tap(findTestObject('edit product page/input_name_product'), 0)
			Mobile.tap(findTestObject('edit product page/btn_delete_name'), 0, FailureHandling.STOP_ON_FAILURE)
		} else if (data == "empty product price") {
			Mobile.tap(findTestObject('edit product page/input_price_product'), 0)
			Mobile.tap(findTestObject('edit product page/btn_delete_price'), 0)
		} else if (data == "empty product location") {
			Mobile.tap(findTestObject('edit product page/input_location_productid'), 0)
			Mobile.tap(findTestObject('edit product page/btn_delete_location'), 0)
		} else {
			Mobile.tap(findTestObject('edit product page/input_description_product'), 0)
			Mobile.tap(findTestObject('edit product page/btn_delete_description'), 0)
			Mobile.pressBack()
		}
	}


	@Then("User unsuccessfully update product and get toast message (.*)")
	public void user_unsuccessfully_update_product_and_get_toast_message(String message) {
		if (message == "product name can't be empty") {
			Mobile.verifyElementVisible(findTestObject('edit product page/verify_error_empty_name'), 0)
		} else if (message == "product price can't be empty") {
			Mobile.verifyElementVisible(findTestObject('edit product page/verify_error_empty_price'), 0)
		}
		else if (message == "product location can't be empty") {
			Mobile.verifyElementVisible(findTestObject('edit product page/verify_error_empty_location'), 0)
		} else {
			Mobile.verifyElementVisible(findTestObject('edit product page/verify_error_empty_description'), 0)
		}
	}

	@Then("User will not be directed to the product list page")
	public void user_will_not_be_directed_to_the_product_list_page() {
		Mobile.verifyElementVisible(findTestObject('edit product page/verify_title_ubah_product_page'), 0)
	}
}

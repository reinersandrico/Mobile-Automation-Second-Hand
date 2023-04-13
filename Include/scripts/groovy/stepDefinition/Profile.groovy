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
import internal.GlobalVariable

public class Profile {
	@When("User click profile icon")
	public void user_click_profile_icon() {
		Mobile.tap(findTestObject('edit profile page/btn_akun'), 0)
	}

	@When("User click edit profile")
	public void user_click_edit_profile() {
		Mobile.tap(findTestObject('edit profile page/btn_edit_profile'), 0)
	}

	@When("User click field name")
	public void user_click_field_name() {
		Mobile.tap(findTestObject('edit profile page/field_nama'), 0)
	}

	@When("User edit name")
	public void user_edit_name() {
		Mobile.setText(findTestObject('edit profile page/field_edit_nama'), 'Alya', 0)
	}

	@When("User clear name")
	public void user_clear_name() {
		Mobile.clearText(findTestObject('edit profile page/field_edit_nama'), 0)
	}

	@When("User click Submit button")
	public void user_click_Submit_button() {
		Mobile.tap(findTestObject('edit profile page/btn_Simpan'), 0)
	}

	@When("User click field number phone")
	public void user_click_field_number_phone() {
		Mobile.tap(findTestObject('edit profile page/field_nomorhp'), 0)
	}

	@When("User edit number phone")
	public void user_edit_number_phone() {
		Mobile.setText(findTestObject('edit profile page/field_edit_nomorhp'), '083572767263', 0)
	}

	@When("User click field city")
	public void user_click_field_city() {
		Mobile.tap(findTestObject('edit profile page/field_kota'), 0)
	}

	@When("User edit city")
	public void user_edit_city() {
		Mobile.setText(findTestObject('edit profile page/field_edit_kota'), 'Bandung', 0)
	}

	@When("User click field address")
	public void user_click_field_address() {
		Mobile.tap(findTestObject('edit profile page/field_alamat'), 0)
	}

	@When("User edit address")
	public void user_edit_address() {
		Mobile.setText(findTestObject('edit profile page/field_edit_alamat'), 'Jalan Suka Suka No. 86', 0)
	}

	@Then("User successfully edit profile")
	public void user_successfully_edit_profile() {
		Mobile.verifyElementExist(findTestObject('edit profile page/toast_message_Profil_berhasil_diperbarui'), 0)
	}

	@Then("User unsuccessfully edit profile")
	public void user_unsuccessfully_edit_profile() {
		Mobile.verifyElementExist(findTestObject('edit profile page/toast_message_Wajib_diisi'), 0)
	}
}


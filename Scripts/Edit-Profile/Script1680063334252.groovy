import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.tap(findTestObject('edit profile page/btn_akun'), 0)

Mobile.tap(findTestObject('edit profile page/btn_edit_profile'), 0)

Mobile.tap(findTestObject('edit profile page/field_nama'), 0)

Mobile.setText(findTestObject('edit profile page/field_edit_nama'), 'Alya', 0)

Mobile.scrollToText('', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('edit profile page/btn_Simpan'), 0)

Mobile.tap(findTestObject('edit profile page/field_nomorhp'), 0)

Mobile.setText(findTestObject('edit profile page/field_edit_nomorhp'), '', 0)

Mobile.setText(findTestObject('edit profile page/field_edit_kota'), '', 0)

Mobile.setText(findTestObject('edit profile page/field_edit_alamat'), '', 0)

Mobile.tap(findTestObject('edit profile page/field_kota'), 0)

Mobile.verifyElementVisible(findTestObject('edit profile page/toast_message_Profil_berhasil_diperbarui'), 0)

Mobile.clearText(findTestObject('edit profile page/field_edit_nama'), 0)

Mobile.verifyElementExist(findTestObject('edit profile page/toast_message_Wajib_diisi'), 0)

Mobile.closeApplication()


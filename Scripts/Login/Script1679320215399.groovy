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

Mobile.startApplication('APK/app-release.apk', true)

Mobile.tap(findTestObject('home page/btn_akun'), 0)

Mobile.waitForElementNotPresent(findTestObject('detail product page/verify_detail_product'), 0)

Mobile.setText(findTestObject('login page/input_email_login'), 'reiner.sandrico1@gmail.com', 0)

Mobile.setText(findTestObject('null'), 'Iphone', 0)

Mobile.tap(findTestObject('login page/btn_masuk_login'), 0)

Mobile.verifyElementVisible(findTestObject(null), 0)

Mobile.clearText(findTestObject(null), 0)

WebUI.waitForElementPresent(findTestObject(null), 0)

WebUI.waitForElementVisible(findTestObject(null), 0)

Mobile.swipe(0, 0, 0, 0)


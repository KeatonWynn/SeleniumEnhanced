from selenium import webdriver
import getpass
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import *
import time
from pandas import read_excel
import pandas as pd
from selenium.webdriver.chrome.options import Options


class SeleniumEnhanced:

    def __init__(self):

        self.userHMF = getpass.getuser()
        self.download_dir = "C:/Users/" + self.userHMF + "/Downloads"
        self.options = Options()  # add options to skip "Save as" prompts and set save directory
        self.options.add_experimental_option("prefs", {
            "download.default_directory": self.download_dir,
            "download.prompt_for_download": False,
            "download.directory_upgrade": True,
            "safebrowsing.enabled": True
        })
        # error when runnning in command prompt, will fix later
        #self.driver = webdriver.Chrome("C:/Users/" + getpass.getuser() + "/Python_Files/chromedriver.exe",
         #                              options=self.options)

        # delete next line when above line is fixed
        self.driver = webdriver.Chrome("C:/Users/" + getpass.getuser() + "/ImportFiles/chromedriver.exe")
        self.driver.maximize_window()
        self.i = 0
        self.MaxTries = 20
        self.SecondsToWait = 2
        self.FatalError = False
        self.ExitOnError = True
        self.ShowMessages = True

    # doesn't work correctly, will figure out later
    def show_messages(self, TrueOrFalse):
        self.ShowMessages = bool(TrueOrFalse)

    def click(self, xpath, catchoutput):
        self.i = 0
        while self.i <= (self.MaxTries-1):
            try:
                self.driver.find_element_by_xpath(xpath).click()
                self.driver.implicitly_wait(10)
                self.i = self.MaxTries
            except Exception:
                if self.ShowMessages:
                    print(catchoutput + ": try " + str(self.i + 1) + " out of " + str(self.MaxTries))
                self.i += 1
                time.sleep(self.SecondsToWait)
                if self.i == self.MaxTries:
                    self.FatalError = True
                    if self.ExitOnError:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getText")
                        self.driver.close()
                        self.driver.quit()
                        #exit()
                    else:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getText")

    def sendKeys(self, xpath, catchoutput, keystosend):
        self.i = 0
        while self.i <= (self.MaxTries-1):
            try:
                self.driver.find_element_by_xpath(str(xpath)).send_keys(str(keystosend))
                self.driver.implicitly_wait(10)
                self.i = self.MaxTries
            except Exception:
                if self.ShowMessages:
                    print(catchoutput + ": try " + str(self.i + 1) + " out of " + str(self.MaxTries))
                self.i += 1
                time.sleep(self.SecondsToWait)
                if self.i == (self.MaxTries):
                    self.FatalError = True
                    if self.ExitOnError:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:sendKeys")
                        self.driver.close()
                        self.driver.quit()
                        #exit()
                    else:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:sendKeys")

    def clear(self, xpath, catchoutput):
        self.i = 0
        while self.i <= (self.MaxTries-1):
            try:
                self.driver.find_element_by_xpath(xpath).clear()
                self.driver.implicitly_wait(10)
                self.i = self.MaxTries
            except Exception:
                if self.ShowMessages:
                    print(catchoutput + ": try " + str(self.i + 1) + " out of " + str(self.MaxTries))
                self.i += 1
                time.sleep(self.SecondsToWait)
                if self.i == self.MaxTries:
                    self.FatalError = True
                    if self.ExitOnError:
                        print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:clear")
                        self.driver.close()
                        self.driver.quit()
                        #exit()
                    else:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:clear")

    def getText(self, xpath, catchoutput):
        self.i = 0
        txt = None
        while self.i <= (self.MaxTries-1):
            try:
                txt = self.driver.find_element_by_xpath(xpath).text
                self.driver.implicitly_wait(10)
                self.i = self.MaxTries
            except Exception:
                if self.ShowMessages:
                    print(catchoutput + ": try " + str(self.i + 1) + " out of " + str(self.MaxTries))
                self.i += 1
                time.sleep(self.SecondsToWait)
                if self.i == self.MaxTries:
                    self.FatalError = True
                    if self.ExitOnError:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getText")
                        self.driver.close()
                        self.driver.quit()
                        #exit()
                    else:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getText")
        return txt

    def getValue(self, xpath, catchoutput):
        self.i = 0
        txt = None
        while self.i <= (self.MaxTries-1):
            try:
                txt = self.driver.find_element_by_xpath(xpath).get_attribute("value")
                self.driver.implicitly_wait(10)
                self.i = self.MaxTries
            except Exception:
                if self.ShowMessages:
                    print(catchoutput + ": try " + str(self.i + 1) + " out of " + str(self.MaxTries))
                self.i += 1
                time.sleep(self.SecondsToWait)
                if self.i == self.MaxTries:
                    self.FatalError = True
                    if self.ExitOnError:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getValue")
                        self.driver.close()
                        self.driver.quit()
                        #exit()
                    else:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getValue")
        return txt

    # will work on later, trying to compress all functions into one method/function
    def getFunction(self, fuction, xpath, catchoutput):
        self.i = 0
        txt = None
        while self.i <= (self.MaxTries-1):
            try:
                txt = self.driver.find_element_by_xpath(xpath).text
                self.driver.implicitly_wait(10)
                self.i = self.MaxTries
            except Exception:
                if self.ShowMessages:
                    print(catchoutput + ": try " + str(self.i + 1) + " out of " + str(self.MaxTries))
                self.i += 1
                time.sleep(self.SecondsToWait)
                if self.i == self.MaxTries:
                    self.FatalError = True
                    if self.ExitOnError:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getText")
                        self.driver.close()
                        self.driver.quit()
                        #exit()
                    else:
                        if self.ShowMessages:
                            print("STOPPING PROCESS - FATAL ERROR: " + catchoutput + " | " + "Action:getText")
        return txt


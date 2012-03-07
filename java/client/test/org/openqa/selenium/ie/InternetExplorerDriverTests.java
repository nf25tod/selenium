/*
Copyright 2007-2010 WebDriver committers
Copyright 2007-2010 Google Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package org.openqa.selenium.ie;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.internal.runners.SuiteMethod;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.EmptyTest;
import org.openqa.selenium.StandardSeleniumTests;
import org.openqa.selenium.TestSuiteBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.openqa.selenium.Platform.WINDOWS;
import static org.openqa.selenium.testing.drivers.Browser.ie;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    StandardSeleniumTests.class,
    InternetExplorerDriverTest.class
})
public class InternetExplorerDriverTests extends TestSuite {
  public static class TestInternetExplorerDriver extends InternetExplorerDriver {
    public TestInternetExplorerDriver() {
      this(buildDesiredCapabilities());
    }

    public TestInternetExplorerDriver(Capabilities extraCapabilities) {
      super(buildDesiredCapabilities().merge(extraCapabilities));
    }

    private static DesiredCapabilities buildDesiredCapabilities() {
      DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
      caps.setCapability(INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
      return caps;
    }
  }
}

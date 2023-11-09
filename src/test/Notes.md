# Notes

### Gradle Configuration
* Add Suites Xml files to build.gradle
  
        `test {
            useTestNG() {         
                // suites "src/test/resources/TestNG.xml"
                suites "src/test/resources/Smoke.xml"
            }
          }`
* Using Terminal Run Clean Test
  * Command is **_gradle clean test_** **_(~~Without %~~)_**
    
    ` gradle clean test` _**This will generate a test report.**_
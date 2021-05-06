# qc-project

assign to Vương & Nhựt for integration testing (Rest Assured Framework).

# Setup apache mvn

https://maven.apache.org/install.html

# Setup allure reporting

1. Setup scoop at link http://scoop.sh/
2. Run script: scoop install allure

# Script to execute

mvn test -DsuiteXmlFile=src\test\java\TestSuite\testNG.xml

# Script to generate allure report

allure serve target/allure-results

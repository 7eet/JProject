### How to run application and test coverage report

- **Execute**   `gradle build` 

- **Then**  `./gradlew run --args=specifyDir operation`

 **operations :**
 1) **d  -> to delete files**
 2) **m  -> move to another directory**
 3) **f  -> create report in normal text file.**
 4) **csv  -> create report in .csv format.**

- **to execute test coverage report**

- **run**  `gradle test jacocoTestReport`

**then check**   */build/jacocoHtml/index.html*	

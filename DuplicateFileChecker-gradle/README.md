### What is DuplicateFileChecker

  - **It checks duplicate files ( text files, images, etc.) in a specified directory.**

  - **It can delete and move those duplicate files.**

  - **It generates report in normal text file and comma-separated value (.csv) file.**


### How to run application and test coverage report

 - **Execute**
  `gradle build` 

 - **Then**
 `./gradlew run --args=specifyDir operation`
 

  - *specifyDir -> you have to specify directory in which you want to check duplicate files*
  - *operations :*
    1) *d  -> to delete files*
    2) *m  -> move to another directory*
    3) *f  -> create report in normal text file.*
    4) *csv  -> create report in .csv format.*

 - **For test coverage report**

 - **run** 
`gradle test jacocoTestReport`

**then check**  */build/jacocoHtml/index.html*  **file.**	

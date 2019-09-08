echo "Enter Full Path of Directory: "
read dirName
echo "Below are the operations to perform on duplicate files:"
echo " m -> move duplicate files to another directory
 d -> delete duplicate files
 f -> creates report of duplicate files in a normal text file
 csv -> creates .csv file which you can open in excel"

echo "Enter Operations to perform:(m,d,f,csv)  "
read performOperation

echo "Application started"
java --module-path lib -m com.dupcheck/com.dupcheck.Main $dirName $performOperation


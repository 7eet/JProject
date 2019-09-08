pkgDir=com/dupcheck

strategyVar=com.dupcheck.strategy
echo "Started."
javac -d target/$strategyVar/ src/$strategyVar/module-info.java src/$strategyVar/$pkgDir/strategy/*.java
echo "interface compiled."

sigVar=com.dupcheck.signature
javac -d target/$sigVar/ src/$sigVar/module-info.java src/$sigVar/$pkgDir/signature/FileSignature.java
echo "com.dupcheck.signature compiled."

listVar=com.dupcheck.list
javac --module-path target/ -d target/$listVar/ src/$listVar/module-info.java src/$listVar/$pkgDir/list/GetList.java
echo "com.dupcheck.list compiled."

javac --module-path target/ -d target/com.dupcheck/ src/com.dupcheck/module-info.java src/com.dupcheck/$pkgDir/Main.java
echo "main file compiled."

#echo "Running Program."
#java --module-path target -m com.dupcheck/com.dupcheck.Main

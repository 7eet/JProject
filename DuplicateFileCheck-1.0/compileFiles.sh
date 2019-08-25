
echo "Started."
javac -d target/com.dupcheck.stategy/ src/com.dupcheck.strategy/module-info.java src/com.dupcheck.strategy/com/dupcheck/strategy/FeatureStrategy.java
javac -d target/com.dupcheck.stategy/ src/com.dupcheck.strategy/module-info.java src/com.dupcheck.strategy/com/dupcheck/strategy/MoveFileStrategy.java
javac -d target/com.dupcheck.stategy/ src/com.dupcheck.strategy/module-info.java src/com.dupcheck.strategy/com/dupcheck/strategy/DeleteFileStrategy.java
javac -d target/com.dupcheck.stategy/ src/com.dupcheck.strategy/module-info.java src/com.dupcheck.strategy/com/dupcheck/strategy/CSVFileStrategy.java
javac -d target/com.dupcheck.stategy/ src/com.dupcheck.strategy/module-info.java src/com.dupcheck.strategy/com/dupcheck/strategy/ReportFileStrategy.java
echo "interface compiled."
javac -d target/com.dupcheck.signature/ src/com.dupcheck.signature/module-info.java src/com.dupcheck.signature/com/dupcheck/signature/FileSignature.java
echo "com.dupcheck.signature compiled."
javac --module-path target/ -d target/com.dupcheck.list/ src/com.dupcheck.list/module-info.java src/com.dupcheck.list/com/dupcheck/list/GetList.java
echo "com.dupcheck.list compiled."
javac --module-path target/ -d target/com.dupcheck/ src/com.dupcheck/module-info.java src/com.dupcheck/com/dupcheck/Main.java
echo "main file compiled."

#echo "Running Program."
#java --module-path target -m com.dupcheck/com.dupcheck.Main

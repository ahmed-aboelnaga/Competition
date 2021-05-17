all: src/sport/*.java src/util/*.java test/sport/*.java 
	mkdir classes
	mkdir doc
	javac -d "classes" -cp classes src/util/*.java
	javac -d "classes" -cp classes src/sport/*.java
	javac -d "classes" -cp classes:test-1.7.jar test/sport/*.java
	javadoc -d "doc" src/sport/*.java
define jarfile =
cd classes
jar cvf ../sport.jar sport util
jar cvfm ../sport.jar ../manifest-ex sport util
endef
jar : ; $(value jarfile)
.ONESHELL:
run:sport.jar
	java -jar sport.jar
clean :
	rm -r doc classes sport.jar



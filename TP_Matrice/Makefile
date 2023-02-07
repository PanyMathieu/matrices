# Quick and dirty java makefile

all: compile bundle cleanBuild

compile:
	javac *.java

bundle:
	jar cvfm matrice.jar META-INF/MANIFEST.MF *.class

cleanBuild:
	rm *.class

clean: cleanBuild
	rm *.jar

run:
	java -jar matrice.jar

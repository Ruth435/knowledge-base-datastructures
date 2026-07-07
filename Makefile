default:
	javac src/Facts.java src/FactsArray.java src/BinaryTreeNode.java src/FactsBST.java src/GenericsKbArrayApp.java src/GenericsKbBSTApp.java -d bin/

javadoc:
	javadoc src/Facts.java src/FactsArray.java src/BinaryTreeNode.java src/FactsBST.java src/GenericsKbArrayApp.java src/GenericsKbBSTApp.java -d doc/

run:
	java -cp bin/ GenericsKbArrayApp

runBST:
	java -cp bin/ GenericsKbBSTApp

runArray: 
	java -cp bin/ GenericsKbArrayApp

clean:
	rm -f bin/*.class
# shellcheck disable=SC2046
javac -cp json-simple-1.1.jar $(find . -name "*.java")
java -cp .:json-simple-1.1.jar src.app.main.Main
# shellcheck disable=SC2046
javac -cp "target/json-simple-1.1.jar" $(find . -name "*.java") && java src.app.main.Main
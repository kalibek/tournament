set -e

URL=https://repo1.maven.org/maven2/org/openapitools/openapi-generator-cli/4.3.1/openapi-generator-cli-4.3.1.jar
GEN=openapi-generator-cli.jar

if [ ! -f "GEN" ]; then
    echo "$GEN does not exist. Downloading ..."
    curl -o ${GEN} -generator-cli.jar ${URL}
fi

java -jar ${GEN} generate -i api.spec.yaml -g spring -o gen

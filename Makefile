all: clean gradlew build

build: build-java

test:
	./gradlew test

idea:
	./gradlew idea
	idea . &

run:
	./gradlew clean build bootRun

build-java:
	./gradlew clean build

gradlew:
	gradle wrapper --gradle-version 7.5.1 --distribution-type all

clean:
	./gradlew clean
	rm -fR build out

docker-test-image:
	docker build -t "othona-form:latest" .

docker-test-run:
	docker run -p 4080:4080 -d othona-form:latest

package:
	./gradlew build bootJar

publish-docker:
	docker build . --tag othona-form:latest

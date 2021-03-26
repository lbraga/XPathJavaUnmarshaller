# XPathJavaUnmarshaller

Running unmarshaller

```
$ ./gradlew cmdLineJavaExec -Pargs="-x /tmp/full.xml -g /tmp/generated -p my-package -c MyClasses"
```

or

```
$ ./gradlew jar
$ java -jar ./build/libs/XPathJavaUnmarshaller-1.0-SNAPSHOT.jar -x /tmp/full.xml -g /tmp/generated -p my-package -c MyClasses
```



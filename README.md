# XPathJavaUnmarshaller

Generate Java classes from xml files

```
Usage: 
 -c,--classPrefix <arg>   java class name prefix
 -g,--generated <arg>     generated files directory
 -l,--camel               convert element name to camel case
 -p,--package <arg>       java package
 -t,--template <arg>      java class velocity template
 -x,--xml <arg>           xml archive
```

Running unmarshaller

```
$ ./gradlew cmdLineJavaExec -Pargs="-x /tmp/full.xml -g /tmp/generated -p my-package -c MyClasses"
```

or

```
$ ./gradlew jar
$ java -jar ./build/libs/XPathJavaUnmarshaller-1.0-SNAPSHOT.jar -x /tmp/full.xml -g /tmp/generated -p my-package -c MyClasses
```



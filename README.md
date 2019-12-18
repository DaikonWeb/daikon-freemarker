# Daikon Freemarker

![Daikon](./logo.svg)

Daikon Freemarker is a library that add to Daikon the ability to render Freemarker templates in the response.
The main goals are:
* Help in rendering a text or HTML in the response
* Make integration with Freemarker very simple and easy

## How to add Daikon Freemarker to your project
[![](https://jitpack.io/v/DaikonWeb/daikon-freemarker.svg)](https://jitpack.io/#DaikonWeb/daikon-freemarker)

### Gradle
- Add JitPack in your root build.gradle at the end of repositories:
```
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```
- Add the dependency
```
implementation 'com.github.DaikonWeb:daikon-freemarker:0.6.1'
```

### Maven
- Add the JitPack repository to your build file 
```
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
- Add the dependency
```
<dependency>
    <groupId>com.github.DaikonWeb</groupId>
    <artifactId>daikon-freemarker</artifactId>
    <version>0.6.1</version>
</dependency>
```

## How to use
```
HttpServer()
    .get("/") { _, res -> res.html("hello_to", hashMapOf("name" to "Bob")) }
    .start().use {
        val response = get("http://localhost:4545/")
        assertThat(response.headers["Content-Type"]).isEqualTo(TEXT_HTML_UTF_8.asString())
        assertThat(response.text).isEqualTo("hello Bob")
    }
```

## Resources
* Documentation: https://daikonweb.github.io
* Examples: https://github.com/DaikonWeb/daikon-examples

## Authors

* **[Marco Fracassi](https://github.com/fracassi-marco)**

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details
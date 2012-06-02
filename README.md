scala-rainbow
=============

Super simple terminal output colorizing for Scala

Download
--------

It's published to sonatype and synced with Maven Central, so all you need to do is:

for sbt:

```scala
val scalaRainbow = "pl.project13.scala" %% "rainbow" % "0.1"

libraryDependencies += scalaRainbow
```

for maven:

```xml
<dependency>
  <groupId>pl.project13.scala</groupId>
  <artifactId>rainbow</rainbow>
  <version>0.1</version>
</dependency>
```

Usage
------
Using rainbow is as simple as it gets:

```scala
import Rainbow._

println { "Warning, critical error!".red }
```

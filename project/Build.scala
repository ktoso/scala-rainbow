import sbt._
import sbt.Keys._

object Resolvers {
  val smsserResolvers = Seq(
    "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
    "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases"
  )
}

object Versions {
  val scalatest = "1.7.RC1"
}

object Dependencies {
  import Resolvers._
  import Versions._

  val scalaTest               = "org.scalatest"              % ("scalatest_" + "2.10.0-M3") % "1.8-SNAPSHOT" % "test" from "https://oss.sonatype.org/content/groups/public/org/scalatest/scalatest_2.10.0-M3/1.8-SNAPSHOT/scalatest_2.10.0-M3-1.8-SNAPSHOT.jar"

}

object BuildSettings {
  import Resolvers._
  import Dependencies._

  val dependencies  = Seq(scalaTest)

  val buildSettings = Defaults.defaultSettings ++
    Seq(
      organization := "pl.project13.scala",
      name         := "rainbow",
      version      := "0.2",
      scalaVersion := "2.10.0-M3",
      crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0-M3"),
      libraryDependencies ++= dependencies
    )

val sonatypeSettings = Seq(
  publishMavenStyle := true,
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  publishTo <<= version { (v: String) =>
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) 
      Some("snapshots" at nexus + "content/repositories/snapshots") 
    else 
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  credentials += Credentials(Path.userHome / ".sbt" / "sonatype.properties"),
  pomExtra := (
  <url>https://github.com/ktoso/scala-rainbow</url>
  <licenses>
    <license>
      <name>BSD-style</name>
      <url>http://www.opensource.org/licenses/bsd-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:ktoso/scala-rainbow.git</url>
    <connection>scm:git:git@github.com:ktoso/scala-rainbow.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ktoso</id>
      <name>Konrad 'ktoso' Malawski</name>
      <url>http://blog.project13.pl</url>
    </developer>
  </developers>
  <parent>
    <groupId>org.sonatype.oss</groupId>
    <artifactId>oss-parent</artifactId>
    <version>7</version>
  </parent>)
  )
}

object RainbowBuild extends Build {
  import Dependencies._
  import BuildSettings._

  lazy val root = Project (
    "rainbow",
    file("."),
    settings = buildSettings ++ sonatypeSettings ++
      Seq (
      )
  )
}

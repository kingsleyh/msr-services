name := "msr-spray"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "spray repo" at "http://repo.spray.io"

libraryDependencies ++= Seq("org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23")

libraryDependencies += "io.spray" % "spray-routing" % "1.3.1"

libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.3.1" % "test")

libraryDependencies += ("io.spray" % "spray-testkit" % "1.3.1" % "test").exclude("com.typesafe.akka","*")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")


// MAC WIRE DEPENDENCIES

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.softwaremill.macwire" %% "macros" % "1.0.2-SNAPSHOT"

libraryDependencies += "com.softwaremill.macwire" %% "runtime" % "1.0.2-SNAPSHOT"
    
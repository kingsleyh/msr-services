name := "msr-spray"

version := "1.0"

scalaVersion := "2.11.6"

resolvers ++=Seq (
  "spray repo" at "http://repo.spray.io"
 , "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
 , "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "reactivemongo" % "0.10.5.0.akka23"
  , "io.spray" % "spray-routing" % "1.3.1"
  , "org.specs2" %% "specs2-core" % "3.3.1" % "test"
  , ("io.spray" % "spray-testkit" % "1.3.1" % "test").exclude("com.typesafe.akka","*")
  , "com.softwaremill.macwire" %% "macros" % "1.0.2-SNAPSHOT"
  , "com.softwaremill.macwire" %% "runtime" % "1.0.2-SNAPSHOT"
)


scalacOptions in Test ++= Seq("-Yrangepos")




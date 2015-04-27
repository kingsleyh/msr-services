name := "msr-spray"

version := "1.0"

scalaVersion := "2.10.3"

val akka = "2.2.3"
val spray = "1.2.0"



scalacOptions in Test ++= Seq("-Yrangepos")

scalacOptions := Seq("-feature", "-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io"
  , "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
  , "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++=
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime" ::
    "com.typesafe.akka" %% "akka-actor" % akka ::
    "com.typesafe.akka" %% "akka-slf4j" % akka ::
    "com.typesafe.akka" %% "akka-testkit" % akka % "test" ::
    "io.spray" % "spray-caching" % spray ::
    "io.spray" % "spray-can" % spray ::
    "io.spray" % "spray-routing" % spray ::
    "io.spray" % "spray-testkit" % spray % "test" ::
    "io.spray" %% "spray-json" % "1.2.5" ::
    "org.scalatest" %% "scalatest" % "2.0" % "test" ::
    Nil

seq(Revolver.settings: _*)






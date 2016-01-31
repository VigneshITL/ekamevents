name := "ekamevents-app"

version := "1.0"

lazy val `ekamevents-app` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "uk.co.panaxiom" %% "play-jongo" % "0.9.0-jongo1.2",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.4.1" % "optional",
  "org.easytesting" % "fest-assert" % "1.4" % Test,
  "junit" % "junit" % "4.11" % Test,
  cache,
  javaWs )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

net.virtualvoid.sbt.graph.Plugin.graphSettings

javaOptions in test += "-ea"

findbugsSettings

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-encoding", "UTF-8")

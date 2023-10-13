ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "untitled"
  )
libraryDependencies += "com.criteo" % "criteo-api-marketingsolutions-sdk" % "2023.07.0.230831"
libraryDependencies ++= Seq(
  "com.criteo" % "criteo-api-marketingsolutions-sdk" % "2023.07.0.230831",
  "io.circe" %% "circe-core" % "0.14.5",
  "io.circe" %% "circe-generic" % "0.14.5",
  "io.circe" %% "circe-parser" % "0.14.5",
  "org.apache.commons" % "commons-csv" % "1.8",
  "org.scala-lang.modules" %% "scala-async" % "1.0.0",
  "com.typesafe.play" %% "play-json" % "2.9.2"

)

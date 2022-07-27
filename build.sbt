name := "prs-json-countries"

version := "0.1"

scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "prs-json-countries"
  )

val circeVersion = "0.14.2"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion
)
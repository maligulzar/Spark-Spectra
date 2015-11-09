name := "Idea"

version := "1.0"

scalaVersion := "2.10.4"

coverageEnabled := true

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.apache.spark" %% "spark-core" % "1.5.1" % "provided"

coverageExcludedFiles := "org.apache.*;"

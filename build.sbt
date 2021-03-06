name := "Idea"

version := "1.0"

scalaVersion := "2.10.4"

coverageEnabled := true

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.scoverage" %% "scalac-scoverage-runtime" % "0.14-SNAPSHOT"

coverageExcludedFiles := "org.apache.*;"

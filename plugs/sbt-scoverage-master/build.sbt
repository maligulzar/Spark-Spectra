name := "sbt-scoverage"

organization := "org.scoverage"

version := "0.16-SNAPSHOT"

sbtPlugin := true

scalaVersion := "2.10.4"

sbtVersion := "0.13.5"

scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8")

resolvers ++= {
  if (isSnapshot.value) Seq(Resolver.mavenLocal, Resolver.sonatypeRepo("snapshots"))
  else Seq.empty
}

libraryDependencies += "org.scoverage" %% "scalac-scoverage-plugin" % "0.14-SNAPSHOT"

publishMavenStyle := true

publishArtifact in Test := false

ScriptedPlugin.scriptedSettings

scriptedLaunchOpts ++= Seq(
  "-Xmx1024M", "-XX:MaxPermSize=256M",
  "-Dplugin.version=" + version.value
)

releaseSettings

publishTo <<= version {
  (v: String) =>
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
  <url>https://github.com/scoverage/sbt-scoverage</url>
    <licenses>
      <license>
        <name>Apache 2</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:scoverage/sbt-scoverage.git</url>
      <connection>scm:git@github.com:scoverage/sbt-scoverage.git</connection>
    </scm>
    <developers>
      <developer>
        <id>sksamuel</id>
        <name>sksamuel</name>
        <url>http://github.com/sksamuel</url>
      </developer>
    </developers>
}

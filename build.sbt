name := "github_etl"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
   "org.scalikejdbc" %% "scalikejdbc"         % "2.3.4",
   "ch.qos.logback"  %  "logback-classic"     % "1.1.3",
   "mysql"           % "mysql-connector-java" % "5.1.38",
   "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
   "net.liftweb"     % "lift-json_2.11"       % "2.6.2",
   "com.github.nscala-time" %% "nscala-time" % "2.6.0",
   "org.scalatest" %% "scalatest" % "2.2.6" % "test"
)


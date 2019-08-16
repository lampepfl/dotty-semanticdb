
val dottyVersion = "0.17.0-bin-20190711-e2130b9-NIGHTLY" // dottyLatestNightlyBuild.get

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-semanticdb",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    unmanagedSourceDirectories in Test += baseDirectory.value / "input" / "src" / "main" / "scala",
    scalacOptions in Test ++= Seq("-Yno-inline"),
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.scalameta" %% "semanticdb-scalac-core" % "4.2.1" cross CrossVersion.constant("2.13.0"),
      "com.novocode" % "junit-interface" % "0.11",
      "com.googlecode.java-diff-utils" % "diffutils" % "1.3.0"
    )
  )
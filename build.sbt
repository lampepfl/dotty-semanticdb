
val dottyVersion = "0.19.0-RC1" // dottyLatestNightlyBuild.get

lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-semanticdb",
    version := "0.1.0",

    scalaVersion := dottyVersion,

    unmanagedSourceDirectories in Test += baseDirectory.value / "input" / "src" / "main" / "scala",
    scalacOptions in Compile ++= Seq("-noindent"),
    scalacOptions in Test ++= Seq("-noindent"),
    libraryDependencies ++= Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.scalameta" %% "semanticdb-scalac-core" % "4.2.1" cross CrossVersion.constant("2.13.0"),
      "com.novocode" % "junit-interface" % "0.11",
      "com.googlecode.java-diff-utils" % "diffutils" % "1.3.0"
    )
  )

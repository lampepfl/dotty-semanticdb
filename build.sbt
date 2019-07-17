
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
      ("org.scalameta" %% "semanticdb" % "4.0.0").withDottyCompat(scalaVersion.value),
      "com.novocode" % "junit-interface" % "0.11",
      "com.googlecode.java-diff-utils" % "diffutils" % "1.3.0"
    )
  )
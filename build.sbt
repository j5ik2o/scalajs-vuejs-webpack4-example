enablePlugins(ScalaJSBundlerPlugin)

name := "scalajs-vuejs-webpack4-example"

scalaVersion := "2.12.8"

npmDependencies in Compile ++=Seq(
  "vue" -> "^2.5.2",
  "vue-router" -> "^3.0.1"
)

npmDevDependencies in Compile ++= Seq(
  "vue-loader" -> "15.7.0",
  "vue-style-loader" -> "4.0.1",
  "vue-template-compiler" -> "2.6.10",
  "file-loader" -> "3.0.1",
  "style-loader" -> "0.23.1",
  "css-loader" -> "2.1.1",
  "node-sass" -> "4.11.0",
  "sass-loader" -> "7.1.0",
  "html-webpack-plugin" -> "3.2.0",
  "copy-webpack-plugin" -> "5.0.2",
"webpack-merge" -> "4.2.1"

)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.carrotgarden.sjs" %% "scala-js-vue" % "1.0.1.20180224213809"
)

libraryDependencies += "org.scalatest" %%% "scalatest" % "3.0.5" % Test

scalacOptions += "-P:scalajs:sjsDefinedByDefault"
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

version in webpack := "4.29.6"
version in startWebpackDevServer:= "3.2.1"

webpackResources := baseDirectory.value / "webpack" * "*"

webpackConfigFile in fastOptJS := Some(baseDirectory.value / "webpack" / "webpack-fastopt.config.js")
webpackConfigFile in fullOptJS := Some(baseDirectory.value / "webpack" / "webpack-opt.config.js")
webpackConfigFile in Test := Some(baseDirectory.value / "webpack" / "webpack-core.config.js")

webpackDevServerExtraArgs in fastOptJS := Seq("--inline", "--hot")
webpackBundlingMode in fastOptJS := BundlingMode.LibraryOnly()

requireJsDomEnv in Test := true

addCommandAlias("serve", ";fastOptJS::startWebpackDevServer;~fastOptJS")

addCommandAlias("devBuild", "fastOptJS")

addCommandAlias("build", "fullOptJS::webpack")

import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"            %% "ui-test-runner"     % "0.50.0"   % Test,
    "org.scalatest"          %% "scalatest"          % "3.2.19"   % Test,
    "ch.qos.logback"          % "logback-classic"    % "1.5.19"   % Test,
    "io.cucumber"             % "cucumber-junit"     % "7.30.0"   % Test,
    "io.cucumber"            %% "cucumber-scala"     % "8.35.0",
    "org.playframework"      %% "play-test"          % "3.0.9",
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.2",
    "org.scalaj"             %% "scalaj-http"        % "2.4.2",
    "com.typesafe"            % "config"             % "1.4.5"    % Test,
    "org.scalatestplus"      %% "selenium-4-21"      % "3.2.19.0" % Test,
    "org.mongodb.scala"      %% "mongo-scala-driver" % "5.6.1"    % Test
  )
}

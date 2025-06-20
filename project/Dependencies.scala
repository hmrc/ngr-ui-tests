import sbt.*

object Dependencies {

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"            %% "ui-test-runner"     % "0.46.0"   % Test,
    "org.scalatest"          %% "scalatest"          % "3.2.19"   % Test,
    "ch.qos.logback"          % "logback-classic"    % "1.5.6"    % Test,
    "io.cucumber"             % "cucumber-junit"     % "7.18.1"   % Test,
    "io.cucumber"            %% "cucumber-scala"     % "8.23.1",
    "org.playframework"      %% "play-test"          % "3.0.4",
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1",
    "org.scalaj"             %% "scalaj-http"        % "2.4.2",
    "ch.qos.logback"          % "logback-classic"    % "1.5.8",
    "com.typesafe"            % "config"             % "1.4.3"    % Test,
    "org.scalatestplus"      %% "selenium-4-21"      % "3.2.19.0" % Test,
    "org.mongodb.scala"      %% "mongo-scala-driver" % "5.3.1"    % Test
  )
}

/**
 * A simple jigsaw module
 */
module com.example.LoginAutomation {
  requires org.slf4j;
  requires ch.qos.logback.classic;
  //equires static lombok;

  exports com.example.LoginAutomation1;
  }

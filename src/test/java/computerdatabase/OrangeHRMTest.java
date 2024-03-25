package computerdatabase;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class OrangeHRMTest extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("https://opensource-demo.orangehrmlive.com")
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
    .acceptHeader("image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-US,en;q=0.9")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36");
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("Origin", "https://opensource-demo.orangehrmlive.com"),
    Map.entry("Sec-Fetch-Dest", "document"),
    Map.entry("Sec-Fetch-Mode", "navigate"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("Sec-Fetch-User", "?1"),
    Map.entry("Upgrade-Insecure-Requests", "1"),
    Map.entry("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("If-None-Match", "r2bCuSoCq/RIhAIrdHucIA2NuLVeuc+DC+DURIjsY5E="),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("contentType", "application/json"),
    Map.entry("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("Sec-Fetch-Dest", "image"),
    Map.entry("Sec-Fetch-Mode", "no-cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Accept", "application/json, text/plain, */*"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Cache-Control", "no-store, no-cache, must-revalidate, post-check=0, pre-check=0"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );
  
  private Map<CharSequence, String> headers_8 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Origin", "https://opensource-demo.orangehrmlive.com"),
    Map.entry("Sec-Fetch-Dest", "empty"),
    Map.entry("Sec-Fetch-Mode", "cors"),
    Map.entry("Sec-Fetch-Site", "same-origin"),
    Map.entry("sec-ch-ua", "Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121"),
    Map.entry("sec-ch-ua-mobile", "?0"),
    Map.entry("sec-ch-ua-platform", "Windows")
  );


  private ScenarioBuilder scn = scenario("OrangeHRMTest")
    .exec(
      http("request_0")
        .post("/web/index.php/auth/validate")
        .headers(headers_0)
        .formParam("_token", "3.4Osvz49TthZIZGzYzUZUy7Xw_wdANeL7etM8m9-r4mk.l4d5lfcm23MRFFu8-Hce84OCiHB5Uqm0SYp307XPhSu_pRuothrbVCUmWA")
        .formParam("username", "Admin")
        .formParam("password", "admin123")
        .resources(
          http("request_1")
            .get("/web/index.php/core/i18n/messages")
            .headers(headers_1),
          http("request_2")
            .get("/web/images/orangehrm-logo.png?v=1706326081969")
            .headers(headers_2),
          http("request_3")
            .get("/web/images/orange.png?v=1706326081969")
            .headers(headers_2),
          http("request_4")
            .get("/web/index.php/api/v2/buzz/feed?limit=5&offset=0&sortOrder=DESC&sortField=share.createdAtUtc")
            .headers(headers_4),
          http("request_5")
            .get("/web/index.php/api/v2/dashboard/employees/time-at-work?timezoneOffset=5.5&currentDate=2024-02-20&currentTime=15:34")
            .headers(headers_5),
          http("request_6")
            .get("/web/index.php/pim/viewPhoto/empNumber/7")
            .headers(headers_2),
          http("request_7")
            .get("/web/index.php/api/v2/dashboard/employees/action-summary")
            .headers(headers_5),
          http("request_8")
            .post("/web/index.php/events/push")
            .headers(headers_8),
          http("request_9")
            .get("/web/index.php/api/v2/dashboard/shortcuts")
            .headers(headers_5),
          http("request_10")
            .get("/web/index.php/api/v2/dashboard/employees/leaves?date=2024-02-20")
            .headers(headers_5),
          http("request_11")
            .get("/web/index.php/api/v2/dashboard/employees/subunit")
            .headers(headers_5),
          http("request_12")
            .get("/web/index.php/api/v2/dashboard/employees/locations")
            .headers(headers_5),
          http("request_13")
            .get("/web/index.php/pim/viewPhoto/empNumber/2")
            .headers(headers_2),
          http("request_14")
            .get("/web/index.php/pim/viewPhoto/empNumber/22")
            .headers(headers_2),
          http("request_15")
            .get("/web/index.php/pim/viewPhoto/empNumber/11")
            .headers(headers_2),
          http("request_16")
            .get("/web/index.php/buzz/photo/11")
            .headers(headers_2),
          http("request_17")
            .get("/web/index.php/pim/viewPhoto/empNumber/9")
            .headers(headers_2),
          http("request_18")
            .get("/web/index.php/buzz/photo/9")
            .headers(headers_2)
        )
    );

  {
	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}

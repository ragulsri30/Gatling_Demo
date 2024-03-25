package computerdatabase;

import java.time.Duration;
import java.util.*;

import akka.actor.Status;
import akka.japi.Predicate;
import io.gatling.core.scenario.Scenario;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class TestHRM extends Simulation {

	private HttpProtocolBuilder httpProtocol = http.baseUrl("https://opensource-demo.orangehrmlive.com")
			.inferHtmlResources(AllowList(),
					DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff",
							".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*\\.svg", ".*detectportal\\.firefox\\.com.*"))
			.userAgentHeader(
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");

	private ChainBuilder login = exec(http("request_0").post("/web/index.php/auth/validate").formParam("_token",
			"27119ef9ad259253343e1fdf06.2ZLfo0UxVVRO4hhgipmclwlszn3CbEudOpWpNSP4Ky0.n9PowBV4Oi1-jUct0PH_40g7lz6UWTvrCtbEUk2qfEqz6o6TGmk2Ew_WVQ")
			.formParam("username", "Admin").formParam("password", "admin123")
			.resources(http("request_1").get("/web/dist/css/chunk-vendors.css?v=1706326081969"),
					http("request_2").get("/web/dist/css/app.css?v=1706326081969"),
					http("request_3").get("/web/dist/js/chunk-vendors.js?v=1706326081969"),
					http("request_4").get("/web/dist/js/app.js?v=1706326081969"),
					http("request_5").get("/web/index.php/core/i18n/messages"),
					http("request_6").get("/web/images/orange.png?v=1706326081969"),
					http("request_7").get("/web/images/orangehrm-logo.png?v=1706326081969"),
					http("request_8").get("/web/index.php/pim/viewPhoto/empNumber/7"),
					http("request_9").get("/web/index.php/api/v2/dashboard/employees/time-at-work?timezoneOffset=5.5&currentDate=2024-02-27&currentTime=11:41"),
					http("request_10").get("/web/index.php/api/v2/dashboard/employees/action-summary"),
					http("request_11").get("/web/index.php/api/v2/dashboard/shortcuts"),
					http("request_12").get(
							"/web/index.php/api/v2/buzz/feed?limit=5&offset=0&sortOrder=DESC&sortField=share.createdAtUtc"),
					http("request_13").get("/web/index.php/api/v2/dashboard/employees/subunit"),
					http("request_14").get("/web/index.php/api/v2/dashboard/employees/leaves?date=2024-02-27"),
					http("request_15").post("/web/index.php/events/push"),
					http("request_16").get("/web/index.php/api/v2/dashboard/employees/locations"),
					http("request_17").get("/web/index.php/pim/viewPhoto/empNumber/2"),
					http("request_18").get("/web/index.php/buzz/photo/11"),
					http("request_19").get("/web/index.php/pim/viewPhoto/empNumber/22"),
					http("request_20").get("/web/index.php/buzz/photo/9"),
					http("request_21").get("/web/index.php/pim/viewPhoto/empNumber/11"),
					http("request_22").get("/web/index.php/pim/viewPhoto/empNumber/9")

			), pause(9));

	private ChainBuilder View = exec(http("request_23").get("/web/index.php/admin/viewAdminModule")

			.resources(http("request_24").get("/web/dist/css/chunk-vendors.css?v=1706326081969"),
					http("request_25").get("/web/dist/css/app.css?v=1706326081969"),
					http("request_26").get("/web/dist/js/chunk-vendors.js?v=1706326081969"),
					http("request_27").get("/web/dist/js/app.js?v=1706326081969"),
					http("request_28").get("/web/index.php/core/i18n/messages"),
					http("request_29").get("/web/images/orange.png?v=1706326081969"),
					http("request_30").get("/web/images/orangehrm-logo.png?v=1706326081969"),
					http("request_31").get("/web/index.php/pim/viewPhoto/empNumber/7"), http("request_32").get(
							"/web/index.php/api/v2/admin/users?limit=50&offset=0&sortField=u.userName&sortOrder=ASC")

			), pause(8));

	ChainBuilder logout = exec(http("request_33").get("/web/index.php/auth/logout")

			.resources(http("request_34").get("/web/index.php/core/i18n/messages"),
					http("request_35").get("/web/images/ohrm_branding.png?v=1706326081969")

			));
	
	
	
	ScenarioBuilder user = scenario("Login_user").exec(login);

	ScenarioBuilder view = scenario("Admin view").exec(View);

	ScenarioBuilder logOut = scenario("Login").exec(logout);

	{
		setUp(

				user.injectOpen(rampUsers(20).during(10)),

				view.injectOpen(rampUsers(20).during(10)),

				logOut.injectOpen(rampUsers(30).during(10))

		).protocols(httpProtocol);

	}

}

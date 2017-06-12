package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

class StartControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "Start controller" must {
    "return 200 for a POST" in {
      val json =
        """{
          | "lastOpponentMove": "PAPER",
          | "pointsToWin": 1000,
          | "maxRounds": 2000,
          | "dynamiteCount": 100
          | }""".stripMargin
      val request = FakeRequest(POST, "/start").withHeaders("Host" -> "localhost").withJsonBody(Json.parse(json))
      val result = route(app, request).get

      status(result) mustBe OK
    }
  }
}

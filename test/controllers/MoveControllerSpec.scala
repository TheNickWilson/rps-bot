package controllers

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers.{status, _}

class MoveControllerSpec extends PlaySpec with GuiceOneAppPerTest {

  "Move controller" must {
    "return 200 for a GET" in {
      val request = FakeRequest(GET, "/move").withHeaders("Host" -> "localhost")
      val result = route(app, request).get

      status(result) mustBe OK
    }

    """return "ROCK" as JSON for a GET""" in {
      val request = FakeRequest(GET, "/move").withHeaders("Host" -> "localhost")
      val result = route(app, request).get

      contentType(result) mustBe Some("application/json")
      contentAsString(result) mustBe """"ROCK""""
    }

    "return 200 for a POST" in {
      val json = """{"lastOpponentMove": "PAPER"}"""
      val request = FakeRequest(POST, "/move").withHeaders("Host" -> "localhost").withJsonBody(Json.parse(json))
      val result = route(app, request).get

      status(result) mustBe OK
    }
  }
}

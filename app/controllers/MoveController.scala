package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

class MoveController extends Controller {
  def move() = Action {
    Ok(Json.toJson("ROCK"))
  }
}

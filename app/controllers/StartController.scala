package controllers

import play.api.mvc.{Action, Controller}

class StartController extends Controller {
  def start() = Action {
    Ok
  }
}

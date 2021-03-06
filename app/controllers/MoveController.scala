package controllers

import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

class MoveController extends Controller {

  var mostRecentMove = ""

  val ROCK = "Rock"
  val PAPER = "Paper"
  val SCISSORS = "Scissors"

  val list = List(ROCK,PAPER,SCISSORS)
  val r = scala.util.Random

  def move() = Action {
    val m = list(r.nextInt(3))
    mostRecentMove = m
    Ok(Json.toJson(m))
  }

  def lastMove() = Action {
    // how would you know I am not lying about my last move and sending back paper all the time?
    Ok(Json.toJson(mostRecentMove))
  }


}
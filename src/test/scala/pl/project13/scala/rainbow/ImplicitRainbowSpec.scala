package pl.project13.scala.rainbow

import org.scalatest.{Matchers, FlatSpec}

class ImplicitRainbowSpec extends FlatSpec with Matchers {

  behavior of "Rainbow"

  it should "colorize strings" in {
    val red = "red".red
    val blue = "blue".blue
    val yellow = "yellow".yellow
    val green = "green".green

    println("red = " + red)
    println("blue = " + blue)
    println("yellow = " + yellow)
    println("green = " + green)
  }
}

package pl.project13.scala.rainbow

import org.scalatest.{Matchers, FlatSpec}

class ImplicitRainbowSpec extends FlatSpec with Matchers {

  behavior of "Rainbow"

  it should "be able to set custom colour" in {
     "custom".colour("\033[30m") shouldEqual (Console.BLACK + "custom" + Console.RESET)
  }

  it should "colorize strings" in {
    val red = "red".red
    val blue = "blue".blue
    val yellow = "yellow".yellow
    val green = "green".green

    red shouldEqual (Console.RED + "red" + Console.RESET)
    blue shouldEqual (Console.BLUE + "blue" + Console.RESET)
    yellow shouldEqual (Console.YELLOW + "yellow" + Console.RESET)
    green shouldEqual (Console.GREEN + "green" + Console.RESET)

    println("red = " + red)
    println("blue = " + blue)
    println("yellow = " + yellow)
    println("green = " + green)
  }
}

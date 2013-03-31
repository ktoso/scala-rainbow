package pl.project13.scala.rainbow

import scala.Console._
import util.matching.Regex

/**
 * To use rainbow simply do the following:
 * '''
 * import Rainbow._
 * println { "Red warning".red }
 * '''
 *
 * you can also use it as a trait:
 * '''
 * object It extends App with Rainbow {
 *   println { "I like green".green }
 * }
 * '''
 */
trait Rainbow {

  implicit def hasRainbow(s: String) = new RainbowString(s)

  class RainbowString(val s: String) extends Colors with IfColors
}

trait Colors {
  def s: String

  /** Colorize the given string foreground to ANSI black */
  def black = BLACK + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def red = RED + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def green = GREEN + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def yellow = YELLOW + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def blue = BLUE + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def magenta = MAGENTA + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def cyan = CYAN + s + RESET
  /** Colorize the given string foreground to ANSI red */
  def white = WHITE + s + RESET

  /** Colorize the given string background to ANSI red */
  def onBlack = BLACK_B + s + RESET
  /** Colorize the given string background to ANSI red */
  def onRed = RED_B+ s + RESET
  /** Colorize the given string background to ANSI red */
  def onGreen = GREEN_B+ s + RESET
  /** Colorize the given string background to ANSI red */
  def onYellow = YELLOW_B + s + RESET
  /** Colorize the given string background to ANSI red */
  def onBlue = BLUE_B+ s + RESET
  /** Colorize the given string background to ANSI red */
  def onMagenta = MAGENTA_B + s + RESET
  /** Colorize the given string background to ANSI red */
  def onCyan = CYAN_B+ s + RESET
  /** Colorize the given string background to ANSI red */
  def onWhite = WHITE_B+ s + RESET

  /** Make the given string bold */
  def bold = BOLD + s + RESET
  /** Underline the given string */
  def underlined = UNDERLINED + s + RESET
  /** Make the given string blink (some terminals may turn this off) */
  def blink = BLINK + s + RESET
  /** Reverse the ANSI colors of the given string */
  def reversed = REVERSED + s + RESET
  /** Make the given string invisible using ANSI color codes */
  def invisible = INVISIBLE + s + RESET
}

trait IfColors extends Colors {

  def s: String

  def blackIf(matches: String)   = onMatch(matches.r) { black }
  def redIf(matches: String)     = onMatch(matches.r) { red }
  def greenIf(matches: String)   = onMatch(matches.r) { green }
  def yellowIf(matches: String)  = onMatch(matches.r) { yellow }
  def blueIf(matches: String)    = onMatch(matches.r) { blue }
  def magentaIf(matches: String) = onMatch(matches.r) { magenta }
  def cyanIf(matches: String)    = onMatch(matches.r) { cyan }
  def whiteIf(matches: String)   = onMatch(matches.r) { white }

  def boldIf(matches: String)       = onMatch(matches.r) { bold }
  def underlinedIf(matches: String) = onMatch(matches.r) { underlined }
  def blinkIf(matches: String)      = onMatch(matches.r) { blink }
  def reversedIf(matches: String)   = onMatch(matches.r) { reversed }
  def invisibleIf(matches: String)  = onMatch(matches.r) { invisible }

  private def onMatch(regex: Regex)(colorized: => String): String =
    if (regex.pattern.matcher(s).matches) colorized else s
}

/**
 * To use rainbow simply do the following:
 * '''
 * import rainbow._
 * println { "Red warning".red }
 * '''
 */
object Rainbow extends Rainbow

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
  @inline def black = BLACK + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def red = RED + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def green = GREEN + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def yellow = YELLOW + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def blue = BLUE + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def magenta = MAGENTA + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def cyan = CYAN + s + RESET

  /** Colorize the given string foreground to ANSI red */
  @inline def white = WHITE + s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onBlack = BLACK_B + s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onRed = RED_B+ s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onGreen = GREEN_B+ s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onYellow = YELLOW_B + s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onBlue = BLUE_B+ s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onMagenta = MAGENTA_B + s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onCyan = CYAN_B+ s + RESET

  /** Colorize the given string background to ANSI red */
  @inline def onWhite = WHITE_B+ s + RESET

  /** Make the given string bold */
  @inline def bold = BOLD + s + RESET

  /** Underline the given string */
  @inline def underlined = UNDERLINED + s + RESET

  /** Make the given string blink (some terminals may turn this off) */
  @inline def blink = BLINK + s + RESET

  /** Reverse the ANSI colors of the given string */
  @inline def reversed = REVERSED + s + RESET

  /** Make the given string invisible using ANSI color codes */
  @inline def invisible = INVISIBLE + s + RESET
}

trait IfColors extends Colors {

  def s: String

  @inline def blackIf(matches: String): String   = blackIf(matches.r)
  @inline def blackIf(matches: Regex): String    = onMatch(matches) { black }

  @inline def redIf(matches: String): String     = redIf(matches.r)
  @inline def redIf(matches: Regex): String      = onMatch(matches) { red }

  @inline def greenIf(matches: String): String   = onMatch(matches.r) { green }
  @inline def greenIf(matches: Regex): String    = onMatch(matches) { green }

  @inline def yellowIf(matches: String): String  = onMatch(matches.r) { yellow }
  @inline def yellowIf(matches: Regex): String   = onMatch(matches) { yellow }

  @inline def blueIf(matches: String): String    = onMatch(matches.r) { blue }
  @inline def blueIf(matches: Regex): String     = onMatch(matches) { blue }

  @inline def magentaIf(matches: String): String = onMatch(matches.r) { magenta }
  @inline def magentaIf(matches: Regex): String  = onMatch(matches) { magenta }

  @inline def cyanIf(matches: String): String    = onMatch(matches.r) { cyan }
  @inline def cyanIf(matches: Regex): String     = onMatch(matches) { cyan }

  @inline def whiteIf(matches: String): String   = onMatch(matches.r) { white }
  @inline def whiteIf(matches: Regex): String    = onMatch(matches) { white }


  @inline def boldIf(matches: String): String       = onMatch(matches.r) { bold }
  @inline def boldIf(matches: Regex): String        = onMatch(matches) { bold }

  @inline def underlinedIf(matches: String): String = onMatch(matches.r) { underlined }
  @inline def underlinedIf(matches: Regex): String  = onMatch(matches) { underlined }

  @inline def blinkIf(matches: String): String      = onMatch(matches.r) { blink }
  @inline def blinkIf(matches: Regex): String       = onMatch(matches) { blink }

  @inline def reversedIf(matches: String): String   = onMatch(matches.r) { reversed }
  @inline def reversedIf(matches: Regex): String    = onMatch(matches) { reversed }

  @inline def invisibleIf(matches: String): String  = onMatch(matches.r) { invisible }
  @inline def invisibleIf(matches: Regex): String   = onMatch(matches) { invisible }

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

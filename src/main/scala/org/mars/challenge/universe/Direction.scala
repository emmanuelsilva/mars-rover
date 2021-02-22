package org.mars.challenge.universe

sealed trait Direction {
  def toLeft: Direction
  def toRight: Direction
}

case object North extends Direction {
  def toLeft: Direction = West
  def toRight: Direction = East
}
case object South extends Direction {
  def toLeft: Direction = East
  def toRight: Direction = West
}
case object East extends Direction {
  def toLeft: Direction = North
  def toRight: Direction = South
}

case object West extends Direction {
  def toLeft: Direction = South
  def toRight: Direction = North
}

object Direction {
  def apply(direction: String): Direction = {
    direction match {
      case "N" => North
      case "S" => South
      case "E" => East
      case "W" => West
      case _   => throw new IllegalArgumentException(s"unknown direction: $direction")
    }
  }
}

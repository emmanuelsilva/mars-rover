package org.mars.challenge.domain

sealed trait MarsPlateau {
  def canMove(marsRover: MarsRover): Boolean
}

/**
 * A Rectangle composed by the following points:
 *
 *  A -------------- B
 *  |                |
 *  |                |
 *  |                |
 *  D -------------- C
 * (0,0)
 */
case class MarsRectanglePlateau(a: Point, b: Point, c: Point, d: Point) extends MarsPlateau {

  def canMove(marsRover: MarsRover): Boolean = {
    marsRover.direction match {
      case North => marsRover.point.y < a.y
      case South => marsRover.point.y > d.y
      case East  => marsRover.point.x < c.x
      case West  => marsRover.point.x > d.x
    }
  }
}

object MarsPlateau {
  def apply(topX: Int, topY: Int): MarsPlateau = {
    MarsRectanglePlateau(
      Point(0, topY),
      Point(topX, topY),
      Point(topX, 0),
      Point(0, 0)
    )
  }
}

package org.mars.challenge.universe

sealed trait MarsPlateau {
  def valid(point: Point): Boolean
}

/**
 * A Rectangle composed by the following points:
 *
 * A -------------- B
 * |                |
 * |                |
 * |                |
 * D -------------- C
 */
case class MarsRectanglePlateau(a: Point, b: Point, c: Point, d: Point) extends MarsPlateau {

  def valid(point: Point): Boolean = {
    val insideXAxis = d.x to c.x contains point.x
    val insideYAxis =  d.y to a.y contains point.y

    insideXAxis && insideYAxis
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

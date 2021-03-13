package org.mars.challenge.domain

case class Point(x: Int, y: Int) {
  def up: Point = Point(x, y + 1)
  def down: Point = Point(x, y - 1)
  def left: Point = Point(x - 1, y)
  def right: Point = Point(x + 1, y)
}

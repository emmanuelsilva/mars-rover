package org.mars.challenge.rover

import org.mars.challenge.universe._

case class MarsRover(point: Point, direction: Direction) {

  def turnLeft: MarsRover = {
    MarsRover(point, direction.toLeft)
  }

  def turnRight: MarsRover = {
    MarsRover(point, direction.toRight)
  }

  def move: MarsRover = {
    direction match {
      case North => MarsRover(point.up, direction)
      case South => MarsRover(point.down, direction)
      case East => MarsRover(point.right, direction)
      case West => MarsRover(point.left, direction)
    }
  }
}

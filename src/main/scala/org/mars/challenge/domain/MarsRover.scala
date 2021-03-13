package org.mars.challenge.domain

case class MarsRover(point: Point, direction: Direction, flags: Seq[Point]) {

  def turnLeft: MarsRover = {
    copy(direction = direction.toLeft)
  }

  def turnRight: MarsRover = {
    copy(direction = direction.toRight)
  }

  def move: MarsRover = {
    direction match {
      case North => copy(point = point.up)
      case South => copy(point = point.down)
      case East  => copy(point = point.right)
      case West  => copy(point = point.left)
    }
  }

  def plantFlag(): MarsRover = {
    copy(flags = flags :+ point)
  }
}

object MarsRover {
  def apply(point: Point, direction: Direction): MarsRover = {
    MarsRover(point, direction, Seq[Point]())
  }
}

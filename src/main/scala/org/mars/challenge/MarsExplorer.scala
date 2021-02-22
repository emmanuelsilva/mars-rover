package org.mars.challenge

import org.mars.challenge.rover.MarsRover
import org.mars.challenge.universe.MarsPlateau

class MarsExplorer(marsPlateau: MarsPlateau) {

  def explore(marsRover: MarsRover, command: Seq[Command]): MarsRover = {
    command.foldLeft(marsRover)(executeCommand)
  }

  private def executeCommand(marsRover: MarsRover, command: Command): MarsRover = {
    command match {
      case Left  => marsRover.turnLeft
      case Right => marsRover.turnRight
      case Move  => moveIfValid(marsRover)
    }
  }

  private def moveIfValid(marsRover: MarsRover) = {
    val marsRoverInNextPosition = marsRover.move

    Either.cond(
      marsPlateau.valid(marsRoverInNextPosition.point),
      marsRoverInNextPosition,
      marsRover
    ).merge
  }
}

object MarsExplorer {

  def apply(topX: Int, topY: Int): MarsExplorer = {
    val marsPlateau = MarsPlateau(topX, topY)
    new MarsExplorer(marsPlateau)
  }
}

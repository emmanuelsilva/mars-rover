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
      case Move  => moveOrCurrent(marsRover)
      case Empty => marsRover
    }
  }

  private def moveOrCurrent(marsRover: MarsRover) = {
    Either.cond(
      marsPlateau.canMove(marsRover),
      marsRover.move,
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

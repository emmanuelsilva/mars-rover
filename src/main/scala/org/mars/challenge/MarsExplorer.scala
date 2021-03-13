package org.mars.challenge

import org.mars.challenge.domain.{Command, Flag, MarsPlateau, MarsRover, Move, Left, Right}

object MarsExplorer {

  def explore(marsPlateau: MarsPlateau)(marsRover: MarsRover, command: Seq[Command]): MarsRover = {
    command.foldLeft(marsRover)(executeCommand(marsPlateau))
  }

  private def executeCommand(marsPlateau: MarsPlateau)(marsRover: MarsRover, command: Command): MarsRover = {
    command match {
      case Left                                   => marsRover.turnLeft
      case Right                                  => marsRover.turnRight
      case Move if marsPlateau.canMove(marsRover) => marsRover.move
      case Flag                                   => marsRover.plantFlag()
      case _                                      => marsRover
    }
  }
}

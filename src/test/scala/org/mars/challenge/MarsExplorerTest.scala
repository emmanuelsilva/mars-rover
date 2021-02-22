package org.mars.challenge

import org.mars.challenge.rover.MarsRover
import org.mars.challenge.universe.{Direction, East, North, Point}
import org.scalatest.Matchers._
import org.scalatest.WordSpecLike

class MarsExplorerTest extends WordSpecLike {

  "Shouldn't cross the mars plateau limits" in {
    val marsRover = MarsRover(
      Point(0,1),
      Direction("N")
    )

    val commands = Seq[Command](
      Move, Move, Move, Move
    )

    val marsRoverInExpectedPosition = MarsRover(
      Point(0,2),
      Direction("N")
    )

    val marsChallenge = MarsExplorer(2,2)
    val exploredMarsRover = marsChallenge.explore(marsRover, commands)

    exploredMarsRover shouldBe marsRoverInExpectedPosition
  }

  "Should move the mars probe from 1,2,N to the 1,3,N position using the LMLMLMLMM commands in a 5x5 plateau" in {

    val marsRover = MarsRover(
      Point(1, 2),
      Direction("N")
    )

    val commands = Seq[Command](
      Left, Move, Left, Move, Left, Move, Left, Move, Move
    )

    val marsRoverInExpectedPosition = MarsRover(
      Point(1, 3),
      North
    )

    val marsChallenge = MarsExplorer(5, 5)
    val exploredMarsRover = marsChallenge.explore(marsRover, commands)

    exploredMarsRover shouldBe marsRoverInExpectedPosition
  }

  "Should move the mars probe from 3,3,E to the 5,1,E position using the MMRMMRMRRM commands in a 5x5 plateau" in {
    val marsRover = MarsRover(
      Point(3, 3),
      Direction("E")
    )

    val commands = Seq[Command](
      Move, Move, Right, Move, Move, Right, Move, Right, Right, Move
    )

    val marsRoverInExpectedPosition = MarsRover(
      Point(5, 1),
      East
    )

    val marsChallenge = MarsExplorer(5, 5)
    val exploredMarsRover = marsChallenge.explore(marsRover, commands)

    exploredMarsRover shouldBe marsRoverInExpectedPosition
  }

}

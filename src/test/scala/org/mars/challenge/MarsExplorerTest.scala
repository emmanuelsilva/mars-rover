package org.mars.challenge

import org.mars.challenge.rover.MarsRover
import org.mars.challenge.universe._
import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatest.WordSpecLike

class MarsExplorerTest extends WordSpecLike {

  "Should plant a flag at 1,1 position" in {
    val plateau = MarsPlateau(2,2)

    val marsRover = MarsRover(
      Point(0,0),
      Direction("N")
    )

    val commands = Seq[Command](
      Move, Right, Move, Flag, Move, Left, Move
    )

    val exploredMarsRover = MarsExplorer.explore(plateau)(marsRover, commands)

    val expectedMarsRover = new MarsRover(
      Point(2,2),
      North,
      Seq[Point](Point(1,1))
    )

    exploredMarsRover shouldBe expectedMarsRover

  }

  "Shouldn't cross the mars plateau limits" in {
    val plateau = MarsPlateau(2,2)

    val marsRover = MarsRover(
      Point(0,1),
      Direction("N")
    )

    val commands = Seq[Command](
      Move, Move, Move, Move
    )

    val exploredMarsRover = MarsExplorer.explore(plateau)(marsRover, commands)

    val marsRoverInExpectedPosition = MarsRover(
      Point(0,2),
      Direction("N")
    )

    exploredMarsRover shouldBe marsRoverInExpectedPosition
  }

  "Should move the mars probe from 1,2,N to the 1,3,N position using the LMLMLMLMM commands in a 5x5 plateau" in {
    val plateau = MarsPlateau(5,5)

    val marsRover = MarsRover(
      Point(1, 2),
      Direction("N")
    )

    val commands = Seq[Command](
      Left, Move, Left, Move, Left, Move, Left, Move, Move
    )

    val exploredMarsRover = MarsExplorer.explore(plateau)(marsRover, commands)

    val marsRoverInExpectedPosition = MarsRover(
      Point(1, 3),
      North
    )

    exploredMarsRover shouldBe marsRoverInExpectedPosition
  }

  "Should move the mars probe from 3,3,E to the 5,1,E position using the MMRMMRMRRM commands in a 5x5 plateau" in {
    val plateau = MarsPlateau(5,5)

    val marsRover = MarsRover(
      Point(3, 3),
      Direction("E")
    )

    val commands = Seq[Command](
      Move, Move, Right, Move, Move, Right, Move, Right, Right, Move
    )

    val exploredMarsRover = MarsExplorer.explore(plateau)(marsRover, commands)

    val marsRoverInExpectedPosition = MarsRover(
      Point(5, 1),
      East
    )

    exploredMarsRover shouldBe marsRoverInExpectedPosition
  }
}

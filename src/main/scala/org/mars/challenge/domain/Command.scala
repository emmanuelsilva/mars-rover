package org.mars.challenge.domain

sealed trait Command
case object Empty extends Command
case object Left extends Command
case object Right extends Command
case object Move extends Command
case object Flag extends Command

object Command {
  def apply(command: String): Command = command match {
    case "L" => Left
    case "R" => Right
    case "M" => Move
    case "F" => Flag
    case _   => Empty
  }
}

package com.skraba.template

import com.tinfoiled.docopt4s.{AnsiConsole, Docopt, Task}

import java.io.IOException

/** Template task does little */
object TemplateTask extends Task {

  val Cmd = "template"

  val Description = "TODO"

  val Doc: String =
    """%s
      |
      |Usage:
      |  TemplateGo template GREETING [--name WORLD]
      |
      |Options:
      |  GREETING      Custom greeting
      |  --name=WORLD  Custom name [Default: World]
      |Examples:
      |
      |TODO
      |
      |""".stripMargin
      .format(Description)
      .trim

  @throws[IOException]
  def go(opt: Docopt): Unit = {
    val greeting = opt.string.get("GREETING")
    val name = opt.string.get("--name")
    val out = AnsiConsole(verbose = true)
    out.vPrint(s"$greeting, $name!")
  }
}

package com.skraba.template

import com.tinfoiled.docopt4s.{MultiTaskMain, Task}

/** Template. */
object TemplateGo extends MultiTaskMain {
  override lazy val Name: String = "TemplateGo"
  override lazy val Version: String = "0.0.1-SNAPSHOT"
  override lazy val Tasks: Seq[Task] = Seq(TemplateTask)
  override lazy val Doc: String = "My tool\n\n" + SimpleDoc
}

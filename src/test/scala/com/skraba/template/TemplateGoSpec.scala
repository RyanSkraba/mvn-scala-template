package com.skraba.template

import com.tinfoiled.docopt4s.testkit.MultiTaskMainSpec

/** Unit tests for [[TemplateGo]] */
class TemplateGoSpec extends MultiTaskMainSpec(TemplateGo) {

  describe(s"${Main.Name} command line") {

    itShouldThrowOnHelpAndVersionFlags()

    it("throw an exception like --help when run without a command") {
      val t = interceptGoDocoptEx("--debug")
      t.getMessage shouldBe "Missing command"
      t.docopt shouldBe Main.Doc
    }

    for (
      args <- Seq(
        Seq("--garbage"),
        Seq("--debug", "--garbage"),
        Seq("--garbage", "--debug"),
        Seq("--garbage", "garbage")
      )
    ) it(s"throw an exception with unknown option $args") {
      val t = interceptGoDocoptEx(args: _*)
      t.exitCode shouldBe 1
      t.getMessage shouldBe null
    }

    for (
      args <- Seq(
        Seq("garbage"),
        Seq("--debug", "garbage")
      )
    ) it(s"throw an exception when an unknown command is sent $args") {
      val t = interceptGoDocoptEx(args: _*)
      t.getMessage shouldBe "Unknown command: garbage"
      t.docopt shouldBe Main.Doc
    }
  }
}

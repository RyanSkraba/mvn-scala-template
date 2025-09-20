package com.skraba.template

import com.tinfoiled.docopt4s.testkit.{MultiTaskMainSpec, TmpDir}

/** Unit tests for [[TemplateTask]] */
class TemplateTaskSpec extends MultiTaskMainSpec(TemplateGo, Some(TemplateTask)) with TmpDir {

  describe(s"${Main.Name} $TaskCmd command line") {

    itShouldThrowOnHelpAndVersionFlags()

    itShouldThrowOnUnknownFlag()

    itShouldThrowOnIncompleteArgs(Seq.empty)

    itShouldThrowOnMissingFlagValue(Seq("Hello", "--name"))

    it("should run a basic use case") {
      withGoMatching(TaskCmd, "Hello") { case (stdout, stderr) =>
        stderr shouldBe empty
        stdout shouldBe "Hello, World!"
      }
      withGoMatching(TaskCmd, "Hello", "--name", "world!!!") { case (stdout, stderr) =>
        stderr shouldBe empty
        stdout shouldBe "Hello, world!!!!"
      }
    }
  }
}

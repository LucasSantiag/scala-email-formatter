package com.vigil.functions

import org.scalatest.wordspec.AnyWordSpec

class TextSplitterFunctionsTest extends AnyWordSpec {
  "TextSplitterFunctions" when {
    "using splitWithTailRec" should {
      "correctly return when empty list is provided" in {
        val inputList = List()
        val expectedOutput = ""
        val result = TextSplitterFunctions.splitWithTailRec(inputList)
        assert(result == expectedOutput)
      }

      "correctly split text within the character limit" in {
        val inputList = List("Simple", "text", "for", "TextSplitterFunctions.")
        val expectedOutput = "Simple text for TextSplitterFunctions."
        val result = TextSplitterFunctions.splitWithTailRec(inputList)
        assert(result == expectedOutput)
      }

      "correctly split text exceeding the character limit" in {
        val inputList = List("This", "is", "a", "long", "sentence", "that", "exceeds", "the", "character", "limit", "specified.")
        val expectedOutput = "This is a long sentence that exceeds the\ncharacter limit specified."
        val result = TextSplitterFunctions.splitWithTailRec(inputList)
        assert(result == expectedOutput)
      }

      "correctly split with different character limit" in {
        val inputList = List("Simple", "text", "for", "TextSplitterFunctions.")
        val expectedOutput = "Simple\ntext for\nTextSplitterFunctions."
        val result = TextSplitterFunctions.splitWithTailRec(inputList, 10)
        assert(result == expectedOutput)
      }
    }

    "using splitWithFoldLeft" should {
      "correctly return when empty list is provided" in {
        val inputList = List()
        val expectedOutput = ""
        val result = TextSplitterFunctions.splitWithFoldLeft(inputList)
        assert(result == expectedOutput)
      }

      "correctly split text within the character limit" in {
        val inputList = List("Simple", "text", "for", "TextSplitterFunctions.")
        val expectedOutput = "Simple text for TextSplitterFunctions."
        val result = TextSplitterFunctions.splitWithFoldLeft(inputList)
        assert(result == expectedOutput)
      }

      "correctly split text exceeding the character limit" in {
        val inputList = List("This", "is", "a", "long", "sentence", "that", "exceeds", "the", "character", "limit", "specified.")
        val expectedOutput = "This is a long sentence that exceeds the\ncharacter limit specified."
        val result = TextSplitterFunctions.splitWithFoldLeft(inputList, 40)
        assert(result == expectedOutput)
      }

      "correctly split with different character limit" in {
        val inputList = List("Simple", "text", "for", "TextSplitterFunctions.")
        val expectedOutput = "Simple\ntext for\nTextSplitterFunctions."
        val result = TextSplitterFunctions.splitWithFoldLeft(inputList, 10)
        assert(result == expectedOutput)
      }
    }

    "using given example on code description" should {
      "correctly split text with splitWithTailRec" in {
        val inputList = List("In", "1991,", "while", "studying", "computer", "science", "at", "University", "of", "Helsinki,", "Linus", "Torvalds", "began", "a", "project", "that", "later", "became", "the", "Linux", "kernel.", "He", "wrote", "the", "program", "specifically", "for", "the", "hardware", "he", "was", "using", "and", "independent", "of", "an", "operating", "system", "because", "he", "wanted", "to", "use", "the", "functions", "of", "his", "new", "PC", "with", "an", "80386", "processor.", "Development", "was", "done", "on", "MINIX", "using", "the", "GNU", "C", "Compiler.")
        val expectedOutput =
          """|In 1991, while studying computer science
            |at University of Helsinki, Linus
            |Torvalds began a project that later
            |became the Linux kernel. He wrote the
            |program specifically for the hardware he
            |was using and independent of an
            |operating system because he wanted to
            |use the functions of his new PC with an
            |80386 processor. Development was done on
            |MINIX using the GNU C Compiler.""".stripMargin
        val result = TextSplitterFunctions.splitWithTailRec(inputList)
        assert(result == expectedOutput)
      }

      "correctly split text with splitWithFoldLeft" in {
        val inputList = List("In", "1991,", "while", "studying", "computer", "science", "at", "University", "of", "Helsinki,", "Linus", "Torvalds", "began", "a", "project", "that", "later", "became", "the", "Linux", "kernel.", "He", "wrote", "the", "program", "specifically", "for", "the", "hardware", "he", "was", "using", "and", "independent", "of", "an", "operating", "system", "because", "he", "wanted", "to", "use", "the", "functions", "of", "his", "new", "PC", "with", "an", "80386", "processor.", "Development", "was", "done", "on", "MINIX", "using", "the", "GNU", "C", "Compiler.")
        val expectedOutput =
          """|In 1991, while studying computer science
             |at University of Helsinki, Linus
             |Torvalds began a project that later
             |became the Linux kernel. He wrote the
             |program specifically for the hardware he
             |was using and independent of an
             |operating system because he wanted to
             |use the functions of his new PC with an
             |80386 processor. Development was done on
             |MINIX using the GNU C Compiler.""".stripMargin
        val result = TextSplitterFunctions.splitWithFoldLeft(inputList)
        assert(result == expectedOutput)
      }
    }
  }
}
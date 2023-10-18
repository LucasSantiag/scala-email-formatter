package com.vigil.utils

import org.scalatest.wordspec.AnyWordSpec

class TextUtilsTest extends AnyWordSpec {
  "EmailTextUtils" when {
    "using textToList" should {
      "correctly convert text to a list of words" in {
        val inputText = "This is a test sentence for EmailTextUtils."
        val expectedOutput = List("This", "is", "a", "test", "sentence", "for", "EmailTextUtils.")
        val result = TextUtils.textToList(inputText)
        assert(result == expectedOutput)
      }

      "return an empty list when input text is empty" in {
        val inputText = ""
        val expectedOutput = List("")
        val result = TextUtils.textToList(inputText)
        assert(result == expectedOutput)
      }

      "validate example provided" in {
        val inputText = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."
        val expectedOutput = List("In", "1991,", "while", "studying", "computer", "science", "at", "University", "of", "Helsinki,", "Linus", "Torvalds", "began", "a", "project", "that", "later", "became", "the", "Linux", "kernel.", "He", "wrote", "the", "program", "specifically", "for", "the", "hardware", "he", "was", "using", "and", "independent", "of", "an", "operating", "system", "because", "he", "wanted", "to", "use", "the", "functions", "of", "his", "new", "PC", "with", "an", "80386", "processor.", "Development", "was", "done", "on", "MINIX", "using", "the", "GNU", "C", "Compiler.")
        val result = TextUtils.textToList(inputText)
        assert(result == expectedOutput)
      }
    }
  }

}

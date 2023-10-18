package com.vigil

import com.vigil.functions.TextSplitterFunctions
import com.vigil.utils.TextUtils

object EmailFormatPluginApp {
  def main(args: Array[String]): Unit = {
    simpleExampleWithFoldLeft()
    simpleExampleWithTailRecursion()
  }

  /**
   * Provides the execution of the example provided in the Challenge Description.
   * This approach utilizes Functional Programming using the foldLeft List method.
   */
  def simpleExampleWithFoldLeft(): Unit = {
    val input = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."
    val formattedText = TextSplitterFunctions.splitWithFoldLeft(TextUtils.textToList(input))
    val expected = """In 1991, while studying computer science
                     |at University of Helsinki, Linus
                     |Torvalds began a project that later
                     |became the Linux kernel. He wrote the
                     |program specifically for the hardware he
                     |was using and independent of an
                     |operating system because he wanted to
                     |use the functions of his new PC with an
                     |80386 processor. Development was done on
                     |MINIX using the GNU C Compiler.""".stripMargin
    println(s"The result and expected output are: ${formattedText == expected} equals")
  }

  /**
   * Provides the execution of the example provided in the Challenge Description.
   * This approach utilizes Functional Programming using the Tail Recursion.
   */
  def simpleExampleWithTailRecursion(): Unit = {
    val input = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."
    val formattedText = TextSplitterFunctions.splitWithTailRec(TextUtils.textToList(input))
    val expected =
      """In 1991, while studying computer science
        |at University of Helsinki, Linus
        |Torvalds began a project that later
        |became the Linux kernel. He wrote the
        |program specifically for the hardware he
        |was using and independent of an
        |operating system because he wanted to
        |use the functions of his new PC with an
        |80386 processor. Development was done on
        |MINIX using the GNU C Compiler.""".stripMargin
    println(s"The result and expected output are: ${formattedText == expected} equals")
  }
}

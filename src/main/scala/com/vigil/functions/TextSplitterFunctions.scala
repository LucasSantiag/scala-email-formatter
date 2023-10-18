package com.vigil.functions

import scala.annotation.tailrec

object TextSplitterFunctions {
  /**
   * Generate a new text broken into lines with a maximum limit of characters per line defined.
   * Important note: No words can be broken.
   *
   * @param wordList List of words in the text to be formatted
   * @param charLimit Integer indicating characters count limit in each line of the text.
   * @return Text with limited character per line.
   */
  def splitWithTailRec(wordList: List[String], charLimit: Int = 40): String = {
    @tailrec
    def constructLines(words: List[String], currentLine: List[String], lines: List[String]): List[String] = words match {
      case Nil => lines :+ currentLine.mkString(" ")
      case word :: tail =>
        if (currentLine.mkString(" ").length + 1 + word.length <= charLimit)
          constructLines(tail, currentLine :+ word, lines)
        else
          constructLines(tail, List(word), lines :+ currentLine.mkString(" "))
    }

    constructLines(wordList, List.empty, List.empty).mkString("\n")
  }

  /**
   * Generate a new text broken into lines with a maximum limit of characters per line defined.
   * Important note: No words can be broken.
   *
   * @param wordList  List of words in the text to be formatted
   * @param charLimit Integer indicating characters count limit in each line of the text.
   * @return Text with limited character per line.
   */
  def splitWithFoldLeft(wordList: List[String], charLimit: Int = 40): String = {
    wordList.foldLeft((List.empty[String], 0)) {
      case ((lines, lineCount), word) => {
        if (lineCount + 1 + word.length <= charLimit) {
          lines match {
            case Nil => (lines :+ word, word.length)
            case init :+ last => (init :+ List(last, word).mkString(" "), lineCount + word.length + 1)
          }
        }
        else {
          (lines :+ word, word.length)
        }
      }
    }._1.mkString("\n")
  }

}

package com.vigil.functions

import scala.annotation.tailrec

object TextSplitter {
  def splitWithTailRec(text: String, charLimit: Int = 40): String = {
    @tailrec
    def constructLines(words: List[String], currentLine: List[String], lines: List[String]): List[String] = words match {
      case Nil => lines :+ currentLine.mkString(" ")
      case word :: tail =>
        if (currentLine.mkString(" ").length + 1 + word.length <= charLimit)
          constructLines(tail, currentLine :+ word, lines)
        else
          constructLines(tail, List(word), lines :+ currentLine.mkString(" "))
    }

    val words = text.split("\\s+").toList
    constructLines(words, List.empty, List.empty).mkString("\n")
  }

  def splitWithFoldLeft(text: String, charLimit: Int = 40): String = {
    val words = text.split("\\s+").toList

    words.foldLeft((List.empty[String], 0)) {
      case ((lines, lineCount), word) => {
        if (lineCount + 1 + word.length <= charLimit) {
          lines match {
            case Nil => (lines :+ word, word.length)
            case init :+ last => (init :+ List(last, word).mkString(" "), lineCount + word.length + 1)
            case _ => (lines, lineCount)
          }
        }
        else {
          (lines :+ word, word.length)
        }
      }
    }._1.mkString("\n")
  }

}

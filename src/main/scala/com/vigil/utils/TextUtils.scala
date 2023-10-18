package com.vigil.utils

object TextUtils {
  /**
   * Receives a text and returns the text split to a List.
   *
   * @param text String containing the text to be split.
   * @return List with text split by spaces.
   */
  def textToList(text: String): List[String] =
    text
      .split("\\s+")
      .toList
}

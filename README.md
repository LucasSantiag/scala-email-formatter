# scala-email-formatter

This challenge aims to develop a text formatting plugin to ensure that outgoing emails adhere to a maximum line length of 80 characters, without breaking words. The plugin receives any text and a character limit per line as input and generates a new formatted text broken into lines, respecting the specified character limit.

## Problem Statement
The task is to implement a function that takes the following inputs:

- Text: Any input text that needs to be formatted.
- Character Limit: The maximum number of characters allowed per line.
- No words can be broken

The function should split the input text into lines, ensuring that no line exceeds the specified character limit. It's crucial that no words are broken across lines.

## Implementation Approaches
### Approach 1: Using Tail Recursion (splitWithTailRec)
In the initial implementation, I opted for tail recursion to split the input text into lines. The splitWithTailRec function processes the text, ensuring that lines do not exceed the character limit. Words are grouped together to fit within the line length without breaking them. Tail recursion is advantageous because it optimizes memory usage by reusing the stack frame for each recursive call, leading to efficient memory management.

### Approach 2: Using Fold Left (splitWithFoldLeft)
In the other approach, I utilized the foldLeft higher-order function to achieve the desired formatting. The splitWithFoldLeft function iterates through the words in the input text, accumulating lines, and ensuring that no words are broken across lines, respecting the character limit per line. foldLeft is a powerful functional programming concept that simplifies code and enhances readability.

## Running the Code
You can use the provided ScalaTest tests to verify the correctness of both approaches. These tests cover various scenarios, including normal text, empty input, and input with multiple spaces, ensuring that the text formatting functions work as intended.

To run the tests, make sure you have Scala and ScalaTest installed. Then, execute the tests using your preferred Scala testing tool.

```
$ sbt test
```

The tests will validate that the TextSplitterFunctions and EmailTextUtils objects function correctly and adhere to the specified requirements.

## Todo
- [ ] Implement Email Formatting (Using Case Classes?)
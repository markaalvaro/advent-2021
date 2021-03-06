# :christmas_tree: Advent of Code 2021

This year I'll be solving the [advent problems](https://adventofcode.com/) using Kotlin! :clinking_glasses:

If you're interested in trying out Kotlin for AoC this year or even next, check out [this YouTube video](https://youtu.be/6-XSehwRgSY) from the Kotlin team. They provide helpful tips for Kotlin functions that help with several past AoC problems, instructions for their AoC giveaway, and a GitHub project template to help you get started!

## :spiral_calendar: Days

1. :star::star: (12/01/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day01.kt)
2. :star::star: (12/02/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day02.kt)
3. :star::star: (12/03/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day03.kt)
4. :star::star: (12/04/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day04.kt)
5. :star::star: (12/05/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day05.kt)
6. :star::star: (12/06/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day06.kt)
7. :star::star: (12/07/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day07.kt)
8. :star::star: (12/08/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day08.kt) 
9. :star::star: (12/09/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day09.kt)
10. :star::star: (12/10/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day10.kt)
11. :star::star: (12/11/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day11.kt)
12. :star::star: (12/12/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day12.kt)
13. :star::star: (12/13/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day13.kt)
14. :star::star: (12/14/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day14.kt)
15. :star::star: (12/15/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day15.kt)
16. \-
17. \-

...

## :heart: Community Inspired

After I finish my initial stab at a puzzle, I like to look at other #aoc-2021-in-kotlin repos for inspiration. Lots of times I see solutions that make me think: "Wow! That's cool!" This year I'll be keeping track of my [Favorite Solutions](src/main/kotlin/com/github/markaalvaro/advent2021/CommunityInspired.kt) from the community (with minor changes to meet this project's style).

## :nerd_face: Favorite Kotlin Features

### 1. `windowed(2)`

A function that can be used on `Iterable`s and `Sequence`s to look at rolling windows of values. For example `listOf(1, 2, 3, 4, 5).windowed(2)`, would give us `[[1, 2], [2, 3], [3, 4], [4, 5]]`. You can specify custom window sizes (e.g. window size of 3 to get sub-lists of size 3), and you can specify that you're willing to accept partial windows once you get to the end of the iterable or sequence.

### 2. `count { filter expression }`

Pass in a filter expression as an argument to `count { ... }`, saving the extra line needed by a `filter { ... }` when a COUNT WHERE is needed.

### 3. Multi-line String for Regexes

Use multi-line Strings for regexes to avoid needing to escape `\ `s, which improves regex readability. For example, consider the following greedy whitespace regex (in Java `"\\s+"`):

```kotlin
boardLines.take(5)
    .flatMap { it.split("""\s+""".toRegex()) }
    .map { it.toInt() }
```



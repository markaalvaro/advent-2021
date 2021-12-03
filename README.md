# :christmas_tree: Advent of Code 2021

This year I'll be solving the [advent problems](https://adventofcode.com/) using Kotlin! :clinking_glasses:

If you're interested in trying out Kotlin for AoC this year or even next, check out [this YouTube video](https://youtu.be/6-XSehwRgSY) from the Kotlin team. They provide helpful tips for Kotlin functions that help with several past AoC problems, instructions for their AoC giveaway, and a GitHub project template to help you get started!

## :spiral_calendar: Days

1. :star::star: (12/1/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day01.kt)
2. :star::star: (12/2/2021) [Solution](src/main/kotlin/com/github/markaalvaro/advent2021/Day02.kt)
3. \-
4. \-

...

## :heart: Community Inspired

After I finish my initial stab at a puzzle, I like to look at other #aoc-2021-in-kotlin repos for inspiration. Lots of times I see solutions that make me think: "Wow! That's cool!" This year I'll be keeping track of my [Favorite Solutions](src/main/kotlin/com/github/markaalvaro/advent2021/CommunityInspired.kt) from the community (with minor changes to meet this project's style).

## :nerd_face: Favorite Kotlin Features

### 1. `windowed(2)`

A function that can be used on `Iterable`s and `Sequence`s to look at rolling windows of values. For example `listOf(1, 2, 3, 4, 5).windowed(2)`, would give us `[[1, 2], [2, 3], [3, 4], [4, 5]]`. You can specify custom window sizes (e.g. window size of 3 to get sub-lists of size 3), and you can specify that you're willing to accept partial windows once you get to the end of the iterable or sequence.

### 2. `count { filter expression }`

Pass in a filter expression as an argument to `count { ... }`, saving the extra line needed by a `filter { ... }` when a COUNT WHERE is needed.


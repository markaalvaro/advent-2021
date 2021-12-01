# :christmas_tree: Advent of Code 2021

This year I'll be solving the [advent problems](https://adventofcode.com/) using Kotlin! :clinking_glasses:

## :spiral_calendar: Days

1. :star: :star: (12/1/2021) [Solution](src/main/kotlin/Day01.kt)
2. \-
3. \-
4. \-
5. \-
6. \-
7. \-
8. \-
9. \-
10. \-
11. \-
12. \-
13. \-
14. \-
15. \-
16. \-
17. \-
18. \-
19. \-
20. \-
21. \-
22. \-
23. \-
24. \-
25. \-

## :nerd_face: Favorite Kotlin Features

### 1. `windowed(2)`

A function that can be used on `Iterable`s and `Sequence`s to look at rolling windows of values. For example `listOf(1, 2, 3, 4, 5).windowed(2)`, would give us `[[1, 2], [2, 3], [3, 4], [4, 5]]. You can specify custom window sizes (e.g. 2, 3, 4), and you can specify that you're willing to accept partial windows once you get to the end of the iterable or sequence.

### 2. `count { it[1] > it [0] }`

Pretty cool that we can specify a filter expression as a passed-in argument to `count { ... }`, saving us the extra line needed by a `filter { ... }`.


# Google Code Jam 2015

This repository contains my solutions to the problems from [Google Code Jam 2013][1]. These solutions are provided "as is" - I give no guarantees that they will work as expected.

## Instructions

You can compile all Google Code Jam problems by issuing the following command:

    $ make

If you want to compile only a specific problem, issue the following command, replacing `<problem_id>` with the section and identifier of the problem you want to compile (see section "Problems Solved" for the list of possible identifiers):

    $ make <problem_id>

Running a compiled problem is just a matter of executing a command similar to the next one, replacing `<problem_id>` with the identifier of the desired problem:

    $ ./<problem_id>

Unless stated otherwise, every problem in this repository reads from the standard input and writes to the standard output.

## Problems Solved

The following is the list of the problems solved. Each problem identifier is specified between round brackets. Problems marked with ✓ are done, while problems with ✗ are not complete or aren't efficient enough for the problem's limits.

### Qualification Round

* ✓ [A. Tic-Tac-Toe-Tomek][qualA] (`tic-tac-toe-tomek`)
* ✓ [B. Lawnmower][qualB] (`lawnmower`)
* ✓ [C. Fair and Square][qualC] (`FairAndSquare.scala`)
* ✗ [D. Treasure][qualD] (`Treasure.scala`)

### Round 1B

* ✓ [A. Osmos][round1bA] (`Osmos.scala`)
* ✗ [B. Falling Diamonds][round1bB] (`FallingDiamonds.scala`)

### Round 1C

* ✗ [A. Consonants][round1cA] (`Consonants.scala`)
* ✗ [B. Pogo][round1cB] (`Pogo.scala`)
* ✗ [B. The Great Wall][round1cC] (`TheGreatWall.scala`)

[1]: https://code.google.com/codejam
[2]: http://www.scala-lang.org
[3]: http://www.scala-sbt.org
[qualA]: https://code.google.com/codejam/contest/2270488/dashboard#s=p0
[qualB]: https://code.google.com/codejam/contest/2270488/dashboard#s=p1
[qualC]: https://code.google.com/codejam/contest/2270488/dashboard#s=p2
[qualD]: https://code.google.com/codejam/contest/2270488/dashboard#s=p3
[round1bA]: https://code.google.com/codejam/contest/2434486/dashboard#s=p0
[round1bB]: https://code.google.com/codejam/contest/2434486/dashboard#s=p1
[round1cA]: https://code.google.com/codejam/contest/2437488/dashboard#s=p0
[round1cB]: https://code.google.com/codejam/contest/2437488/dashboard#s=p1
[round1cC]: https://code.google.com/codejam/contest/2437488/dashboard#s=p2

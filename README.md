# Solutions to Google Code Jam 2013 problems

This repository contains solutions to [Google Code Jam 2013][1] problems. These solutions are provided "as is". I give no guarantees that they will work as expected.

## Instructions

The solutions are written in [Scala][2] and are accompanied by a [sbt][3] launch script that allows users to quickly compile and run Scala source code, without the need to have anything installed other than a standard Java compiler. You can run any solution by issuing the following command in the repository root directory:

    $ ./sbt run

A command-line prompt will appear for you to choose the solution to run. Remember that each problem expects its input in a suitable file with an `.in` extension in the repository root directory and outputs its result to a file with an `.out` extension.

## Problems status

Here is a list of the problems currently in this repository. Problems marked with ✓ are done, while problems with ✗ are not complete and/or aren't efficient enough.

### Qualification Round

* ✓ [A. Tic-Tac-Toe-Tomek][qualA] (`TicTacToeTomek.scala`)
* ✓ [B. Lawnmower][qualB] (`Lawnmower.scala`)
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

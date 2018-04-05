#include <algorithm>
#include <cstdio>
#include <cstring>

using namespace std;

char grid[4][5];

int points[2][10];

void addPoints(int p, int i, int j) {
  points[p][i]++;
  points[p][4 + j]++;
  if(i == j) points[p][8]++;
  if(i == 4 - j - 1) points[p][9]++;
}

int main() {
  int t; scanf("%d\n", &t);
  for(int tc = 1; tc <= t; tc++) {
    for (auto& row : grid) {
      scanf("%s", row);
    }

    memset(points, 0, sizeof(points));
    int filled = 0;
    for(int i = 0; i < 4; i++) {
      for(int j = 0; j < 4; j++) {
        if(grid[i][j] != '.') filled++;
        if(grid[i][j] == 'X' || grid[i][j] == 'T') addPoints(0, i, j);
        if(grid[i][j] == 'O' || grid[i][j] == 'T') addPoints(1, i, j);
      }
    }

    auto res =
      find(points[0], points[0] + 10, 4) != points[0] + 10 ? "X won" :
      find(points[1], points[1] + 10, 4) != points[1] + 10 ? "O won" :
      filled == 16 ? "Draw" :
      "Game has not completed";

    printf("Case #%d: %s\n", tc, res);
  }
  return 0;
}

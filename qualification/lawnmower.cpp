#include <cstdio>
#include <cstring>
#include <iostream>

#define MAXN 100
#define MAXM 100

using namespace std;

int grid[MAXN][MAXM];

int row[MAXN], col[MAXM];

int main() {
  int t; scanf("%d\n", &t);
  for(int tc = 1; tc <= t; tc++) {
    int n, m; scanf("%d %d\n", &n, &m);
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < m; j++) {
        scanf("%d", &grid[i][j]);
      }
    }

    bool valid = true;
    for(int k = 1; k < 100 && valid; k++) {
      memset(row, 0, sizeof(row));
      memset(col, 0, sizeof(col));

      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          if(grid[i][j] == k) { row[i]++; col[j]++; }
        }
      }
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
          if(grid[i][j] == k) {
            if (row[i] != m && col[j] != n) valid = false;
            grid[i][j]++;
          }
        }
      }
    }
    printf("Case #%d: %s\n", tc, valid ? "YES" : "NO");
  }
  return 0;
}

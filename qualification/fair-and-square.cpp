#include <algorithm>
#include <cstdio>
#include <iostream>
#include <string>
#include <vector>

#define MAXBP 101

using namespace std;

vector<string> numbers;

string pow2(string& n) {
  string res(MAXBP, '0');
  for(int i = 0; i < n.length(); i++) {
    for(int j = 0; j < n.length(); j++) {
      int digit = MAXBP - (int) (n.length() * 2 - 1) + i + j;
      res[digit] =
        char((res[digit] - '0') + int(n[j] - '0') * int(n[i] - '0')) + '0';
    }
  }
  return res;
}

void dfs(string curr, int left, int target, int sqSum) {
  if(left == 0) {
    string rhalf = curr;
    if(target % 2 == 1) rhalf.pop_back();
    curr.append(rhalf.rbegin(), rhalf.rend());
    numbers.push_back(pow2(curr));
    return;
  }
  int factor = target % 2 == 1 && left == 1 ? 1 : 2;
  if(!curr.empty()) dfs(curr + '0', left - 1, target, sqSum);
  if(sqSum >= factor) dfs(curr + '1', left - 1, target, sqSum - factor);
  if(sqSum >= factor * 4) dfs(curr + '2', left - 1, target, sqSum - factor * 4);
  if(sqSum >= factor * 9) dfs(curr + '3', left - 1, target, sqSum - factor * 9);
}

int main() {
  for(int k = 1; k <= MAXBP / 2; k++)
    dfs("", (k + 1) / 2, k, 9);

  int t; scanf("%d\n", &t);
  for(int tc = 1; tc <= t; tc++) {
    string a, b; cin >> a >> b;
    a.insert(0, MAXBP - a.length(), '0');
    b.insert(0, MAXBP - b.length(), '0');

    auto it1 = lower_bound(numbers.begin(), numbers.end(), a);
    auto it2 = upper_bound(numbers.begin(), numbers.end(), b);
    printf("Case #%d: %d\n", tc, (int) (it2 - it1));
  }
  return 0;
}

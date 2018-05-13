#include <cstdio>
#include <cstring>

typedef long long ll;

int n; ll p;

ll worstPlace(ll k) {
  ll batch = 1, curr = 0, rank = 1LL << n;
  while(k > curr) { rank >>= 1; batch <<= 1; curr += batch; }
  return (1LL << n) - rank;
}

ll bestPlace(ll k) {
  ll batch = 1, curr = (1LL << n) - 1, rank = 1LL << n;
  while(k < curr) { rank >>= 1; batch <<= 1; curr -= batch; }
  return rank - 1;
}

int main() {
  int t; scanf("%d\n", &t);
  for(int tc = 1; tc <= t; tc++) {
    scanf("%d %lld\n", &n, &p);

    ll minK1 = 0, maxK1 = (1LL << n) - 1;
    while(minK1 < maxK1) {
      ll mid = (maxK1 + minK1 + 1) / 2;
      if(worstPlace(mid) < p) minK1 = mid;
      else maxK1 = mid - 1;
    }
    ll minK2 = 0, maxK2 = (1LL << n) - 1;
    while(minK2 < maxK2) {
      ll mid = (maxK2 + minK2 + 1) / 2;
      if(bestPlace(mid) < p) minK2 = mid;
      else maxK2 = mid - 1;
    }
    printf("Case #%d: %lld %lld\n", tc, minK1, minK2);
  }
  return 0;
}

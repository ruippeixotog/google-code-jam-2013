#include <algorithm>
#include <cstdio>
#include <map>
#include <stack>

#define MOD 1000002013

using namespace std;

typedef long long ll;

inline ll mmul(ll a, ll b) { return (a * b) % MOD; }
inline ll madd(ll a, ll b) { return (a + b) % MOD; }
inline ll msub(ll a, ll b) { return (a + MOD - b) % MOD; }

int n;

map<int, pair<ll, ll>> events;

ll cost(ll from, ll to, ll k) {
  return mmul(k, (to - from) * (2 * n - (to - from - 1)) / 2 % MOD);
}

int main() {
  int t; scanf("%d\n", &t);
  for(int tc = 1; tc <= t; tc++) {
    int m; scanf("%d %d\n", &n, &m);

    ll trueCost = 0;
    events.clear();
    for(int i = 0; i < m; i++) {
      int o, e, p; scanf("%d %d %d\n", &o, &e, &p);
      events[o].first += p;
      events[e].second += p;
      trueCost = madd(trueCost, cost(o, e, p));
    }

    ll cheatCost = 0;
    stack<pair<int, ll>> st;
    for(auto& ev : events) {
      if(ev.second.first) {
        st.push({ ev.first, ev.second.first });
      }
      while(ev.second.second) {
        ll toProcess = min(st.top().second, ev.second.second);
        cheatCost = madd(cheatCost, cost(st.top().first, ev.first, toProcess));

        ev.second.second -= toProcess;
        st.top().second -= toProcess;
        if(!st.top().second) st.pop();
      }
    }
    printf("Case #%d: %lld\n", tc, msub(trueCost, cheatCost));
  }
  return 0;
}

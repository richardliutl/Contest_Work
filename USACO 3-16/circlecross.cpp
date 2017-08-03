#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

int main() {
    ofstream fout ("circlecross.out");
    ifstream fin ("circlecross.in");
    int n, k, t, t0;
    k = 0;
    t = 0;
    int p[100000];
    int u[50001];
    int r0[50001];
    int r1[50001];
    fin >> n;
    for(int i=1; i<=n; i++) {
      r0[i] = -1;
    }
    for(int i=0; i<2*n; i++) {
      fin >> p[i];
      if(r0[p[i]] == -1) {
        r0[p[i]] = k;
        k++;
      } else {
        k--;
        r1[p[i]] = k;
      }
    }
    for(int i=1; i<=n; i++) {
      t += min(abs(6 - r0[i] - r1[i]),abs(r0[i] + r1[i]));
    }
    fout << t/2 << endl;
    return 0;
}
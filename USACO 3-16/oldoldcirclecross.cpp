#include <iostream>
#include <fstream>

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
        r0[p[i]] = i;
      } else {
        r1[p[i]] = i;
      }
    }
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=n; j++) {
        u[j] = -1;
      }
      t0 = 0;
      for(int k=r0[i]+1; k<r1[i]; k++) {
        if(u[p[k]] == -1) {
            u[p[k]] = 1;
            t0 ++;
        } else {
            u[p[k]] = -1;
            t0--;
        }
      }
      t += t0;
    }
    fout << t/2 << endl;
    return 0;
}
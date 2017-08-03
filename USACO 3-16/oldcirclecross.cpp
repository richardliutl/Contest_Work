#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ofstream fout ("circlecross.out");
    ifstream fin ("circlecross.in");
    int n, k, t;
    u = 0;
    t = 0;
    int p[100000];
    int u[100000];
    int a[50000];
    fin >> n;
    for(int i=1; i<=n; i++) {
      a[i] = -1;
    }
    for(int i=0; i<2*n; i++) {
      fin >> p[i];
      if(a[p[i]] == -1) {
        a[p[i]] = k;
        k++;
      } else {
        k--;
        k += (k - a[p[i]])/2;
        t += k - a[p[i]];
        a[p[i]] = -1;
      }
    }
    fout << t << endl;
    return 0;
}
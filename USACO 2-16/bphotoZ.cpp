/*
ID: rtliu
PROG: bphoto
LANG: C++11
*/
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main() {
    ofstream fout ("bphoto.out");
    ifstream fin ("bphoto.in");
    int n, t;
    bool C[1000][1000]; // too small
    int h[100000];
    fin >> n;
    
    for(int i=0; i<n; i++) {
      fin >> h[i];
      for(int j=0; j<i; j++) {
        if(h[j]<h[i]) {
          C[i][j] = false;
          C[j][i] = true;
        } else {
          C[i][j] = true;
          C[j][i] = false;
        }
      }
    }
    t = 0;
    for(int i=0; i<n; i++) {
      int R, L;
      R = 0; L = 0;
      for(int j=0; j<n; j++) {
        if(j<i && C[i][j]) L++;
        if(j>i && C[i][j]) R++;
      }
      if(R > 2*L || L > 2*R) t++;
    }
    // for(int i=0; i<n; i++) {
    //   for(int j=0; j<n; j++) {
    //     fout << C[i][j] << " ";
    //   }
    //   fout << endl;
    // }
    fout << t << endl;
    return 0;
}
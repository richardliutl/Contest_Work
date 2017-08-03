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
    int C[100000][2]; // L R
    int h[100000];
    fin >> n;
    
    for(int i=0; i<n; i++) {
      fin >> h[i];
      for(int j=0; j<i; j++) {
        if(h[j]<h[i]) {
          C[j][1] ++;
        } else {
          C[i][0] ++;
        }
      }
    }
    t = 0;
    for(int i=0; i<n; i++) {
      if(C[i][0] > 2*C[i][1] || C[i][1] > 2*C[i][0]) t++;
    }
    // for(int i=0; i<n; i++) {
    //   for(int j=0; j<2; j++) {
    //     fout << C[i][j] << " ";
    //   }
    //   fout << endl;
    // }
    fout << t << endl;
    return 0;
}
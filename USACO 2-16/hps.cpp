/*
ID: rtliu
PROG: hps
LANG: C++11
*/
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int movetoint(string s) {
  if(s == "H") return 0;
  if(s == "P") return 1;
  return 2;
}

int main() {
    ofstream fout ("hps.out");
    ifstream fin ("hps.in");
    int n, k, l, j; //N, K, temp length, temp move, temp C index
    string r;
    int C[100000][2]; //move list
    fin >> n >> k >> r;
    l = 1; j = 0;
    
    for(int i=0; i<n; i++) {
      string tp;
      fin >> tp;
      if(tp == r) {
        l++;
      } else {
        C[j][0] = movetoint(r);
        C[j][1] = l;
        j++;
        r = tp;
        l = 1;
      }
    }
    for(int i=0; i<j; i++) {
      fout << C[i][0] << " " << C[i][1] << endl;
    }

    int kk, g;
    kk = j-1; g = n;

    // for(int i=0; i<n; i++) {
    //   for(int j=0; j<2; j++) {
    //     fout << C[i][j] << " ";
    //   }
    //   fout << endl;
    // }
    fout << kk << " " << g << endl;
    return 0;
}
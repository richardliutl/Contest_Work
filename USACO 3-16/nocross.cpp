#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

int main() {
    ofstream fout ("nocross.out");
    ifstream fin ("nocross.in");
    int n;
    int r0[1000];
    int r1[1000];
    int dp[1000][1001];
    fin >> n;
    for(int i=0; i<n; i++) {
        fin >> r0[i];
    }
    for(int i=0; i<n; i++) {
        fin >> r1[i];
    }
    for(int a=n-1; a>=0; a--) {
        for(int b=n; b>=0; b--) {
            if(a==n-1) {
                if(b==n) dp[a][b] = 0;
                else {
                    dp[a][b] = dp[a][b+1];
                    if(abs(r0[a]-r1[b]) <= 4) dp[a][b] = 1;
                }
            } else {
                if(b==n) dp[a][b] = 0;
                else {
                    dp[a][b] = max(dp[a][b+1],dp[a+1][b]);
                    if(abs(r0[a]-r1[b]) <= 4) dp[a][b] = dp[a+1][b+1] + 1;
                }
            }
        }
    }
    fout << dp[0][0] << endl;
    return 0;
}
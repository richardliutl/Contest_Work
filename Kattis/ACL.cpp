#include <iostream>
#include <iomanip>
#include <cmath>
#include <algorithm>

using namespace std;

const int sec = 1296000;

int main() {
	int n, e, c, t, tp;
	cin >> n;
	for(int n0=0; n0<n; n0++) {
		cin >> e >> c;
		t = 0;
		for(int c0=0; c0<c; c++) {
			cin >> tp;
			t += tp/2;
		}
		cout << t;
		cout << max(0, 80-t);
	}
}
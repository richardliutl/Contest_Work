#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int n, e, c, t, tp;
	cin >> n;
	for(int n0=0; n0<n; n0++) {
		cin >> e >> c;
		t = 0;
		for(int c0=0; c0<c; c0++) {
			cin >> tp;
			t += tp/e;
		}
		cout << max(0, 80-t) << endl;
	}
	return 0;
}
#include <iostream>

using namespace std;

int main() {
	int n, m, g, a, b;
	bool p;
	p = true;
	g = 1;
	cin >> n >> m;
	int f[10000][3] = {0};
	int t[10000] = {0};
	for(int i=0; i<n; i++) {
		cin >> f[i][1];
	}
	for(int i=0; i<m; i++) {
		cin >> a >> b;
		if(f[a][0] == f[b][0] && f[a][0] == 0) {
			f[a][0] = g;
			f[b][0] = g;
			f[g][2] = g;
			g++;
		} else if(f[a][0] > 0 && f[b][0] > 0) {
			if(f[a][0] < f[b][0]) {
				f[f[b][0]][2] = f[f[a][0]][2];
			} else {
				f[f[a][0]][2] = f[f[b][0]][2];
			}
		} else if(f[a][0] == 0) {
			f[a][0] = f[b][0];
		} else {
			f[b][0] = f[a][0];
		}
	}
	for(int i=0; i<n; i++) {
		t[f[f[i][0]][2]] += f[i][1];
	}
	for(int i=0; i<g; i++) {
		if(t[i] != 0) p = false;
	}
	if(p) {
		cout << "POSSIBLE" << endl;
	} else {
		cout << "IMPOSSIBLE" << endl;
	}
}
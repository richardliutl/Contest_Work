#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n, aa, bb, s;
	s = 0;
	cin >> n;
	
	vector<int> a;
	vector<int> b;
	for(int c=0; c<n; c++) {
		cin >> aa >> bb;
		a.push_back(aa);
		b.push_back(bb);
	}
	sort(a.begin(), a.end());
	sort(b.begin(), b.end());
	for(int i=1; i<=n; i++) {
		s += abs(a[i-1]-i) + abs(b[i-1]-i);
	}
	cout << s << endl;
}
#include <algorithm>
#include <fstream>

using namespace std;

int main() {
	ofstream fout ("p18_max_path_sum_I.out");
	ifstream fin ("p18_max_path_sum_I.in");
	int a[15];
	int b[15];
	int n;
	for(int i=1; i<=15; i++) {
		if(i == 1) {
			fin >> a[0];
		} else {
			for(int j=0; j<i; j++) {
				if(j==0 || j==i-1) {
					fin >> b[j];
					if(j==0) {
						b[j] += a[j];
					} else {
						b[j] += a[j-1];
					}
					fout << b[j] << " ";
				} else {
					fin >> b[j];
					b[j] += max(a[j-1], a[j]);
					fout << b[j] << " ";
				}
			}
			for(int j=0; j<i; j++) {
				a[j] = b[j];
			}
		}
		fout << endl;
		if(i == 15) {
			n = a[0];
			for(int j=1; j<15; j++) {
				n = max(n, a[j]);
			}
		}
	}
	fout << n << endl;
}
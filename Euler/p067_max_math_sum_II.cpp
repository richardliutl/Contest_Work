#include <algorithm>
#include <fstream>

using namespace std;

int main() {
	ofstream fout ("p67_max_path_sum_II.out");
	ifstream fin ("p67_max_path_sum_II.in");
	int a[100];
	int b[100];
	int n;
	for(int i=1; i<=100; i++) {
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
		if(i == 100) {
			n = a[0];
			for(int j=1; j<100; j++) {
				n = max(n, a[j]);
			}
		}
	}
	fout << n << endl;
}
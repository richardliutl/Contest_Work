#include <iostream>
#include <iomanip>
#include <cmath>


using namespace std;

const int sec = 1296000;

unsigned GCD(unsigned u, unsigned v) {
    while ( v != 0) {
        unsigned r = u % v;
        u = v;
        v = r;
    }
    return u;
}

int main() {
	const long double pi = 3.141592653589;
	setprecision(13);
	int cc, r, n, d, m, s, ds, i, large, tp, g;
	long double a;
	bool l[sec];
	cin >> cc;
	
	for(int c=0; c<cc; c++) {
		cin >> r >> n >> d >> m >> s;
		ds = s + 60*m + 3600*d;
		g = GCD(ds,sec);
		if(sec % ds == 0) {
			if((long long)n*ds >= sec) {
				cout << setprecision(13) << (long double)pi*r*r*ds/sec << endl;
			} else {
				cout << setprecision(13) << (long double)pi*r*r*(sec + ds - ds*n)/sec << endl;
			}
		} else if(n >= sec/g) {
			cout << setprecision(13) << (long double)pi*r*r*g/sec << endl;
		} else {
		for(int se=0; se<sec; se++) {
			l[se] = false;
		}
		i = 0;
		for(int k=0; k<n; k++) {
			if(l[i]) break;
			l[i] = true;
			i = (i + ds) % sec;
		}
		large = 0;
		tp = 0;
		for(int se=0; se<sec; se++) {
			if(l[se]) {
				if(tp > large) {
					large = tp + 1;
				}
				tp = 0;
			} else {
				tp++;
			}
		}
		if(l[0]) {
			if(tp > large) {
				large = tp + 1;
			}
			tp = 0;
		}
		cout << setprecision(13) << (long double)pi*r*r*large/sec << endl;
		}
	}
}
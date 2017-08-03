/*
ID: rtliu
PROG: lasers
LANG: C++11
*/
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

struct line
{
	int d, l, m; //0,1 = horizontal, vertical ; l = distance from 0,0 ; m = # mirrors to line
	line(int dd, int ll, int mm) : d(dd), l(ll), m(mm) {}
};

int main() {
    ofstream fout ("lasers.out");
    ifstream fin ("lasers.in");
    vector<line> h, v;
    int n;
    int L[2], B[2];
    fin >> n >> L[0] >> L[1] >> B[0] >> B[1];
    v.push_back(line(1,L[0],0));
    h.push_back(line(0,L[1],0));
    int coors[n][2];
    vector<line> toCheck;
    for(int i=0; i<n; i++) {
    	fin >> coors[i][0] >> coors[i][1];
    	if(coors[i][0] == L[0]) {
    		h.push_back(line(0,coors[i][1],1));
    		toCheck.push_back(line(0,coors[i][1],1));
    	} else if(coors[i][1] == L[1]) {
    		v.push_back(line(1,coors[i][0],1));
    		toCheck.push_back(line(1,coors[i][0],1));
    	}
    }
    bool barn = false;
    int m = -1;
    if(L[0] == B[0] || L[1] == B[1]) {
		barn = true;
		m = 0;
	}
	vector<line>::iterator tline = toCheck.begin();
	while(!barn && tline != toCheck.end()) {
		if((*tline).d == 1) {
			if((*tline).l == B[0]) {
				barn = true;
				//m = v[(*tline).l];
				m = (*tline).m;
			} else {
				for(int i=0; i<n; i++) {
					if(coors[i][0] == (*tline).l /*&& h[coors[i][1]] == -1*/) {
						//h[coors[i][1]] = v[(*tline).l] + 1;
						toCheck.push_back(line(0,coors[i][1],(*tline).m + 1));
					}
				}
			}
		} else if((*tline).d == 0) {
			if((*tline).l == B[1]) {
				barn = true;
				//m = h[(*tline).l];
				m = (*tline).m;
			} else {
				for(int i=0; i<n; i++) {
					if(coors[i][1] == (*tline).l /*&& v[coors[i][0]] == -1*/) {
						//v[coors[i][0]] = h[(*tline).l] + 1;
						toCheck.push_back(line(1,coors[i][0],(*tline).m + 1));
					}
				}
			}
		}
		tline++;
	}
    fout << m << endl;
    return 0;
}
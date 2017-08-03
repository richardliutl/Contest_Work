#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    //string o;
    while(n != 0) {
    	int low = 0;
    	int high = -1;
    	int mult = 1;
    	for(int i=0; i<n; i++) {
    		string s;
    		getline(cin, s);
    		//string a,b,c;
	    	//cin >> a >> b >> c;	
	    	// if(a.at(0) == 'l') {
	    	// 	//high = stoi(c);
	    	// } else if(a.at(0) == 'g') {
	    	// 	//low = stoi(c);
	    	// } else if(a.at(0) == 'd') {
	    	// 	//mult = mult * stoi(c);
	    	// }
	    	cout << s[0] << "\n";
    	}
    	//cout << low << " " << high << " " << mult << "\n";
    	cin >> n;
    }
    //cout << o;
    return 0;
}
#include <iostream>

using namespace std;

int main() {
    int n; // num cards
    cin >> n;
    int p = -1; // parity of stack beginning
    int l = 0; // length of stack
    
    int curr; // current card parity
    for(int i=0; i<n; i++) {
      cin >> curr;
      curr %= 2;
      if(l == 0) {
        l = 1;
        p = curr;
      } else {
        if((l + p - 1) % 2 == curr) {
          l--;
          p == 1 - p;
          if(l == 0) p = -1;
        } else {
          l++;
          p == 1 - p;
        }
      }
    }
    cout << l << endl;
    return 0;
}
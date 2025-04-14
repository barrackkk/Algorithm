#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n;
    cin >> n;
    int cnt = 0;
    int tmp;
    int sum;
    for(int i = 0 ; i < n ; i++){
        sum = i;
        tmp = i;

        while(tmp){
            sum += tmp % 10;
            tmp = tmp / 10;
        }

        if(n == sum){
            cout << i;
            return 0;
        }
    }

    cout << "0";
}

#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int n, a;

int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(NULL);
	
	cin >> n;
	for(int i = 0 ; i < n ; i++){
		int ret2 = 0 , ret5 = 0;
		cin >> a;
		for(int j = 2 ; j <= a; j*= 2){
			ret2 += a/ j;
		}
		for(int j =5 ; j <= a; j *= 5){
			ret5+= a / j;
		}
		cout << min(ret2, ret5) << '\n';
	}

	return 0;
}
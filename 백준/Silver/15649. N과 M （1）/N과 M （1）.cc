#include <iostream>
#include <vector>
#include <cmath>
#include <math.h>
#include <string>
#include <algorithm>
#include <utility>
using namespace std;
typedef long long ll;

int N,M;

void go(vector<int> a){ //& == reference
   if(a.size() ==M){
        for(int x:a) cout << x << ' ';
        cout << '\n';
        return;
   }

   for(int i = 1 ; i <= N ; i++){
        bool in = 0;
        for(int x:a){
            if(x==i){
                in = 1;
                break;
            }
        }
        if(in) continue;

        a.push_back(i);
        go(a);
        a.pop_back();
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    cin >> N >> M;
    vector<int>a;

    go(a);
    return 0;
}
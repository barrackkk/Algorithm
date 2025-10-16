#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);   
    cin.tie(0); cout.tie(0);

    int N, a;
    cin >> N;
    vector<int> v;
    vector<char> v1;

    for(int i = 0, j = 1; i< N ; i++){
        cin >> a;
        while(j <= a){
            v.push_back(j);
            j += 1;
            v1.push_back('+');
        }

        if(v.back() == a){
            v.pop_back();
            v1.push_back('-');
        }
        else{
            cout << "NO";
            return 0;
        }
    }

    for(int i = 0 ; i < v1.size(); i++)
        cout << v1[i] << '\n';

    return 0;
}
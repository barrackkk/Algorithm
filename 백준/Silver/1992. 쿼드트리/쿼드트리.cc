#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
int n;
char arr[68][68];
string s;

string quard(int y, int x , int size){
    if(size == 1) return string(1, arr[y][x]);
    string str = "";
    char b = arr[y][x];
    for(int i = y ; i < y + size ; i++){
        for(int j = x ; j < x + size ; j++){
            if(b!= arr[i][j]){
                str += '(';
                str += quard(y, x , size/2);
                str += quard(y, x + size /2 , size/2);
                str += quard(y + size / 2, x , size/2);
                str += quard(y + size / 2, x + size / 2 , size/2);
                str += ')';
                return str;
            }
        }
    }
    return string(1, arr[y][x]);
}

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(NULL);

    cin >> n;
    
    for(int i = 0; i < n; i++){
        cin >> s; 
        for(int j = 0; j < n; j++){
            arr[i][j] = s[j];
        }
    }
    

    cout << quard(0,0,n) << '\n';
    return 0;
}
#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <string.h>
#include <queue>
using namespace std;

int N, K;
queue<int>q;

int main(){
    ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);
    
    cin >> N >> K;
	for (int i = 1; i <= N; i++)
		q.push(i);
        
	cout << "<";
	while (q.size()!=0)
	{
		for (int i = 1; i < K; i++)
		{
			q.push(q.front());
			q.pop();		
		}
		cout << q.front();	
		if (q.size() != 1)
			cout << ", ";
		q.pop();		
	}
	cout << ">";
	return 0;
}
using namespace std;
#include <bits/stdc++.h>

ifstream infile("P1.txt");
int main(){
	vector<int> l1;
	map<int,int> l2;
	int a, b;
	while (infile >> a >> b)
	{
		l1.push_back(a);
		l2[b]++;
		// process pair (a,b)
	}
	int total = 0;
	for(int i = 0;i<l1.size();i++){
			total += l1[i] * l2[l1[i]];
	}
	cout << total;
}

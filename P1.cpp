using namespace std;
#include <bits/stdc++.h>

ifstream infile("P1.txt");
int main(){
	vector<int> l1;
	vector<int> l2;
	int a, b;
	while (infile >> a >> b)
	{
		l1.push_back(a);
		l2.push_back(b);
		// process pair (a,b)
	}
	sort(l1.begin(), l1.end());
	sort(l2.begin(), l2.end());
	int total = 0;
	for(int i = 0;i<l1.size();i++){
			total += abs(l1[i] - l2[i]);
	}
	cout << total;
}

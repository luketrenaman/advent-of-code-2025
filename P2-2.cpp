
using namespace std;
#include <bits/stdc++.h>

ifstream infile("P2.txt");
std::string line;
bool isSafe(int a, int b){
	int diff = abs(b-a);
	return diff >= 1 && diff <= 3;
}
int main(){
	int safeReports = 0;
	while (std::getline(infile, line))
	{
		cout << "processing report: " << line << '\n';
		int safe = 1;
		std::istringstream iss(line);
		int prev, current;
		iss >> prev;
		iss >> current;
		bool decreasing = false;
		if(prev < current) decreasing = false;
		else if(prev > current) decreasing = true;
		else if(prev==current){
			// Unsafe but we continue processing anyways
			safe--;
		}
		else if(!isSafe(prev,current)) safe--;
		while(!iss.eof()){
			prev = current;
			iss >> current;
			if(!isSafe(prev,current)) safe--;
			else if(prev == current) safe--;
			else if(prev < current && decreasing) safe--;
			else if(prev > current && !decreasing) safe--;
		}
		if(safe >= 0){
			 safeReports++;
			 cout << "Safe\n";
		} else{
			cout << "Unsafe\n";
		}
	}
	cout << safeReports;
}

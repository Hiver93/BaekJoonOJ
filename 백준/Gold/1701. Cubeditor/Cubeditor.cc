#include <iostream>
#include <vector>
using namespace std;

int ans = 0;


// 시작점마다 한번씩 만들어야함
void func(string str, int start) {
	int i = start+1;
	int j = start;
	vector<int> arr(str.length());
	arr[j] = start;

	while (i < str.size()) {
		if (str[i] == str[j]) {
			j++;
			arr[i] = j;
			if (ans < arr[i] - start) {
				ans = arr[i] - start;
			}
			i++;
		}
		else if (start < j) {
			j = arr[j-1];
		}
		else {
			arr[i] = start;
			i++;
		}
	}
}

int main() {
	string input;
	cin >> input;

	for (int i = 0; i < input.length(); ++i) {
		func(input, i);
	}
	cout << ans;
}
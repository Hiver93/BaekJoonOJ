#include <iostream>
#include <stack>
using namespace std;
int cnt[1000000]{ 0 };
int ans[1000000]{ 0 };
int arr[1000000]{ 0 };
int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	stack<int> s;	
	cin >> n;
	for (int i = 0; i < n; ++i) {
		int tmp;
		cin >> tmp;
		arr[i] = tmp;
		cnt[tmp]++;
	}
	for (int i = 0; i < n; ++i) {
		while (s.size() && cnt[arr[s.top()]] < cnt[arr[i]]) {
			ans[s.top()] = arr[i];
			s.pop();
		}
		s.push(i);
	}
	for (int i = 0; i < n; ++i) {
		cout << (ans[i] ? ans[i] : -1) << ' ';
	}

}
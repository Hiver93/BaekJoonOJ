#include <iostream>
using namespace std;

int main() {
	int n, k;
	int ans = 0;
	cin >> n >> k;

	pair<int, int> input[100];
	int memo[100001]{ 0 };
	for (int i = 0; i < n; ++i) {
		cin >> input[i].first;
		cin >> input[i].second;
	}

	for (int i = 0; i < n; ++i) {
		int w = input[i].first;
		int v = input[i].second;
		if (memo[w]) {
			if (w + w <= k && memo[w + w] < memo[w] + v)
				memo[w + w] = memo[w] + v;
		}
		if(memo[w] < v) {
			memo[w] = v;
		}
		for (int j = k - w; j > 0; --j) {
			if (!memo[j] || j == w)
				continue;
			if (memo[j + w] < memo[j] + v) {
				memo[j + w] = memo[j] + v;
			}
		}
	}

	for (int i = 0; i <= k; ++i) {
		if (ans < memo[i])
			ans = memo[i];
	}
	cout << ans << endl;
}
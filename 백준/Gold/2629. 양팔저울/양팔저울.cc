#include <iostream>
using namespace std;
int arr[300]{ 0 };
int memo[200000]{ 0 };

int ex[200000]{ 0 };
int idx = 0;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, t;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
	}
	for (int i = 0; i < n; ++i) {
		memo[arr[i]]++;
		if (memo[arr[i]] == 1) {
			ex[idx++] = arr[i];
		}
		int m = idx;
		for (int j = 0; j < m; ++j) {
			if (ex[j] == arr[i] && memo[arr[i]] == 1)
				continue;
			memo[ex[j] + arr[i]]++;
			if (memo[ex[j] + arr[i]] == 1) {
				ex[idx++] = ex[j] + arr[i];
			}
		}
	}
	memo[0] = 2;
	ex[idx++] = 0;
	cin >> t;
	while (t--) {
		bool finded = 0;
		int target;
		cin >> target;
		for (int i = 0; i < idx; ++i) {
			int tmp = target + ex[i];
			memo[ex[i]]--;
			for (int j = 0; j < idx; ++j) {
				if (!memo[ex[j]])
					continue;
				if (tmp == ex[j]) {
					finded = 1;
					break;
				}
			}
			memo[ex[i]]++;
			if (finded) {
				break;
			}
		}


		if (finded) {
			cout << "Y ";
		}
		else {
			cout << "N ";
		}
	}
}
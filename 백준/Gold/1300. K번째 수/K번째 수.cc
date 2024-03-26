#include <iostream>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	long long n, k, ans;
	cin >> n >> k;

	long long left = 1, right = n * n;
	while (left <= right) {
		long long mid = (left + right) / 2;
		long long cnt = 0;
		for (int i = 1; i <= n && i <= k; ++i) {
			cnt += ((mid / i) < n) ? (mid / i) : n;
		}

		if (cnt < k) {
			left = mid+1;
		}
		else {
			ans = mid;
			right = mid-1;
		}
	}


	cout << ans;
}
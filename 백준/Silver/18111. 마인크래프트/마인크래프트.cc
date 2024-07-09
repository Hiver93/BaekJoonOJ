#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	int n, m, bag, time = 2147483647, h = 0;
	cin >> n >> m >> bag;
	int* arr = new int[n * m];
	for (int i = 0; i < n * m; ++i) {
		cin >> arr[i];
	}

	sort(arr, arr + n * m);
	for (int i = 0; i <= 256; ++i) {
		int cnt = 0;
		int j = n * m - 1;
		int p = bag;
		for (; j >= 0; --j) {
			int cur = arr[j];
			int d = i - cur;
			if (d < 0) {
				cnt += -(d * 2);
				p += -d;
			}
			else if (0 < d) {
				if (p < d) {
					break;
				}
				cnt += d;
				p -= d;
			}
		}
		if (j == -1 && cnt <= time) {
			time = cnt;
			h = i;
		}
	}
	cout << time << ' ' << h;
}
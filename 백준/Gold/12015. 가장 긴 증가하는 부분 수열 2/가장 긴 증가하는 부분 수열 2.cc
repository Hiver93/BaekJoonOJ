#include <iostream>
using namespace std;
int arr[1000000]{ 0 };
int idx = 0;
int n, r;

void _find(int left, int right, int target) {
	if (right < left) {
		return;
	}
	int mid = (left + right) / 2;
	if (arr[mid] < target) {
		_find(mid + 1, right, target);
	}
	else {
		r = mid;
		_find(left, mid - 1, target);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		if (arr[i] <= arr[0]) {
			arr[0] = arr[i];
		}
		else if (arr[idx] < arr[i]) {
			arr[++idx] = arr[i];
		}
		else {
			_find(0, idx, arr[i]);
			arr[r] = arr[i];
		}		
	}
	cout << idx + 1;
}
#include <iostream>
#include <algorithm>
using namespace std;

// 집, 집들의 거리, 집 수, 기계수
int houses[200000]{ 0 };
int arr[200000]{ 0 };
int n , c;

// num의 거리로 몇개가 나오는지 센다
int checkCount(int num) {
	int count = 0;
	int acc = 0;
	for (int i = 0; i < n; ++i) {
		acc += arr[i];
		if (num <= acc) {
			count++;
			acc = 0;
		}
	}
	return count;
}

int main()
{
	ios::sync_with_stdio(0);
	cout.tie(0);
	cin.tie(0);
	cin >> n >> c;

	for (int i = 0; i < n; ++i) {
		cin >> houses[i];
	}
	sort(houses, houses + n);
	for (int i = 1; i < n; ++i) {
		arr[i - 1] = houses[i] - houses[i - 1];
	}
	int st = 0, ed = houses[n-1], mid;
	int ans;

	// 이분탐색으로 적정값을 구한다
	while (st <= ed) {
		mid = (st + ed) / 2;
		int count = checkCount(mid);
		if (count < c-1) {
			ed = mid - 1;
		}
		else {
			ans = mid;
			st = mid + 1;
		}
	}
	cout << ans;

}
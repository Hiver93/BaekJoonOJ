#include <iostream>
using namespace std;
long long n, m;
long long hMax = 0;
long long ans = 0;
long long arr[1000000]{ 0 };


// 이분 탐색
void func(int st, int ed) {
	if (ed < st)
		return;
	long long v = 0;

	// 절반값
	long long mid = (st + ed) / 2;
	// 절반의 위치를 베어냈을 때의 값을 구한다
	for (int i = 0; i < n; ++i) {
		v += (arr[i] - mid < 0 ? 0 : arr[i] - mid);
	}

	// 낮을 때
	if (v < m) {
		if (st == mid)
			return;
		func(st, mid);
	}
	// 높거나 같을 때
	else {
		if (ans < mid)
			ans = mid;
		func(mid + 1, ed);
	}
}


int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> arr[i];
		if (hMax < arr[i])
			hMax = arr[i];
	}
	func(0, hMax);
	cout << ans;
	
}
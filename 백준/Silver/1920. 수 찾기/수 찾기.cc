#include <iostream>
#include <algorithm>
using namespace std;
int v[100000]{ 0 };

bool findNum(int num, int st, int ed) {
	while (st <= ed) {
		int mid = (st + ed) / 2;
		if (v[mid] == num)
			return true;
		if (num < v[mid]) {
			ed = mid -1;
		}
		else {
			st = mid + 1;
		}
	}
	return false;
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, m;
	cin >> n;

	for (int i = 0; i < n; ++i) {
		cin >> v[i];
	}
	cin >> m;
	sort(v, v+n);
	for (int i = 0; i < m; ++i) {
		int tmp;
		cin >> tmp;
		cout << (int)findNum(tmp, 0, n-1)<<'\n';
	}

}
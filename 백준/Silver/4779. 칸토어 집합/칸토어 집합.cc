#include <iostream>
using namespace std;

bool arr[1000000]{ 0 };

void func(int st, int ed) {
	int len = ed - st + 1;
	if (len < 3)
		return;
	func(st, st + len / 3 - 1);


	for (int i = st + len / 3; i < st + 2 * (len / 3); ++i) {
		arr[i] = 1;
	}

	func(st + 2 * (len / 3), ed);
}

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	int ed = 1;
	for (int i = 0; i < 12; ++i) {
		ed *= 3;
	}
	func(1, ed);
	while (cin >> n) {
		int ed = 1;
		for (int i = 0; i < n; ++i) {
			ed *= 3;
		}

		for (int i = 1; i <= ed; ++i) {
			cout << (arr[i] ? " " : "-");
		}
		cout << endl;
	}
}
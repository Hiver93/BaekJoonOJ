#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	cin >> n;

	// tc 만큼 반복
	while (n--) {
		long long start;
		cin >> start;

		// 0이면 1로 변경
		if (start < 2) {
			cout << 2 << endl;
			continue;
		}
		for (long long i = start; i < 9223372036854775807; ++i) {
			bool check = 0;

			// 소수인지 체크
			for (long long j = 2; j * j <= i; ++j) {
				if (i % j == 0) {
					check = 1;
					break;
				}
			}

			// 소수면 출력
			if (!check) {
				cout << i << endl;
				break;
			}
		}
	}
}
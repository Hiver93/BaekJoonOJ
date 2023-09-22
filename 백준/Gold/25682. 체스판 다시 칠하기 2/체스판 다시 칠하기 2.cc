#include <iostream>
#include <deque>
using namespace std;
bool arr[2001][2001]{ 0 };
int arr1[2001][2001]{ 0 };
int arr2[2001][2001]{ 0 };

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, m, k, ans = 2147483647;
	cin >> n >> m >> k;

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			char c;
			cin >> c;
			if (c == 'W') {
				arr[i][j] = 1;
			}
		}		
	}

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= m; ++j) {
			if (i % 2 == 0) {
				if (j % 2 == 0) {
					if (arr[i][j]) {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1] + 1;
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1];
					}
					else {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1];
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + 1;
					}
				}
				else {
					if (!arr[i][j]) {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1] + 1;
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1];
					}
					else {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1];
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + 1;
					}
				}
			}
			else {
				if (j % 2 == 0) {
					if (!arr[i][j]) {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1] + 1;
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1];
					}
					else {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1];
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + 1;
					}
				}
				else {
					if (arr[i][j]) {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1] + 1;
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1];
					}
					else {
						arr1[i][j] = arr1[i - 1][j] + arr1[i][j - 1] - arr1[i - 1][j - 1];
						arr2[i][j] = arr2[i - 1][j] + arr2[i][j - 1] - arr2[i - 1][j - 1] + 1;
					}

				}
			}
		}
	}

	for (int i = k; i <= n; ++i) {
		for (int j = k; j <= m; ++j) {
			int tmp = arr1[i][j] - arr1[i - k][j] - arr1[i][j - k] + arr1[i - k][j - k];
			if (tmp < ans) {
				ans = tmp;
			}
			tmp = arr2[i][j] - arr2[i - k][j] - arr2[i][j - k] + arr2[i - k][j - k];
			if (tmp < ans) {
				ans = tmp;
			}
		}
	}

	cout << ans;
}
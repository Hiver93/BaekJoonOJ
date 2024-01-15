#include <iostream>
using namespace std;

int input[500][500];
int arr[500][500];
int dr[4] = { -1,1,0,0 };
int dc[4] = { 0,0,-1,1 };
int n, m;

bool isBoundOk(int y, int x) {
	return 0 <= y && 0 <= x && y < n&& x < m;
}

void func(int y, int x) {
	int sum = 0;
	for (int i = 0; i < 4; ++i) {
		int nextY = y + dr[i];
		int nextX = x + dc[i];
		if (isBoundOk(nextY, nextX)) {
			if (input[y][x] < input[nextY][nextX]) {
				if (arr[nextY][nextX] == -1) {
					func(nextY, nextX);
				}
				sum += arr[nextY][nextX];
			}
		}
	}
	arr[y][x] = sum;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			int tmp;
			cin >> tmp;
			input[i][j] = tmp;
			arr[i][j] = -1;
		}
	}
	arr[0][0] = 1;
	func(n - 1, m - 1);
	cout << arr[n - 1][m - 1]<<endl;
}
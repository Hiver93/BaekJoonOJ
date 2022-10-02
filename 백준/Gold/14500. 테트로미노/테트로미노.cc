#include <iostream>
using namespace std;

int arr[500][500];
// 상 하 좌 우 좌상 좌하 우상 우하
int dr[8]{ -1,1,0,0, -1,1,-1,1 };
int dc[8]{ 0,0,-1,1,-1,-1,1,1};

int block1[2][3]{ {1,1,1},{3,3,3}};
int block2[1][3]{ {3,0,2} };
int block3[8][3]{ {1,1,3}, {2,2,1}, {0,0,2}, {3,3,0},{1,1,2},{2,2,0},{0,0,3},{3,3,1} };
int block4[4][3]{ {1,3,1},{2,1,2},{1,2,1},{2,0,2} };
int block5[4][3]{ {3,1,6},{1,2,7},{2,0,5},{0,3,4} };

int main()
{
	int n;
	int m;
	int ans = 0;
	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> arr[i][j];
		}
	}

	for (int i = 0; i < n; ++i) 
	{
		for (int j = 0; j < m; ++j) 
		{
			for (int k = 0; k < sizeof(block1)/sizeof(block1[0]); ++k) {
				int tmp = arr[i][j];
				bool check = true;
				int row = i;
				int col = j;
				for (int l = 0; l < 3; ++l) {
					if (row + dr[block1[k][l]] < 0 || n <= row + dr[block1[k][l]] || col + dc[block1[k][l]] < 0 || m <= col + dc[block1[k][l]])
					{
						check = false;
						break;
					}
					row += dr[block1[k][l]];
					col += dc[block1[k][l]];
					tmp += arr[row][col];
				}
				if (check && ans < tmp)
					ans = tmp;
			}

			for (int k = 0; k < sizeof(block2)/sizeof(block1[0]); ++k) {
				int tmp = arr[i][j];
				bool check = true;
				int row = i;
				int col = j;
				for (int l = 0; l < 3; ++l) {
					if (row + dr[block2[k][l]] < 0 || n <= row + dr[block2[k][l]] || col + dc[block2[k][l]] < 0 || m <= col + dc[block2[k][l]])
					{
						check = false;
						break;
					}
					row += dr[block2[k][l]];
					col += dc[block2[k][l]];
					tmp += arr[row][col];
				}
				if (check && ans < tmp)
					ans = tmp;
			}

			for (int k = 0; k < sizeof(block3) / sizeof(block1[0]); ++k) {
				int tmp = arr[i][j];
				bool check = true;
				int row = i;
				int col = j;
				for (int l = 0; l < 3; ++l) {
					if (row + dr[block3[k][l]] < 0 || n <= row + dr[block3[k][l]] || col + dc[block3[k][l]] < 0 || m <= col + dc[block3[k][l]])
					{
						check = false;
						break;
					}
					row += dr[block3[k][l]];
					col += dc[block3[k][l]];
					tmp += arr[row][col];
				}
				if (check && ans < tmp)
					ans = tmp;
			}
						
			for (int k = 0; k < sizeof(block4) / sizeof(block1[0]); ++k) {
				int tmp = arr[i][j];
				bool check = true;
				int row = i;
				int col = j;
				for (int l = 0; l < 3; ++l) {
					if (row + dr[block4[k][l]] < 0 || n <= row + dr[block4[k][l]] || col + dc[block4[k][l]] < 0 || m <= col + dc[block4[k][l]])
					{
						check = false;
						break;
					}
					row += dr[block4[k][l]];
					col += dc[block4[k][l]];
					tmp += arr[row][col];
				}
				if (check && ans < tmp)
					ans = tmp;
			}
						
			for (int k = 0; k < sizeof(block5) / sizeof(block1[0]); ++k) {
				int tmp = arr[i][j];
				bool check = true;
				int row = i;
				int col = j;
				for (int l = 0; l < 3; ++l) {
					if (row + dr[block5[k][l]] < 0 || n <= row + dr[block5[k][l]] || col + dc[block5[k][l]] < 0 || m <= col + dc[block5[k][l]])
					{
						check = false;
						break;
					}
					row += dr[block5[k][l]];
					col += dc[block5[k][l]];
					tmp += arr[row][col];
				}
				if (check && ans < tmp)
					ans = tmp;
			}
		}
	}
	cout << ans;
}
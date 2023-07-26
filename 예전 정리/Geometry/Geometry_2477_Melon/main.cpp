#include <iostream>
using namespace std;
//³² 2 µ¿ 2 ¤¡
//ºÏ 2 ¼­ 2 ¤¤
//³² 2 ¼­ 2 >
//ºÏ 2 µ¿ 2 <
//µ¿¼­³²ºÏ
int main() {
	int arr[6]{ 0 };
	int max[2] = { 0 };
	int xIdx;
	int yIdx;
	int xDir, yDir, n;
	cin >> n;
	for (int i = 0; i < 6; ++i) {
		int tmp;
		cin >> tmp;
		cin >> arr[i];
		if ((tmp==1||tmp==2)&&max[0] < arr[i]) {
			max[0] = arr[i];
			xIdx = i;
			xDir = tmp;
		}
		else if((tmp == 3 || tmp == 4) && max[1] < arr[i]) {
			max[1] = arr[i];
			yIdx = i;
			yDir = tmp;
		}
	}
	cout << n *((max[0] * max[1]) - arr[(xIdx + ((xDir + yDir) % 2 * 2 + 2)) % 6] * arr[(yIdx + (((xDir + yDir) % 2 - 2) * -2)) % 6]);
}
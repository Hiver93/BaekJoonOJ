#include <iostream>
using namespace std;

// 1. 1번집의 색은 2번집과 달라야 한다.
// 2. N번 집의 색은 N-1번 집의 색과 달라야 한다.
// 3. i(2 <= i <= N-1)번 집의 색은 i-1번, i+1번 집이 색과 달라야 한다.
// 빨강 초록 파랑 세가지 비용 집마다 다름
// 모든 집을 칠하는 비용의 최솟값을 출력

int main()
{
	// 해당 인덱스의 집을 각 색깔로 칠했을 경우 최소비용을 메모해둘 배열
	int red[1001]{0};
	int blue[1001]{0};
	int green[1001]{0};
	int n;
	cin >> n;

	// 각 색깔로 칠했을 경우 최소비용을 구한다 (다른 색깔의 i-1 집 중 더 저렴한 비용에 현재 비용을 더하면 됨)
	for (int i = 1; i <= n; ++i)
	{
		int r, g, b;
		cin >> r >> g >> b;
		red[i] = blue[i - 1] < green[i - 1] ? blue[i - 1] + r : green[i - 1] + r;
		blue[i] = red[i - 1] < green[i - 1] ? red[i - 1] + b : green[i - 1] + b;
		green[i] = red[i - 1] < blue[i - 1] ? red[i - 1] + g : blue[i - 1] + g;
	}

	// n번 인덱스 중 가장 저렴한 것으로 출력
	int ans = red[n] < blue[n] ? red[n] : blue[n];
	cout << ((ans < green[n]) ? ans : green[n]);
}
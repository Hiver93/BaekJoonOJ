#include <iostream>
#include <queue>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	bool visit[1000000]{ 0 };
	queue<pair<int, long long>> q;
	int n, k;
	cin >> n >> k;

	if (n == k) {
		cout << 0;
		return 0;
	}

	// bfs
	// 현재위치, 이동횟수를 큐에 저장
	q.push({ n, 0 });
	visit[n] = 1;
	while (!q.empty()) {
		int num = q.front().first;
		long long dis = q.front().second;
		q.pop();

		// 뒤로 걷는 경우
		if (0 <=num - 1 && !visit[num - 1]) {
			if (num - 1 == k) {
				cout << dis + 1;
				return 0;
			}
			q.push({ num - 1,dis + 1 });
			visit[num - 1] = 1;
		}
		// 앞으로 걷는 경우
		if (num+1 <= 1000000 && !visit[num + 1]) {
			if (num + 1 == k) {
				cout << dis + 1;
				return 0;
			}
			q.push({ num + 1, dis + 1 });
			visit[num + 1] = 1;
		}
		// 순간이동 하는 경우
		if (num * 2 <= 1000000 && !visit[num * 2]) {
			if (num * 2 == k) {
				cout << dis + 1;
				return 0;
			}
			q.push({ num * 2,dis + 1 });
			visit[num * 2] = 1;
		}
	}


}
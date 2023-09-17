#include <iostream>
#include <queue>
#include <list>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int arr[101][101]{ 0 };
	list<int> l[101];
	long long ans = 9000000000000000000;
	int idx = 0;
	int n, m;
	cin >> n >> m;

	for (int i = 0; i < m; ++i) {
		int a, b;
		cin >> a >> b;
		l[a].push_back(b);
		l[b].push_back(a);
	}

	for (int i = 0; i < n; ++i) {
		long long sum = 0;
		queue<pair<int,int>> q;
		bool visit[101]{ 0 };
		visit[i + 1] = 1;
		q.push({ i + 1,0 });

		while (!q.empty()) {
			int num = q.front().first;
			int dis = q.front().second;
			q.pop();
			for (auto j = l[num].begin(); j != l[num].end(); ++j) {
				if (visit[*j])
					continue;
				q.push({ *j, dis + 1 });
				sum += (dis + 1);
				visit[*j] = 1;
			}
		}
		if (sum < ans) {
			ans = sum;
			idx = i+1;
		}
	}

	cout << idx << endl;
}
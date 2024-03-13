#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;
int parent[7]{ 0 };
int depth[7]{ 0 };
int arr[10][10]{ 0 };
int visit[10][10]{ 0 };

int dr[4]{ -1,1,0,0 };
int dc[4]{ 0,0,-1,1 };

int n, m;
int idx = 1;

int id[6][4]{ 0 };

map<pair<int, int>, int> mp;

bool cmp(pair<pair<int,int>,int>& a, pair<pair<int, int>, int>& b) {
	return a.second < b.second;
}

int _find(int target) {
	if (parent[target] == target)
		return target;
	parent[target] = _find(parent[target]);
	return parent[target];
}

int _union(int a, int b) {
	a = _find(a);
	b = _find(b);

	if (a != b) {
		if (depth[a] < depth[b]) {
			parent[a] = parent[b];
		}
		else {
			parent[b] = parent[a];
		}
		if (depth[a] == depth[b])
			depth[b]++;
		return 1;
	}
	return 0;
}

bool isOk(int y, int x) {
	return y < n&& x < m && 0 <= y && 0 <= x;
}

void func(int y, int x) {
	visit[y][x] = 1;
	arr[y][x] = idx;
	for (int i = 0; i < 4; ++i) {
		int nY = y + dr[i];
		int nX = x + dc[i];
		if (isOk(nY, nX) && !visit[nY][nX] && arr[nY][nX]) {
			func(nY, nX);
		}
	}
}

int getDis(int a, int b) {
	return a - b -1;
}

void findLoad(int y, int x) {
	int cIdx = arr[y][x];
	for (int i = 0; i < 4; ++i) {
		int j = 1;
		int nY = dr[i] + y;
		int nX = dc[i] + x;
		while (isOk(nY, nX) && arr[nY][nX] != cIdx) {
			int cur = arr[nY][nX];
			if (cur) {
				int dis = abs(y - nY + x - nX)-1;
				if (1 < dis) {
					int a = min(cIdx, cur);
					int b = max(cIdx, cur);
					auto tmp = mp.find({ a,b });
					if (tmp == mp.end()) {
						mp.insert({ { a,b }, dis });
					}
					else {
						if (dis < tmp->second) {
							mp[{a, b}] = dis;
						}
					}
				}
				break;				
			}
			nY = nY + dr[i];
			nX = nX + dc[i];
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n >> m;
	int ans = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			cin >> arr[i][j];
		}
	}
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (!visit[i][j]&&arr[i][j]) {
				func(i, j);
				idx++;
			}
		}
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (arr[i][j]) {
				findLoad(i,j);
			}
		}
	}


	vector<pair<pair<int, int>, int>> vec(mp.begin(),mp.end());
	
	sort(vec.begin(), vec.end(), cmp);
	for (int i = 0; i < idx; ++i) {
		parent[i] = i;
	}
	for (int i = 0; i < vec.size(); ++i) {
		if (_union(vec[i].first.first, vec[i].first.second)) {
			ans += vec[i].second;
		}
	}
	for (int i = 0; i < idx; ++i)
		_find(i);
	int last = parent[1];
	for (int i = 1; i < idx; ++i) {
		if (parent[i] != last) {
			cout << -1 << endl;
			return 0;
		}
	}

	cout << ans << endl;
}
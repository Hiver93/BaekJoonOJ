#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<vector<int>> vec;

int parent[10001]{ 0 };
int depth[10001]{ 0 };

int _find(int target) {
	if (parent[target] == target) {
		return target;
	}
	parent[target] = _find(parent[target]);
	return parent[target];
}

bool _union(int a, int b) {
	a = _find(a);
	b = _find(b);
	if (a != b) {
		if (depth[a] < depth[b]) {
			parent[a] = parent[b];
		}
		else {
			parent[b] = parent[a];
		}
		if (depth[a] == depth[b]) {
			depth[b]++;
		}
		return 1;
	}
	return 0;
}

bool cmp(vector<int> a, vector<int> b) {
	return a[2] < b[2];
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int v, e;
	int ans = 0;
	cin >> v >> e;
	for (int i = 1; i <= v; ++i) {
		parent[i] = i;
	}

	for (int i = 0; i < e; ++i) {
		int a, b, c;
		cin >> a >> b >> c;
		vec.push_back({ a,b,c });
	}

	sort(vec.begin(), vec.end(), cmp);
	for (int i = 0; i < e; ++i) {
		if (_union(vec[i][0], vec[i][1])) {
			ans += vec[i][2];
		}
	}
	cout << ans << endl;
}
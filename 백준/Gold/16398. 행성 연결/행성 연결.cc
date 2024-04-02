#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int parent[1000]{ 0 };
int depth[1000]{ 0 };
vector<vector<int>> v;
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
			parent[a] = b;
		}
		else {
			parent[b] = a;
			depth[b]++;
		}
		return 1;
	}
	return 0;
}

bool cmp(vector<int>& a, vector<int>& b) {
	return a[2] < b[2];
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n;
	long long ans = 0;
	cin >> n;

	for (int i = 0; i < n; ++i) {
		parent[i] = i;
	}

	v.resize(n * n - n);
	int idx = 0;
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			int cost;
			cin >> cost;
			if (i == j)
				continue;
			v[idx++] = {i,j,cost};
		}
	}

	sort(v.begin(), v.end(), cmp);

	for (int i = 0; i < v.size(); ++i) {
		if (_union(v[i][0], v[i][1])) {
			ans += v[i][2];
		}
	}

	cout << ans;
}
#include <iostream>
using namespace std;
int parent[500001]{ 0 };
int depth[500001]{ 0 };

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
		if (depth[a] == depth[b])
			depth[a]++;
		return 0;
	}
	return 1;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, m;
	cin >> n >> m;
	for (int i = 1; i < n + 1; ++i) {
		parent[i] = i;
	}
	for (int i = 0; i < m; ++i) {
		int a, b;
		cin >> a >> b;
		if (_union(a, b)) {
			cout << i + 1;
			return 0;
		}			
	}
	cout << 0;
}
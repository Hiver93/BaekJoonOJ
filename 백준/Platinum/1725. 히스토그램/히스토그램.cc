#include <iostream>
#include <vector>
using namespace std;
vector <pair<int, int>> v(100000);


// 병합정렬과 같은 원리로 합치면 될듯
void merge(int left, int mid, int right) {
	int cnt = 0;
	int last = 2147483647;
	int idx = mid + 1;

	for (int i = mid; i >= left; --i) {
		int cur = v[i].first;
		if (last < cur) {
			continue;
		}
		last = cur;
		v[i].second += cnt;
		for (idx; idx < right + 1; ++idx) {
			if (v[idx].first < cur) {
				break;
			}
			cnt++;
			v[i].second++;
		}
	}
	cnt = 0;
	last = 2147483647;
	idx = mid;
	for (int i = mid + 1; i < right + 1; ++i) {
		int cur = v[i].first;
		if (last < cur) {
			continue;
		}
		last = cur;
		v[i].second += cnt;
		for (idx; idx >= left; --idx) {
			if (v[idx].first < cur) {
				break;
			}
			cnt++;
			v[i].second++;
		}
	}
}

void func(int left, int right) {
	if (left < right) {
		int mid = (left + right) / 2;
		func(left, mid);
		func(mid + 1, right);
		merge(left, mid, right);
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i) {
        int tmp;
        cin >> tmp;
        v[i].first = tmp;
        v[i].second = 1;
    }
    func(0, n - 1);
    long long ans = 0;
    for (int i = 0; i < n; ++i) {
        long long tmp = (long long)v[i].first * (long long)v[i].second;
        if (ans < tmp)
            ans = tmp;
    }
    cout << ans << endl;
}
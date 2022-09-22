#include <iostream>
using namespace std;

int main() 
{
	int t;
	int start[2], end[2];
	int n;
	int x, y, l;
	cin >> t;
	int ans = 0;
	bool check = 0;
	for (int i = 0; i < t; ++i) {
		cin >> start[0] >> start[1] >> end[0] >> end[1];
		cin >> n;
		for (int j = 0; j < n; ++j) {
			cin >> x >> y >> l;
			if (((x - start[0]) * (x - start[0]) + (y - start[1]) * (y - start[1])) < l * l) {
				check ^= 1;
			}
			if (((x - end[0]) * (x - end[0]) + (y - end[1]) * (y - end[1])) < l * l) {
				check ^= 1;
			}
			if (check) {
				ans++;
			}
			check = 0;
		}
		cout << ans << endl;
		ans = 0;
	}

}
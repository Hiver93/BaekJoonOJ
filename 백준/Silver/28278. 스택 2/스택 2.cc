#include <iostream>
#include <stack>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n;
	stack<int> s;
	cin >> n;

	while (n--) {
		int tmp;
		cin >> tmp;
		switch (tmp)
		{
		case 1: {
			int v;
			cin >> v;
			s.push(v);
			break;
		}
		case 2: {
			if (s.empty()) {
				cout << -1<<"\n";
			}
			else {
				cout << s.top() << '\n';
				s.pop();
			}
			break;
		}
		case 3: {
			cout << s.size() << '\n';
			break;
		}
		case 4: {
			cout << (int)(s.empty()) << '\n';
			break;
		}
		case 5: {
			if (s.empty()) {
				cout << -1 << '\n';
			}
			else {
				cout << s.top() << '\n';
			}
			break;
		}
		default:
			break;
		}
	}
}
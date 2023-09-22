#include <iostream>
#include <deque>
using namespace std;

// 스택은 변함이 없고 큐에 들어있는 값만이 다음으로 넘어가기 때문에 큐만 신경 써주면 됨
bool ds[100000]{ 0 };
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n;
	int m;
	deque<int> q;
	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> ds[i];
	}
	// 큐인경우 덱에 push back
	for (int i = 0; i < n; ++i) {
		int tmp;
		cin >> tmp;
		if (!ds[i]) {
			q.push_back(tmp);
		}
	}
	cin >> m;

	// 값을 앞으로 집어넣고 뒤에서 제거하여 출력
	while (m--) {
		int input;
		cin >> input;
		q.push_front(input);
		cout << q.back() << ' ';
		q.pop_back();
	}
}
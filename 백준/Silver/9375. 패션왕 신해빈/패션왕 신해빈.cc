#include <iostream>
#include <map>
using namespace std;

int main()
{
	int tc;
	cin >> tc;

	for (int T = 0; T < tc; ++T) {
		// 옷의 종류, 해당 종류의 수
		map<string,int> m;
		int n;
		int ans = 1;
		cin >> n;
		for (int i = 0; i < n; ++i) {
			string str;
			// 입력받는다. 의류 이름은 버린다.
			cin >> str >> str;

			auto tmpMap = m.find(str);
			if (tmpMap == m.end()) { // 맵에 해당하는 의류종류가 없다면 1로 초기화하여 집어넣는다
				m.insert({ str,1 });
			}
			else { // 존재한다면 가짓수 증가
				tmpMap->second++;
			}
		}

		// 종류별 가짓수 + 1(입지 않은 경우)을 곱한다
		for (auto i = m.begin(); i != m.end(); ++i) {
			ans *= i->second + 1;
		}
		// 1(아무것도 입지 않은 경우)를 빼면 완료
		cout << ans - 1 << endl;
	}
}
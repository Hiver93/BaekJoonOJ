#include <iostream>
#include <list>
#include <queue>
#include <vector>
using namespace std;

class Node {
public:
	list<pair<int, int>> li;
};

int v, e, start;
Node* nodeArr[20001];
int disArr[20001];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> v >> e >> start;
	for (int i = 0; i < v; ++i) {
		nodeArr[i + 1] = new Node();
		disArr[i + 1] = 2147483647;
	}
	for (int i = 0; i < e; ++i) {
		int st, ed, dis;
		cin >> st >> ed >> dis;
		nodeArr[st]->li.push_back({ dis, ed });
	}
	disArr[start] = 0;
	pq.push({ 0,start });
	while (!pq.empty()) {
		pair<int,int> st = pq.top();
		pq.pop();
		if (disArr[st.second] < st.first)
			continue;

		for (auto i = nodeArr[st.second]->li.begin(); i != nodeArr[st.second]->li.end(); ++i) {
			int tmpDis = i->first + disArr[st.second];
			if (tmpDis < disArr[i->second]) {
				disArr[i->second] = tmpDis;
				pq.push({ tmpDis, i->second });
			}
		}		
	}

	for (int i = 1; i <= v; ++i) {
		if (disArr[i] == 2147483647) {
			cout << "INF\n";
		}
		else
			cout << disArr[i] << "\n";
	}


}
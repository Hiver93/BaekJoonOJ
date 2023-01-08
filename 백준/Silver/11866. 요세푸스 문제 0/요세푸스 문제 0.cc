#include <iostream>
using namespace std;

int main()
{
	int q[1001];
	int ans[1000];
	int idx = 0;
	int front = 0;
	int rear = 0;

	int n;
	int k;
	cin >> n >> k;
	for (int i = 0; i < n; ++i)
	{
		q[rear++] = i + 1;
	}
	
	int cnt = 1;
	while (front != rear)
	{
		int tmp = q[front++];
		if (cnt % k == 0) {			
			ans[idx++] = tmp;
		}
		else {
			q[rear++] = tmp;
		}

		front %= 1001;
		rear %= 1001;
		cnt++;
	}
	cout << "<";
	for (int i = 0; i < n - 1; ++i)
	{
		cout << ans[i] << ", ";
	}
	cout << ans[n - 1] << ">";
}
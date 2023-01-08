#include <iostream>
#include <stack>
#include <queue>
#include <list>
using namespace std;




int main()
{
	/*stack<int> s;
	s.push(2);
	s.push(3);
	cout << s.top();
	s.pop();

	cout << s.size();*/

	//queue<int> q;

	int q[1001];
	int front = 0;
	int rear = 0;
	int arr[1000];
	int idx = 0;
	
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
		int tmp = q[(front++) % 1001];
		if (cnt % k != 0)
		{
			q[(rear++) % 1001] = tmp;
		}
		else
		{
			arr[idx++] = tmp;
		}
		front %= 1001;
		rear %= 1001;
		cnt++;
	}

	cout << "<";
	for (int i = 0; i < n-1; ++i)
	{
		cout << arr[i] << ", ";
	}
	cout << arr[n - 1] << ">";

	
}
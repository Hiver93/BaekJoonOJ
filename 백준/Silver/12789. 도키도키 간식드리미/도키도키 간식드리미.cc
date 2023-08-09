#include <iostream>
#include <stack>
using namespace std;
stack<int> s;
int last = 0;
int n;

// 재귀로 풀자
void func()
{
	// 만약 순서가 맞다면
	if (s.top() == last + 1)
	{
		last++;
		s.pop();
		// 그 다음 것도 확인
		func();
	}
}

int main()
{
	cin >> n;
	s.push(1005);
	for (int i = 0; i < n; ++i)
	{
		int tmp;
		cin >> tmp;
		if (tmp == last + 1)
		{
			last++;
			func();
		}
		else
		{
			func();
			if (tmp == last + 1)
			{
				last++;
				func();
			}
			if (s.top() < tmp)
			{
				cout << "Sad" << endl;
				return 0;
			}
			else 
			{
				s.push(tmp);
			}
		}
	}
	cout << "Nice" << endl;
}
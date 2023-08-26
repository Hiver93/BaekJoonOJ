// 뒤에서 접근 작아지면 숫자변경하고 뒤에 친구들 확인 커지면 새로 
#include <iostream>
#include <stack>
using namespace std;

int arr[5000000]{ 0 };
stack <pair<int, int>> s;
int n, l;

// 앞에서 뒤로 합칠 수 있는 지 확인하여 합치기
void CheckStack(int num, int& len)
{
	while (s.top().second != -1 && len < l)
	{
		if (num < s.top().first)
		{
			if (l - len <= s.top().second)
			{
				s.top().second -= (l - len);
				len = l;
			}
			else
			{
				len += s.top().second;
				s.pop();
			}
		}
		else
		{
			break;
		}
		if (s.top().second == 0)
			s.pop();
	}
}

int main()
{
	cin >> n >> l;
	for (int i = 0; i < n; ++i)
	{
		scanf("%d",&arr[i]);
	}

	// stack의 가장 아래 (코드 편하기 짜기 위함), 그리고 가장 뒤 숫자를 넣어두고 시작
	s.push({ -2147483648,-1 });
	int num = arr[n-1];
	int len = 1;
	

	// 뒤에서 앞으로
	for (int i = n - 2; i >= 0; --i)
	{		
		if (len == l) // 길이가 최대가 되었다면 스택에 하나만 일단 집어넣는다. 길이 -1
		{
			s.push({ num,1 });
			len--;
		}
		if (num < arr[i]) // 뒤의 것이 앞것보다 작다면 스택에 집어넣고 새로
		{
			s.push({ num,len });
			num = arr[i];
			len = 1;
		}
		else// 뒤의 것이 앞 것보다 크다면, 숫자 바꾸고 합칠 수 있는 지 체크
		{
			num = arr[i];
			len++;
			CheckStack(num, len);
		}
	}
	s.push({ num, len });

	// 출력
	while (s.top().second != -1)
	{
		for (int i = 0; i < s.top().second; ++i)
		{
			printf("%d ", s.top().first);
		}
		s.pop();
	}
}
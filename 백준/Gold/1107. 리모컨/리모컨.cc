#include <iostream>
using namespace std;

int n, m;
bool arr[10]{ 0 };

// 가능한 번호인지 확인
bool Check(int num)
{
	if (num == 0 && arr[0])
		return false;

	while (num)
	{
		if (arr[num % 10])
			return false;
		num /= 10;
	}
	return true;
}

int main()
{
	cin >> n >> m;
	int ans = 2147483647;
	int num = 0;
	for (int i = 0; i < m; ++i)
	{
		int idx;
		cin >> idx;
		arr[idx] = 1;
	}

	// 백만까지의 수 중 가장 가까운 수를 찾는다
	for (int i = 0; i < 1000000; ++i)
	{
		if (i < n)
		{
			if (Check(i) && n - i < ans)
			{
				ans = n - i;
				num = i;
			}
		}
		else
		{
			if (Check(i) && i - n < ans)
			{
				ans = i - n;
				num = i;
				break;
			}
		}
	}

	// 가장 가까운 수의 번호 누름 횟수 구하기
	if(ans != 2147483647)
	if (num == 0)
		ans++;
	else
		while (num)
		{
			ans++;
			num /= 10;
		}

	// 100에서 + - 만 이용한 경우의 번호 누름 횟수 구하기
	if (n < 100)
	{
		if (100 - n < ans)
			ans = 100 - n;
	}
	else
	{
		if (n - 100 < ans)
			ans = n - 100;
	}

	cout << ans;
}
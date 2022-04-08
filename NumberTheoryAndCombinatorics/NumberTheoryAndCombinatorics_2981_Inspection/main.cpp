#include <iostream>
#include <algorithm>.
#include <vector>
using namespace std;

int Func(int a, int b)
{
	return b ? Func(b, a % b) : a;	
}
int main()
{
	int n;
	int arr[100];
	vector<int> ans;
	long long lCM = 1;

	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	if (arr[1] < arr[0])
	{
		int temp = arr[1];
		arr[1] = arr[0];
		arr[0] = temp;
	}
	lCM = arr[1] - arr[0];

	for (int i = 2; i < n; i++)
	{
		if (arr[i] < arr[i - 1])
		{
			int temp = arr[i];
			arr[i] = arr[i - 1];
			arr[i - 1] = temp;
		}

		if (arr[i] - arr[i - 1] < lCM)
		{
			lCM = Func(lCM, arr[i] - arr[i - 1]);
		}
		else
			lCM = Func(arr[i] - arr[i - 1], lCM);
	}

	for (int i = 2; i * i <= lCM; i++)
	{
		if (lCM % i == 0)
			ans.push_back(i);
	}
	int i = ans.size()-1;
	for (i; i >= 0; i--)
	{
		if(ans.back() != lCM/ans[i])
			ans.push_back(lCM / ans[i]);
	}
	ans.push_back(lCM);

	for (int i = 0; i < ans.size(); i++)
	{
		printf("%d ",ans[i]);
	}
	return 0;
}
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

bool func(string a, string b)
{
	if (a.length() == b.length())
	{
		int n = a.length();
		for (int i = 0; i < n; i++)
		{
			if (a[i] < b[i])
			{
				return 1;
			}
			else if (a[i] > b[i])
			{
				return 0;
			}
		}
	}
	return a.length() < b.length();

}

int main()
{
	int n;
	cin >> n;
	string* arr = new string[n];

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	sort(arr, arr + n, func);

	string str = "";
	for (int i = 0; i < n; i++)
	{
		if (str.length() == arr[i].length())
		{
			if (!(arr[i].compare(str)))
			{
				continue;
			}
		}
		cout << arr[i] << endl;
		str = arr[i];
	}

}
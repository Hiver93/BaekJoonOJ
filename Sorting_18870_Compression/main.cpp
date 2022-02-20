#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

bool func(int a, int b)
{
	return a < b;
}
int main()
{
	int n;
	cin >> n;
	int* arr = new int[n];
	int* arr2 = new int[n];
	map<int, int> m;


	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
		arr2[i] = arr[i];
	}

	sort(arr, arr + n, func);
	int tmp = arr[0];
	m.insert(make_pair(arr[0], 0));
	int j = 1;
	for (int i = 1; i < n; i++)
	{
		if (arr[i] == tmp)
			continue;
		m.insert(make_pair(arr[i], j));
		tmp = arr[i];
		j++;
	}
	for (int i = 0; i < n; i++)
	{
		cout << m.find(arr2[i])->second << ' ';
	}

	return 0;
}
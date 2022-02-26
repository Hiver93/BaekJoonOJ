#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool func(string str1, string str2)
{
	int a = 0, b = 0;
	int i = 0;
	while (str1[i] != ' ')
	{
		a *= 10;
		a += str1[i++] - '0';
	}
	i = 0;
	while (str2[i] != ' ')
	{
		b *= 10;
		b += str2[i++] - '0';
	}
	return a < b;
}

int main()
{
	int n;
	cin >> n;
	string* vec = new string[n];
	string str;

	for (int i = 0; i < n; i++)
	{
		cin >> vec[i];
		cin >> str;
		vec[i] = vec[i] + " " + str;
	}

	stable_sort(vec, vec + n, func);

	for (int i = 0; i < n; i++)
	{
		cout << vec[i] << '\n';
	}
	delete[] vec;
}
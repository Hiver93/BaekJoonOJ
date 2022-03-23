#include <iostream>
#include <string>
using namespace std;

string sArr[101]{ "0","1","1","1","2","2","3","4","5","7","9" };
bool check[101]{ 1,1,1,1,1,1,1,1,1,1,1,0 };

char* Sum(string bn1, string bn2)
{
	int len;
	int digit = 0;

	if (bn2.length() < bn1.length())
	{
		len = bn1.length();
		int de = len - bn2.length();
		char* result = new char[len + 2];
		result[len + 1] = '\0';
		for (int i = 1; i <= len - de; ++i)
		{
			if ((bn1[len - i] - '0') + (bn2[len - i - de] - '0') + digit > 9) // 자릿수 올림 발생
			{
				result[len + 1 - i] = ((bn1[len - i] - '0') + (bn2[len - i - de] - '0')) + digit - 10 + '0';
				digit = 1;
			}

			else
			{
				result[len + 1 - i] = (bn1[len - i] - '0') + (bn2[len - i - de] - '0') + digit + '0';
				digit = 0;
			}
		}

		for (int i = 1; i <= de; i++)
		{
			if (bn1[len - (len - de) - i] - '0' + digit > 9)
			{
				result[len + 1 - (len - de) - i] = '0';
				digit = 1;
			}
			else
			{
				result[len + 1 - (len - de) - i] = bn1[len - (len - de) - i] + digit;
				digit = 0;
			}

		}
		if (digit == 1)
		{
			result[0] = '1';
		}
		else
			result[0] = '0';


		return result;
	}

	else
	{
		len = bn2.length();
		int de = len - bn1.length();
		char* result = new char[len + 2];
		result[len + 1] = '\0';
		for (int i = 1; i <= len - de; ++i)

		{
			if ((bn2[len - i] - '0') + (bn1[len - i - de] - '0') + digit > 9) // 자릿수 올림 발생
			{
				result[len + 1 - i] = ((bn2[len - i] - '0') + (bn1[len - i - de] - '0')) + digit - 10 + '0';
				digit = 1;
			}

			else
			{
				result[len + 1 - i] = (bn2[len - i] - '0') + (bn1[len - i - de] - '0') + digit + '0';
				digit = 0;
			}
		}

		for (int i = 1; i <= de; i++)
		{
			if (bn2[len - (len - de) - i] - '0' + digit > 9)
			{
				result[len + 1 - (len - de) - i] = '0';
				digit = 1;
			}
			else
			{
				result[len + 1 - (len - de) - i] = bn2[len - (len - de) - i] + digit;
				digit = 0;
			}

		}
		if (digit == 1)
		{
			result[0] = '1';
		}
		else
			result[0] = '0';


		return result;
	}
}

string Func(int n)
{
	if (check[n])
	{

		return sArr[n];
	}
	if (!check[n - 1])
	{
		Func(n - 1);

	}
	if (!check[n - 5])
	{
		Func(n - 5);
	}
	char* a = Sum(sArr[n - 1], sArr[n - 5]);
	if (*a == '0')
		sArr[n] = a + 1;
	else
		sArr[n] = a;
	delete a;
	check[n] = 1;
	return sArr[n];
}

int main()
{
	int n;
	cin >> n;
	while (n--)
	{
		int t;
		cin >> t;
		cout << Func(t) << endl;
	}
	return 0;
}
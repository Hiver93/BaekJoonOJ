#include <iostream>
#include <string>
using namespace std;

int main() {
	int check[1000]{0};
	int idx[1000]{0};
	string str1;
	string str2;
	int ans=0;

	cin >> str1 >> str2;
	if (str1.length() < str2.length())
	{
		string temp = str1;
		str1 = str2;
		str2 = temp;
	}


	for (int i = 0; i < str1.length(); i++)
	{
		bool exist = 0;
		for (int j = 0; j < str2.length(); j++)
		{
			if (str1[i] == str2[j])
			{
				exist = 1;
				check[i] = 1;
				idx[i] = j;
				break;
			}
		}
		if(exist)
			for (int j = i; j >= 0; j--)
			{
				if (check[i] <= check[j] + 1)
				{
					for (int k = idx[j]+1; k < str2.length(); k++)
					{
						if (str1[i] == str2[k])
						{
							idx[i] = k;
							check[i] = check[j] + 1;
							break;
						}
					}
				}
			}
		if (ans < check[i])
			ans = check[i];
	}

	cout << ans;
}
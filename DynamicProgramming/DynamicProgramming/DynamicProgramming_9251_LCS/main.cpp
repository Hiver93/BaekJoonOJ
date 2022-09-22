#include <iostream>
#include <string>
using namespace std;

//int main() {
//	int check[1000]{0};
//	int idx[1000]{0};
//	string str1;
//	string str2;
//	int ans=0;
//
//	cin >> str1 >> str2;
//	if (str1.length() < str2.length())
//	{
//		string temp = str1;
//		str1 = str2;
//		str2 = temp;
//	}
//
//
//	for (int i = 0; i < str1.length(); i++)
//	{
//		bool exist = 0;
//		for (int j = 0; j < str2.length(); j++)
//		{
//			if (str1[i] == str2[j])
//			{
//				exist = 1;
//				check[i] = 1;
//				idx[i] = j;
//				break;
//			}
//		}
//		if(exist)
//			for (int j = i; j >= 0; j--)
//			{
//				if (check[i] <= check[j] + 1)
//				{
//					for (int k = idx[j]+1; k < str2.length(); k++)
//					{
//						if (str1[i] == str2[k])
//						{
//							idx[i] = k;
//							check[i] = check[j] + 1;
//							break;
//						}
//					}
//				}
//			}
//		if (ans < check[i])
//			ans = check[i];
//	}
//
//	cout << ans;
//}

int main()
{
	int check[1000]{0};
	int alph[30]{0};
	int idx[1000]{0};
	int maxIdx = 0;
	string str1;
	string str2;

	cin >> str1;
	cin >> str2;

	for (int i = 0; i < str2.length(); ++i)
	{
		if (str1[0] == str2[i])
		{
			alph[str1[0] - 'A'] = i;
			check[0]++;
			break;
		}
	}
	for (int i = 1; i < str1.length(); ++i) 
	{
		check[i] = check[i-1];
		// 인덱스 범위 안넘어서게
		if (alph[str1[1] - 'A'] + 1 == str2.length())
			continue;
		
		for (int j = alph[str1[i] - 'A'] + 1; j < str2.length(); ++j)
		{
			if (str1[i] == str2[j] && maxIdx <= j)
			{
				alph[str1[i] - 'A'] = j;
				check[i]++;
				maxIdx = j;
				break;
			}
		}
	}
	cout << check[str1.length()-1];
}
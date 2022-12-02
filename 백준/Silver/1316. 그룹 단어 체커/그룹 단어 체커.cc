#include <iostream>
using namespace std;

int main()
{
	char str[101];
	int N = 0;
	int count = 0;
	int tf = 0;
	
	cin >> N;
	for (int j = 0; j < N; j++)
	{
		tf = 0;
		cin >> str;
		for (int i = 1; i < 101; i++)
		{
			if (str[i] != str[i - 1])
			{
				for (int k = 0; k < i - 1; k++)
				{
					if (str[i] == str[k])
					{
						tf = -1;
						break;
					}
				}
				if (tf == -1)
				{
					break;
				}

			}

		
			if (tf == -1)
			{
				break;
			}
			
			if (str[i] == '\0')
			{
                count++;
				break;
			}
		
		}
		if (tf == -1)
			continue;

	}
	cout << count;
	return 0;
}
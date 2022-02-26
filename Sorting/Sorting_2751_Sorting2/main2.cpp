#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n;
	cin >> n;

	vector<int> vec(n + 1);
	vec[0] = -1;
	int temp;
	for (int i = 1; i < n + 1; i++)
	{
		cin >> vec[i];
		int j = i;
		while (j > 1)
		{
			if (vec[j] < vec[j / 2])
			{
				temp = vec[j];
				vec[j] = vec[j / 2];
				vec[j / 2] = temp;
				j /= 2;
				continue;
			}
			break;
		}
	}

	for (int i = 1; i < n+1; i++)
	{
		printf("%d\n", vec[1]);		
		vec[1] = vec[n + 1 - i];
		int j = 1;
		while (j < n - i)
		{
			if (j * 2 + 1 <= n - i&&vec[j * 2] > vec[j * 2 + 1])
			{				
				if (vec[j] > vec[j * 2 + 1])
				{
					temp = vec[j];
					vec[j] = vec[j * 2 + 1];
					vec[j * 2 + 1] = temp;
					j = j * 2 + 1;
				}
				else
					break;
			}
			else
			{
				if (j * 2 > n - i)
					break;
				if (vec[j] > vec[j * 2])
				{
					temp = vec[j];
					vec[j] = vec[j * 2];
					vec[j * 2] = temp;
					j *= 2;
				}
				else
					break;
			}
		}
	}

	

}
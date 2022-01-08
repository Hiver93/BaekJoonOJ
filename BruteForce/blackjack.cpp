#include <iostream>
#include <vector>
using namespace std;

int main()
{	
	int M,N;

	cin >> N >> M;
	vector<int> vec(N);
	int tempValue;
	for (int i = 0; i < N; i++)
	{
		cin >> tempValue;
		vec.push_back(tempValue);
	}

	tempValue = vec[0] + vec[1] + vec[2];
	int temp = M - tempValue;
	if (temp < 0)
		temp *= -1;
	

	for (int i = 0; i < N; i++)
	{
		for (int j = i+1; j < N; j++)
		{
			for (int k = j + 1; k < N; k++)
			{
				int newValue;
				newValue = vec[i] + vec[j] + vec[k];
				int newTemp = M - newValue;
				if (newTemp < 0)
				{					
					newTemp *= -1;
				}
				if (tempValue > newTemp)
					temp = newValue;
			}
		}
	}

	cout << temp;
}
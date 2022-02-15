#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int n;
	double average = 0;
	int mid = 0;
	int freq = 0;
	int range = 0;
	int arr[8001] = {0};
	int count = 0;
	int temp;
	int fCount = 0;
	int min = 8000;
	int max = 0;
	
	cin >> n;
	int *result = new int[n];
	int i;
	for (i = 0; i < n; i++)
	{
		cin >> temp;
		average += temp;		
		arr[temp + 4000]++;
	}
	// Æò±Õ°ª
	average /= (double)n;
	temp = 0;
	for (int i = 0; i < 8001; i++)
	{	
		if (arr[i] != 0)
		{
			//ÃÖºó°ª
			if (fCount <= arr[i])
			{
				if (fCount < arr[i])
				{
					fCount = arr[i];
					freq = i - 4000;
					count = 0;
				}
				else if (fCount == arr[i]&&count == 0)
				{
					freq = i - 4000;
					count++;
				}
			}
			for (int j = 0; j < arr[i]; j++)
			{
				result[temp++] = i - 4000;
			}
		}		
	}
	//¹üÀ§
	max = result[n-1];
	min = result[0];
	range = max - min;
	//Áß¾Ó°ª
	mid = result[n / 2];

	cout << round(average) << '\n' << mid << '\n' << freq << '\n' << range << endl;

}
 
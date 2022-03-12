#include <iostream>
using namespace std;

// 시간 초과로 실패
void fail()
{
	//void Func(int* arr1, int* arr2, int size, int n)
	//{
	//	if (n == 1)
	//	{
	//		result += size;
	//		return;
	//	}
	//	int count = 0;
	//	int t1[196];
	//	int t2[196];
	//	for (int i = 0; i < size; i++)
	//	{
	//		count = 0;
	//		for (int j = i + 1; j < size; j++)
	//		{
	//			if (arr1[i] == arr1[j] || arr2[i] == arr2[j])
	//				continue;
	//			if ((arr1[i] - arr1[j]) * (arr1[i] - arr1[j]) == (arr2[i] - arr2[j]) * (arr2[i] - arr2[j]))
	//				continue;
	//			t1[count] = arr1[j];
	//			t2[count] = arr2[j];
	//			count++;
	//		}
	//		Func(t1, t2, count, n - 1);
	//	}

	//}
	////bool check1[14] ={ 0 };
	////bool check2[14] = { 0 };

	//int check1[14];
	//int check2[14];
	//void F(int a, int b, int n, int max)
	//{
	//	if (n == 0)
	//	{
	//		result += 1;
	//		return;
	//	}
	//	for (int i = a + 1; i < max; i++)
	//	{
	//		for (int j = 0; j < max; j++)
	//		{
	//			/*if (a == i || b == j)
	//				continue;
	//			if ((a - i) * (a - i) == (b - j) * (b - j))
	//				continue;*/
	//			for (int k = 0; k < max - n; k++)
	//			{
	//				if (check1[k] == i || check2[k] == j)
	//					break;
	//				if ((check1[k] - i) * (check1[k] - i) == (check2[k] - j) * (check2[k] - j))
	//					break;
	//				check1[max - n] = i;
	//				check2[max - n] = j;
	//				F(i, j, n - 1, max);
	//			}
	//		}
	//	}
	//}
}

void Func(int* arr, int n, int max, int* result)
{
	if (n == 0)
	{
		*result+=1;
		return;
	}

	bool fail;
	for (int i = 0; i < max; i++)
	{
		fail = 0;
		for (int j = max - n - 1; j >= 0; j--)
		{
			if(arr[j] + ((max-n)-j) == i|| arr[j] - ((max-n)-j) == i||arr[j]==i)
			{	
				fail = 1;
				break;
			}
		}
		if (!fail)
		{
			arr[max - n] = i;
			Func(arr, n - 1, max, result);
		}
	}

}

int main()
{
	int n;
	int result = 0;
	cin >> n;
	int arr[9];
	Func(arr, n, n, &result);
	cout << result;
}
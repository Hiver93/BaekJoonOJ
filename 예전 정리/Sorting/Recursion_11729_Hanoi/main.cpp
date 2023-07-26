#include <iostream>
using namespace std;

void Func(int n,int start, int mid, int end)
{
	if (n == 1)
	{
		printf("%d %d\n", start, end);
		return;
	}	
	Func(n - 1, start, end, mid);
	printf("%d %d\n", start, end);
	Func(n - 1, mid, start, end);	
}

int main()
{
	int a;
	cin >> a;
	int result = 1;
	for (int i = 0; i < a; i++)
	{
		result *= 2;
	}
	cout << result-1 << endl;
	Func(a, 1, 2, 3);
}
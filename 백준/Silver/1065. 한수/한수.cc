#include <iostream>
using namespace std;

int main()
{
	int n = 0;
	int count = 0;

		cin >> n;
	
		for (int i = 1; i <= n; i++)
		{
			if (i < 100)
			{
				count++;
			}
			
			else if (i % 10 - i / 10 % 10 == i / 10 % 10 - i / 100)
			{
				count++;
			}
		}
	
		cout << count;
		return 0;
}
#include <iostream>
using namespace std;

int main()
{
	int N;
	cin >> N;

	int CN = N;

	if (N == 3)
	{
		cout << 1 << endl;
		return 0;
	}

	else if (N == 4)
	{
		cout << -1 << endl;
		return 0;
	}

	if (N % 5 == 0)
	{
		cout << N / 5 << endl;
	}

	else if ((N % 5) % 3 == 0)
	{
		cout << (N / 5) + ((N % 5) / 3) << endl;
	}

	else
	{
		CN = N % 5;
		while (CN != N)
		{
			CN = CN + 5;
			
			if (CN % 3 == 0)
			{
				cout << ((N - CN) / 5) + (CN / 3) << endl;
				return 0;
			}
		}
        
        	if (N % 3 == 0)
	    {
		    cout << N / 3 << endl;
	    }
           else
	  	    cout << -1 << endl;
	}

	return 0;
}
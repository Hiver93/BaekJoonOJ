#include <iostream>
using namespace std;
int main()
{
	int n;
	cin >> n;
	int t=0, f=0;
	for (int i = n; i >= 2; --i)
	{
		t += i / 2;
		f += i / 5;
	}

	if (t < f)
		cout << t << endl;
	else
		cout << f << endl;
	
}
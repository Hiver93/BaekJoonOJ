#include<iostream>

int main()
{
	int N;
	int m=0;
	int t = 0;
	std::cin >> N;
	m = N;

	while (1)
	{	
		t++;
		N =(N % 10 + (N - N % 10)/10)%10 + (N % 10)*10;


		if (m==N)
			break;
	}
	std::cout << t;
	return 0;
}

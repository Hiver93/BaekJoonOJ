#include<iostream>
using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	int total = (1 << 10) - 1;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n;
		cin >> n;

		int visited = 0; 
		int count = 0; // 이때까지 본 수의 개수((N
		for (count = 1;; count++) 
		{
			int tmp = n * count;
			while (tmp != 0)
			{
				visited = visited | (1 << (tmp % 10));
				tmp /= 10;
			}
			if (visited == total)
				break;
		}

		cout << "#" << test_case << " " << n * count << endl;

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}
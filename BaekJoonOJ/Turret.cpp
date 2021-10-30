#include <iostream>

int main()
{
	int T;
	std::cin >> T;
	for (int i = 0; i < T; i++)
	{
		int arr1[3];
		int arr2[3];

		std::cin >> arr1[0] >> arr1[1] >> arr1[2];
		std::cin >> arr2[0] >> arr2[1] >> arr2[2];

		if (arr1[0] == arr2[0] && arr1[1] == arr2[1] && arr1[2] == arr2[2])
		{
			std::cout << -1 << std::endl;
			continue;
		}

		int disSq;
		int rDis = arr1[2] + arr2[2];
		

		disSq = (arr2[0] - arr1[0]) * (arr2[0] - arr1[0]) + (arr2[1] - arr1[1]) * (arr2[1] - arr1[1]);

		int j = 1;
		while(disSq / j > j)
		{
			j++;		
		}


		if (rDis < j)
		{
			std::cout << 0 << std::endl;
		}
		else if (rDis == j)
		{
			if (j * j == disSq)
			{
				std::cout << 1 << std::endl;
			}
			else
			{
				std::cout << 0 << std::endl;
			}
		}
		else
		{
			std::cout << 2 << std::endl;
		}
	}

	return 0;

}
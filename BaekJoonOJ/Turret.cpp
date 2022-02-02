#include <iostream>
#include <vector>
#include <stdio.h>

// 무언가 - 일때 문제가 될 것 같음
int main()
{
	int t;
	std::cin >> t;	
	for (int k = 0; k < t; k++)
	{
		bool isFitNum = 0;
		int distance;
		int detectSum;
		int root = 0;
		std::vector<int> vec1(3);
		std::vector<int> vec2(3);

		for (int i = 0; i < 3; i++)
		{
			std::cin >> vec1[i];
		}
		for (int i = 0; i < 3; i++)
		{
			std::cin >> vec2[i];
		}
		
		if (vec1[0] == vec2[0] && vec1[1] == vec2[1])
		{
			if (vec1[2] == vec2[2])
			{
				if (vec1[2] == 0)
				{
					std::cout << 1 << std::endl;
					continue;
				}
				std::cout << -1 << std::endl;
				continue;
			}
			else
			{
				std::cout << 0 << std::endl;
				continue;
			}
		}

		distance = (vec1[0] - vec2[0])* (vec1[0] - vec2[0]) + (vec1[1] - vec2[1]) * (vec1[1] - vec2[1]);
		detectSum = (vec1[2] + vec2[2]) * (vec1[2] + vec2[2]);

		if (vec1[2] == 0)
		{
			if (vec2[2] * vec2[2] == distance)
			{
				std::cout << 1 << std::endl;
				continue;
			}
			else
			{
				std::cout << 0 << std::endl;
				continue;
			}
		}

		if (vec2[2] == 0)
		{
			if (vec1[2] * vec1[2] == distance)
			{
				std::cout << 1 << std::endl;
				continue;
			}
			else
			{
				std::cout << 0 << std::endl;
				continue;
			}
		}




		while (root * root < distance)
		{
			root++;
		}
		root--;
		if (root * root == distance)
		{
			isFitNum = 1;
		}

		if (vec1[2] < vec2[2])
		{
			if (root + vec1[2] < vec2[2])
			{
				std::cout << 0 << std::endl;
				continue;
			}
			if (root + vec1[2] == vec2[2])
			{
				if (isFitNum)
				{
					std::cout << 1 << std::endl;
					continue;
				}
				else
				{
					std::cout << 2 << std::endl;
					continue;
				}
			}
		}
		if (vec2[2] < vec1[2])
		{
			if (root + vec2[2] < vec1[2])
			{
				std::cout << 0 << std::endl;
				continue;
			}
			if (root + vec2[2] == vec1[2])
			{
				if (isFitNum)
				{
					std::cout << 1 << std::endl;
					continue;
				}
				else
				{
					std::cout << 2 << std::endl;
					continue;
				}
			}
		}

		if (distance == detectSum)
		{
			std::cout << 1 << std::endl;
			continue;
		}
		else if (distance < detectSum)
		{
			std::cout << 2 << std::endl;
			continue;
		}
		else if (distance > detectSum)
		{
			std::cout << 0 << std::endl;
			continue;
		}
	}
	return 0;
}
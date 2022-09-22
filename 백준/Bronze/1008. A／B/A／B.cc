#include <iostream>

int main()
{
	long double A, B;
	std::cin >> A >> B;

	std::cout.fixed;
	std::cout.precision(16);
	std::cout << A / B;
}
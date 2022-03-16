#include <iostream>

int check[101][101][101] = { 0 };

int W(int a, int b, int c)
{
	if (check[a+50][b + 50][c + 50])
		return check[a + 50][b + 50][c + 50];
	if (a <= 0 || b <= 0 || c <= 0)
	{
		check[a + 50][b + 50][c + 50] = 1;
		return 1;
	}
	if (a > 20 || b > 20 || c > 20)
	{
		int temp = W(20, 20, 20);
		check[a + 50][b + 50][c + 50] = temp;
		return W(20, 20, 20);
	}
	if (a < b && b < c)
	{
		int temp = W(a, b, c - 1) + W(a, b - 1, c - 1) - W(a, b - 1, c);
		check[a + 50][b + 50][c + 50] = temp;
		return temp;
	}
	else
	{
		int temp = W(a - 1, b, c) + W(a - 1, b - 1, c) + W(a - 1, b, c - 1) - W(a - 1, b - 1, c - 1);
		check[a + 50][b + 50][c + 50] = temp;
		return temp;
	}
}

int main()
{
	int a, b, c;
	std::cin >> a >> b >> c;
	while (!(a == -1 && b == -1 && c == -1))
	{
		printf("w(%d, %d, %d) = %d\n",a,b,c,W(a, b, c));
		std::cin >> a >> b >> c;
	}
}
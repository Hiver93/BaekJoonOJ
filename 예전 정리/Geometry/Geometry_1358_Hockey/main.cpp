#include <iostream>
using namespace std;
int main() 
{
	int w, h, x, y, p;
	cin >> w >> h >> x >> y >> p;
	int r = h / 2;
	if (r < 0) r = -r;
	int px, py;
	int ans = 0;


	for (int i = 0; i < p; ++i)
	{
		cin >> px >> py;
		if (x <= px && px <= x + w && y <= py && py <= y + h)
		{
			ans++;
		}
		else if (px < x)
		{
			if ((x - px) * (x - px) + (y + r - py) * (y + r - py) <= r * r)
			{
				ans++;
			}
		}
		else if (x + w < px)
		{
			if ((x + w - px) * (x + w - px) + (y + r - py) * (y + r - py) <= r * r)
			{
				ans++;
			}
		}
	}
	cout << ans;
}
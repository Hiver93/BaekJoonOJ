#include <iostream>
using namespace std;

class Body {
public:
	int x, y;
	Body* next;
	Body(int x, int y)
	{
		this->x = x;
		this->y = y;
	}
};

int main()
{
	Body* head = new Body(0,0);
	Body* tail = head;
	tail->next = head;
	int ans = 0;
	int n, k, l;
	int dr[4]{ 0,1,0,-1 };
	int dc[4]{ 1,0,-1,0 };
	int direct = 0;
	int ground[100][100]{ 1,0 };
	char d;
	cin >> n >> k;
	for (int i = 0; i < k; ++i)
	{
		int x, y;
		cin >> y >> x;
		ground[y-1][x-1] = 2;
	}

	cin >> l;
	for (int i = 0; i < l; ++i)
	{
		int time;
		d;
		cin >> time >> d;
		while (time != ans)
		{
			for (int j = 0; j < n; ++j)
			{
				for (int k= 0; k < n; ++k)
				{
					cout << ground[j][k] << ' ';
				}
				cout << endl;
			}
			ans++;
			int nX = head->x + dc[direct];
			int nY = head->y + dr[direct];
			if (nX < 0 || n <= nX || nY < 0 || n <= nY)
			{
				cout << ans << endl;
				return 0;
			}

			if (ground[nY][nX] == 1)
			{
				cout << ans << endl;
				return 0;
			}
			if (ground[nY][nX] == 2)
			{
				Body* tmp = head;
				head = new Body(nX, nY);
				tmp->next = head;
			}
			else
			{
				ground[tail->y][tail->x] = 0;
				Body* tmp = tail;
				tail = tail->next;
				head->next = tmp;
				head = tmp;
				head->x = nX;
				head->y = nY;
			}
			ground[head->y][head->x] = 1;
		}
		if (ans == time)
		{
			if (d == 'D')
				direct++;
			else if (d == 'L')
				direct--;
			if (direct == -1)
				direct = 3;
			else
				direct %= 4;
		}
	}

	while (1)
	{
		for (int j = 0; j < n; ++j)
		{
			for (int k = 0; k < n; ++k)
			{
				cout << ground[j][k] << ' ';
			}
			cout << endl;
		}
		ans++;
		int nX = head->x + dc[direct];
		int nY = head->y + dr[direct];
		if (nX < 0 || n <= nX || nY < 0 || n <= nY)
		{
			cout << ans << endl;
			return 0;
		}

		if (ground[nY][nX] == 2)
		{
			Body* tmp = head;
			head = new Body(nX, nY);
			tmp->next = head;
		}
		else
		{
			ground[tail->y][tail->x] = 0;
			Body* tmp = tail;
			tail = tail->next;
			head->next = tmp;
			head = tmp;
			head->x = nX;
			head->y = nY;
		}
		if (ground[nY][nX] == 1)
		{
			cout << ans << endl;
			return 0;
		}
		ground[head->y][head->x] = 1;
	}
	cout << ans << endl;
}
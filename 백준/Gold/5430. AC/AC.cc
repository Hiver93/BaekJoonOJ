#include <iostream>
#include <vector>
#include <string>
#include <cstring>
using namespace std;

int main()
{
	int n;
	cin >> n;
	for (int tc = 0; tc < n; ++tc)
	{
		int idx = 0;
		int dir = 0;
		string cmd;
		int size;
		string str;
		cin >> cmd >> size;
		vector<char*> v(size);
		int st = 0;
		int ed = size-1;
		cin.ignore();
		getline(cin, str);
        char* next;
		char* ptr = strtok_r((char*)str.c_str(), " [],",&next);
		while (ptr != nullptr)
		{
			v[idx++] = ptr;
			ptr = strtok_r(nullptr, " [],",&next);
		}
		for (int i = 0; i < cmd.size(); ++i)
		{
			if (cmd[i] == 'R')
				dir ^= 1;
			else
				if (dir == 0)
					st++;
				else
					ed--;
		}
		if (ed < st)
		{
			if (st - ed == 1)
			{
				printf("[]\n");
				continue;
			}
			printf("error\n");
			continue;
		}
		printf("[");
		if (dir == 0)
		{
			for (int i = st; i <= ed - 1; ++i)
				printf("%s,",v[i]);
			printf("%s", v[ed]);
		}
		else
		{
			for(int i = ed; i > st; --i)
				printf("%s,", v[i]);
			printf("%s", v[st]);
		}
		printf("]\n");
				

	}
}
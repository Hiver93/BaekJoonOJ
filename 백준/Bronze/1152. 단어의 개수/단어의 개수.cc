#include <iostream>
#include<string>
using namespace std;

int main()
{
	string str;
	getline(cin, str);
	int i = 1;
	int count = 1;


	while (str[i] != '\0')
	{
		if (str[i] == ' ')
			count++;


		i++;
	}
	if (str[i - 1] == ' ')
		count--;

	cout << count;

	return 0;
}
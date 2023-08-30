#include <iostream>
using namespace std;

int main()
{
	char cro[101];
	cin >> cro;
	int count=0;

	

	for (int i = 0; i < 101; i++)
	{
		if (cro[i] == 'c'&&cro[i + 1] == '=')
			continue;

		else if (cro[i] == 'c'&&cro[i + 1] == '-')
			continue;

		else if (cro[i] == 'd'&&cro[i + 1] == 'z'&&cro[i + 2] == '=')
			continue;

		else if (cro[i] == 'd'&&cro[i + 1] == '-')
			continue;

		else if (cro[i] == 'l'&&cro[i + 1] == 'j')
			continue;

		else if (cro[i] == 'n'&&cro[i + 1] == 'j')
			continue;

		else if (cro[i] == 's'&&cro[i + 1] == '=')
			continue;

		else if (cro[i] == 'z'&&cro[i + 1] == '=')
			continue;

		else if (cro[i] == '\0')
			break;

		count++;		
	}

	cout << count << endl;

	return 0;
}
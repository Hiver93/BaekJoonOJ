#include <iostream>
#include <algorithm>
using namespace std;

int chiken[8];
int result[8];
int n;
int check = 0;
int m;
void func(int c) {
	if (c == m) {
		for (int i = 0; i < c; ++i) {
			printf("%d ", result[i]);
		}
		printf("\n");
		return;
	}
	for (int i = 0; i < n; ++i) {
		if ((check & (1 << i)) != 0)
			continue;
		check |= (1 << i);
		result[c] = chiken[i];
		func(c + 1);
		check ^= (1 << i);
	}

}
int main()
{
	cin >> n;
	cin >> m;	
	for (int i = 0; i < n; ++i) {
		cin >> chiken[i];
	}
	sort(chiken,chiken+n);
	func(0);	
}
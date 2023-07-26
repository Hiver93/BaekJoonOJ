#include<iostream>
#include<queue>
using namespace std;
int arr[300000][3];
class C{
	int cost;
	bool operator<(const C c) const {
		 return this->cost > c.cost;
	}
};
int main()
{
	priority_queue<C> pq;

}
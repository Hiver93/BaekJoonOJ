#include <iostream>
using namespace std;

int q[5001]{ 0 };
int front = 0;
int rear = 0;

void push(int data) {
	q[rear++] = data;
	rear = rear < 5001 ? rear : 0;
}

int pop() {
	int r = q[front++];
	front = front < 5001 ? front : 0;
	return r;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, k;
	cin >> n >> k;
	for (int i = 0; i < n; ++i) {
		push(i + 1);
	}

	int cnt = 0;
	cout << '<';
	while (rear - front != 1 && front - rear != 5000) {
		cnt++;
		int tmp = pop();
		if (cnt == k) {
			cout << tmp << ", ";
			cnt = 0;
		}
		else {
			push(tmp);
		}

	}
	cout << pop() << '>';
}
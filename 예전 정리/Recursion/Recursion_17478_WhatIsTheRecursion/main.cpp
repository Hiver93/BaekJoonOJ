#include <iostream>
using namespace std;

void Func(int n, int current)
{

	
	for (int i = 0; i < current; ++i) 
	{
		cout << "____";
	}
	cout << "\"����Լ��� ������?\"" << endl;
	if (current == n)
	{
		for (int i = 0; i < current; ++i)
		{
			cout << "____";
		}
		cout << "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"\n";
		for (int i = 0; i < current; ++i)
		{
			cout << "____";
		}
		cout << "��� �亯�Ͽ���.\n";
		return;

	}
	for (int i = 0; i < current; ++i)
	{
		cout << "____";
	}
	cout << "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.\"\n";
	for (int i = 0; i < current; ++i) 
	{
		cout << "____";
	}
	cout << "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.\n";
	for (int i = 0; i < current; ++i) 
	{
		cout << "____";
	}
	cout << "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"\n";
	
	Func(n, current + 1);
	for (int i = 0; i < current; ++i) 
	{
		cout << "____";
	}
	cout << "��� �亯�Ͽ���.\n";
}

int main() 
{
	int n;
	cin >> n;
	cout << "��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������." << endl;
	Func(n,0);

}
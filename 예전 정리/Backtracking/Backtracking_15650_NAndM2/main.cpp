#include <iostream>
using namespace std;

void func(int start, int* arr, int n, int m, int count)
{
    if (count == 0)
    {
        for (int i = 0; i < m; i++)
        {
            cout << arr[i] << ' ';
        }
        cout << endl;
        return;
    }
    arr[m - count] = start;
    if (start + count - 1 <= n)
    {
        func(start + 1, arr, n, m, count - 1);
    }
    if (start + count <= n)
    {
        func(start + 1, arr, n, m, count);
    }
}

int main()
{
    int n, m;
    cin >> n >> m;
    int* arr = new int[m];

    func(1, arr, n, m, m);
    delete[] arr;
    return 0;
}
#include <iostream>
using namespace std;

void func(int start, int* arr, int n, int m, int count)
{
    arr[m - count] = start;
    if (count == 1)
    {
        for (int i = 0; i < m; i++)
        {
            printf("%d ", arr[i]);
        }
        printf("\n");
    }
    if (count > 1)
    {
        func(start, arr, n, m, count - 1);
    }
    if (start < n)
        func(start + 1, arr, n, m, count);

}

int main()
{
    int n, m;
    cin >> n >> m;
    int arr[8];

    func(1, arr, n, m, m);
    return 0;
}
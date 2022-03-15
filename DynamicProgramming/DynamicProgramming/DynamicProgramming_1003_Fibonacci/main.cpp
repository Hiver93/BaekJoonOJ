#include <iostream>
using namespace std;

void fibonacci(int n, int* arr0, int* arr1, bool* c)
{
    if (n == 0)
        return;
    if (n == 1)
        return;
    if (!c[n - 2])
    {
        fibonacci(n - 2, arr0, arr1, c);
    }
    if (!c[n - 1])
    {
        fibonacci(n - 1, arr0, arr1, c);
    }

    arr0[n] = arr0[n - 2] + arr0[n - 1];
    arr1[n] = arr1[n - 2] + arr1[n - 1];
    c[n] = 1;

}

int main()
{
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        int n, m;
        cin >> n;
        int arr0[40]{ 0 };
        int arr1[40]{ 0 };
        bool c[40]{ 0 };
        c[0] = 1;
        c[1] = 1;
        arr0[0] = 1;
        arr1[1] = 1;

        fibonacci(n, arr0, arr1, c);

        cout << arr0[n] << ' ' << arr1[n] << endl;
    }
    return 0;
}
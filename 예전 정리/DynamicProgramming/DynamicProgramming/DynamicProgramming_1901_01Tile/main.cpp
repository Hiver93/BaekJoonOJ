#include <iostream>
using namespace std;

int arr[1000001]{ 1,1,2,3,5,0 };
int Func(int n)
{
    if (arr[n])
    {
        return arr[n];
    }
    if (!arr[n - 1])
    {
        Func(n - 1);
    }
    if (!arr[n - 2])
    {
        Func(n - 2);
    }
    int result = (arr[n - 1] + arr[n - 2]) % 15746;
    arr[n] = result;
    return result;
}

int main()
{
    int n;
    cin >> n;
    cout << Func(n);
    return 0;
}
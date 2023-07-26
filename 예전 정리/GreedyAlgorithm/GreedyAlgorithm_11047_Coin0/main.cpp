#include <iostream>
using namespace std;

int main()
{
    int n, v;
    int arr[10];
    int ans = 0;
    cin >> n >> v;

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    for (int i = n - 1; i >= 0; i--)
    {
        while (v - arr[i] >= 0)
        {
            v -= arr[i];
            ans++;
        }
    }

    cout << ans;
}
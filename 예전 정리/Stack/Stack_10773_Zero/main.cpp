#include <iostream>
#include <string>
using namespace std;

int main()
{
    long long arr[100000];
    int top = 0;
    int n;
    int num;
    int ans = 0;
    cin >> n;

    while (n--)
    {
        cin >> num;
        if (num)
        {
            arr[top] = num;
            ans += arr[top++];
        }
        else
        {
            ans -= arr[--top];
        }
    }
    cout << ans;
}
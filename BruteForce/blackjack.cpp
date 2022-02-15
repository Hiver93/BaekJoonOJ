#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n, m, r = 0;
    cin >> n >> m;

    vector<int> arr(n);

    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                if (arr[i] + arr[j] + arr[k] <= m &&
                    r < arr[i] + arr[j] + arr[k])
                {
                    r = arr[i] + arr[j] + arr[k];
                }
            }
        }
    }

    cout << r;
    return 0;
}
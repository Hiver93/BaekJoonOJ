#include <iostream>
using namespace std;

int main()
{
    int n, k;
    int w[100];
    int v[100];
    int check[100001]{ 0 };

    cin >> n >> k;

    for (int i = 0; i < n; i++)
    {
        cin >> w[i] >> v[i];
    }


    for (int i = 0; i < n; i++)
    {
        if (check[w[i]])
        {
            if (w[i] * 2 <= k && check[w[i] * 2] < v[i] + check[w[i]])
            {
                check[w[i] * 2] = v[i] + check[w[i]];
            }
        }
        if (check[w[i]] < v[i])
            check[w[i]] = v[i];

        for (int j = k - w[i]; j > 0; j--)
        {
            if (!check[j] || j == w[i])
                continue;
            if (check[w[i] + j] < check[j] + v[i])
            {
                check[w[i] + j] = check[j] + v[i];
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= k; i++)
    {
        if (check[i] > ans)
            ans = check[i];
    }
    cout << ans;
}
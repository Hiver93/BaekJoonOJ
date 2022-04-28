#include <iostream>
using namespace std;

long long check[1000]{ 0 };
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    long long temp, sum;
    long long ans = 0;
    cin >> n >> m;
    cin >> sum;
    check[sum % m]++;

    for (int i = 1; i < n; i++)
    {
        cin >>temp;
        sum += temp;
        check[sum % m]++;
    }
    ans += check[0];
    for (int i = 0; i < m; i++)
    {
        ans += check[i] * (check[i] - 1) / 2;
    }
    cout << ans;
}
#include <iostream>
using namespace std;

int main()
{
    long long xMin = 10000, xMax = -10000, yMin = 10000, yMax = -10000;
    int n;
    cin >> n;
    for (int i = 0; i < n; ++i)
    {
        long long t1, t2;
        cin >> t1 >> t2;
        if (t1 < xMin)
            xMin = t1;
        if (xMax < t1)
            xMax = t1;
        if (t2 < yMin)
            yMin = t2;
        if (yMax < t2)
            yMax = t2;
    }
    long long ans = (xMax - xMin) * (yMax - yMin);
    cout << ((ans < 0) ? ans * -1 : ans);
}
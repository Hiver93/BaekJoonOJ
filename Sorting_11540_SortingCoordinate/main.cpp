#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool func(int a[2], int b[2])
{
    if (a[0] == b[0])
    {
        return a[1] < b[1];
    }
    return a[0] < b[0];
}

int main()
{
    int n;
    cin >> n;
    int** xy = new int* [n];

    for (int i = 0; i < n; i++)
    {
        xy[i] = new int[2];
        cin >> xy[i][0];
        cin >> xy[i][1];
    }

    sort(xy, xy + n, func);
    for (int i = 0; i < n; i++)
    {
        cout << xy[i][0] << ' ';
        cout << xy[i][1] << '\n';
    }

    for (int i = 0; i < n; i++)
    {
        delete xy[i];
    }
    delete xy;

    return 0;

}
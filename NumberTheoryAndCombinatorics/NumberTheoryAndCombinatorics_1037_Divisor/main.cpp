#include<iostream>
using namespace std;

int main()
{
    int n;
    int min = 2147000000;
    int max = 0;
    cin >> n;
    int input;
    if (n == 1)
    {
        cin >> input;
        cout << input * input;
        return 0;
    }
    for (int i = 0; i < n; i++)
    {
        cin >> input;
        if (input < min)
            min = input;
        if (max < input)
            max = input;
    }
    cout << min * max;
    return 0;
}
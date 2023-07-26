#include <iostream>
#include <string>
using namespace std;

int main()
{
    int arr[10000];
    int top = 0;
    int n;
    string str;
    cin >> n;

    while (n--)
    {
        cin >> str;
        if (!str.compare("push"))
            cin >> arr[top++];
        else if (!str.compare("pop"))
        {
            if (!top)
                cout << -1 << endl;
            else
                cout << arr[--top] << endl;
        }
        else if (!str.compare("top"))
        {
            if (!top)
                cout << -1 << endl;
            else
                cout << arr[top - 1] << endl;
        }
        else if (!str.compare("empty"))
        {
            cout << !(bool)top << endl;
        }
        else
            cout << top << endl;


    }
}
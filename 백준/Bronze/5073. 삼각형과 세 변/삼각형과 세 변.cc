#include <iostream>
using namespace std;

int main()
{
    int a, b, c;
    cin >> a >> b >> c;
    while (a + b + c != 0)
    {
        if (c < a + b && a < c + b && b < a + c)
        {
            if (a == b && b == c)
                cout << "Equilateral" << endl;
            else if (a == b || b == c || a == c)
                cout << "Isosceles" << endl;
            else
                cout << "Scalene" << endl;
        }
        else
        {
            cout << "Invalid" << endl;
        }
        cin >> a >> b >> c;
    }
}
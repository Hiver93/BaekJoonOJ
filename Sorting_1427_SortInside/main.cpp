#include <iostream>
#include <string>
using namespace std;

int main()
{
    string str;
    cin >> str;
    char c;
    for (int i = 0; i < str.length(); i++)
    {
        for (int j = i + 1; j < str.length(); j++)
        {
            if (str[i] < str[j])
            {
                c = str[i];
                str[i] = str[j];
                str[j] = c;
            }
        }
    }
    cout << str;
}
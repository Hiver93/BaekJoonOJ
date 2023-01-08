#include <iostream>
#include <string>
using namespace std;

int main()
{
    int n;
    int check = 0;
    string str;
    
    cin >> n;
    while(n--)
    {
        cin>>str;
        for(int i = 0; i < str.length(); i++)
        {
            if(str[i] == '(')
            {
                check++;
            }
            else
            {
                check--;
                if(check < 0)
                {                   
                    break;
                }
            }
        }
        if(!check)
            cout << "YES" << endl;
        else
            cout << "NO" << endl;
        check = 0;
    }
}
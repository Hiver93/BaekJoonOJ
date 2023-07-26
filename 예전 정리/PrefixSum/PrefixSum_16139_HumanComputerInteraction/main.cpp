#include <iostream>
#include <string>
using namespace std;

int arr[26][200000]{ 0 };
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    string str;
    int t;
    char q;
    int m, n;
    cin >> str;
    cin >> t;
    int len = str.length();
    arr[str[0] - 'a'][0] = 1;
    for (int i = 1; i < len; i++)
    {
        arr[str[i] - 'a'][i] = 1;
        for (int j = 0; j < 26; j++)
        {
            arr[j][i] += arr[j][i - 1];
        }
    }
    for (int i = 0; i < t; i++)
    {
        cin >> q >> m >> n;
        if (!m)
        {
            printf("%d\n", arr[q - 'a'][n]);
        }
        else
            printf("%d\n", arr[q - 'a'][n] - arr[q - 'a'][m - 1]);
    }


}
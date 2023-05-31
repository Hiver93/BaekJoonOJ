#include <iostream>
using namespace std;

long long f(long long n)
{
    if(n == 0)
        return 1;
    
    return n * f(n-1);
}

int main()
{
    long long n;
    cin >> n;
    cout << f(n);
}
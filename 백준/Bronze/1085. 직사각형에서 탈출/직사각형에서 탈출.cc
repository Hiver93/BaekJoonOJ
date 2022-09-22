#include<iostream>
using namespace std;


int main()
{
    int x,y,w,h;
    int xD, yD;
    cin >> x >> y >> w >> h;
    
    if(w-x < x)
      xD = w-x;
    else
      xD = x;
    if(h-y < y)
      yD = h-y;
    else
      yD = y;
    
    if(xD < yD)
      cout << xD;
    else
      cout << yD;
}
#include <stdio.h>
int main()
{
    int n;
    int sum = 0;
    scanf("%d", &n);
    while(n != 0)
    {
        sum = sum + n;
        n--;
    }
    printf("%d\n", sum);
}
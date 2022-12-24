#include <stdio.h>

int main()
{
    int n, a, b, i;
    i = 1;
    scanf("%d", &n);
    while(i <= n)
    {
        scanf("%d %d", &a, &b);
        printf("Case #%d: %d + %d = %d\n", i, a, b, a+b);
        i++;
    }
}
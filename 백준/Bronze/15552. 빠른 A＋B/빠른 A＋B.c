#include <stdio.h>

int main()
{
    int N;
    int a;
    int b;
    int i = 1;
    scanf ("%d", &N);
    while (i <= N)
    {
        scanf("%d %d", &a, &b);
        printf("%d\n", a + b);
        i++;
    }
}
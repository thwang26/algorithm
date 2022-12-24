#include <stdio.h>

int main()
{
    int n;
    int i, j;
    i = 1;
    scanf("%d", &n);
    while(i <= n)
    {
        j = i;
        while(j != 0)
        {
            printf("*");
            j--;
        }
        printf("\n");
        i++;
    }
}
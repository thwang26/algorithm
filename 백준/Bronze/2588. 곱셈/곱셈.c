#include <stdio.h>

int main()
{
    int A, B;
    scanf("%d%d", &A, &B);
    printf("%d\n", (B % 10)* A);
    printf("%d\n", ((B/10) % 10)*A);
    printf("%d\n", ((B/100) % 10)*A);
    printf("%d\n", B*A);
}
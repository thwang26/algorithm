 #include <stdio.h>

void top(int n, int from, int tmp, int to)
{
    if (n==1)
        printf("%d %d\n", from, to);
    else
    {
        top(n-1, from, to, tmp);
        printf("%d %d\n", from, to);
        top(n-1, tmp, from, to);
    }
}
int main()
{
    int n, N, k = 1;
    scanf("%d", &n);
    N = n;
    while(N != 0)
    {
        k = k*2;
        N--;
    }
    printf("%d\n", k-1);
    top(n, 1, 2, 3);
}
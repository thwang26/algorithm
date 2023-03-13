#include <stdio.h>

int main(){
    int cnt = 0, N;
    scanf("%d", &N);
    
    while(N % 3 != 0 && N % 5 != 0){
        N -= 5;
        cnt++;
        if (N < 3){
            printf ("-1");
            return (0);
        }
    }
    if ((N % 15) % 5 == 0 || (N % 15) % 3 == 0){
        cnt += (N/15)*3;
        N = N%15;
    }
    if (N % 5 == 0)
        printf ("%d", N/5+cnt);
    else
        printf ("%d", N/3+cnt);
}
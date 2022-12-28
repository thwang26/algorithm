#include <stdio.h>

int main()
{
    int n, i, j;
    scanf("%d", &n);
    int phy[n*2], grade[n];
    for(int i = 0;i < n;i++){
        scanf("%d %d", &phy[i*2], &phy[i*2+1]);
        grade[i] = 1;
    }
    for(i = 0;i < n;i++){
        for(j = 0;j < n;j++){
            if(phy[i*2]<phy[j*2] && phy[i*2+1]<phy[j*2+1])
                grade[i]++;
        }
    }
    for(i = 0;i < n;i++)
        printf("%d ", grade[i]);
}
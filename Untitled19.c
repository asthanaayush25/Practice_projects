#include<stdio.h>
void main()
{
int n;
printf("Enter the number:\t");
scanf("%d",&n);
int k=(n*(n+1)/2)+n;
char c[20]="*******************************";

int i;
int a=3;
for(i=1;i<k;i+=a++)
c[i]='\n';
c[i]='\0';
printf("%s",c);
}

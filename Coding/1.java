//a = 4, b=3
int fun(int a, int b){
    if(a==0)
        return 1;
    if(b%2==0)
        return fun(a*a,b/2);
    return fun(a*a,b/2)*2;
}
//output ??
//n=99
int fun(int n){
    if(n>100)
        return n-10;
    return fun(fun(n+11));
}
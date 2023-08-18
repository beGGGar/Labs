clear; clc;
syms n;
n = 4;
e0 = 0.0001; e = 1;
f = @(x)(-1)^(x-1)/x/(x+1);
while e > e0
    n = n+1;
    for i = 1:1:n*2
    F(i) = f(i);
    end
    S(1) = F(1);
    for j = 2:1:n*2
    S(j) = S(j-1)+F(j);
    end
    e = abs(S(2*n)-S(n));
end

n
S(n)
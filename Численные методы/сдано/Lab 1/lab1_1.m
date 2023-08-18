clear; clc;
p = poly(1:20);
roots(p)
p(2) = p(2) + 10^-7;
roots(p)

2^1023
2^1024
max = realmax
min = realmin
format long e
sqrt2 = sqrt(2) 
10^8+10^-7
10^8+10^-8
G1 = 1 + (10^(-16))*(10^17)
G2 = 1;
for i = 1:1:10^3
    G2 = G2+10^(-16);
end
G2
f = @(n)(1+2^(-n)-1)/2^(-n);
for n = 40:1:60

    fprintf('n = %d, g = %f \n', n, f(n))
end
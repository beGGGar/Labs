function I = intSimpson2(F, a, b, n)
if mod(n, 2) ~= 0
    n = n + 1;
end
h = (b-a)/(n-1);
x = a:h:b;
coeff = [1, repmat([4, 2], 1, (n-2)/2), 1];
I = F(x).*coeff.*h./3;
I = double(sum(I));
end
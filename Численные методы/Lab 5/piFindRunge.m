function [I2, n] = piFindRunge(f, a, b, eps)
n = 2; 
I1 = intSimpson2(f, a, b, n);
I2 = intSimpson2(f, a, b, 2*n);
delta = abs(I1 - I2);

for i = [5000, 1000, 100, 10, 2]
    while delta>eps
        n = n + i;
        I1 = intSimpson2(f, a, b, n);
        I2 = intSimpson2(f, a, b, n*2);
        delta = abs(I1 - I2);
    end
    n = n - i;
end
end
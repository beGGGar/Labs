function [I, n] = piFind(f, a, b, eps)
n = 2; old = inf;
I = intSimpson2(f, a, b, n);


for i = [100, 10, 2]
    while abs(I - old)>=eps
        old = I;
        n = n + i;
        I = intSimpson2(f, a, b, n);
    end
    n = n - i;
end
end
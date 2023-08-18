function [x0, n] = lab2_1_4f(f,x0, eps)
N = 100; n = 0;
x = subs(f, x0);
while n<N
    if abs(x-x0)<eps
        break;
    end
    x = x0;
    x0 = double(subs(f, x0));
    n = n + 1;
end
x0 = double(x0);
end
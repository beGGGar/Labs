function S = MV_3f(a, b, f, n, r)
step=(b-a)/n;
syms x;
S = 0;
if r == 0
    for i = a:step:b-step
        S = S+step*subs(f, x, i);
    end
end
if r == 1
    for i = a+step:step:b
        S = S+step*subs(f, x, i);
    end
end
S = double(S);
end
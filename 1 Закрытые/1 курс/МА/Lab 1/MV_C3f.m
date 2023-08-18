function S = MV_3f(a, b, f, n, L)
step=(b-a)/n;
syms x;
S = 0;
for i = a:step:b-step
        S = S+step*subs(f, x, i+step*L);
end
end
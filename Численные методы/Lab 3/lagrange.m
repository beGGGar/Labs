function P = lagrange(f, x0, t)
y = subs(f, t, x0);
n = length(x0); P = 0;
for i = 1 : n
    Pbuff = y(i);
    for j = 1 : n
        if i~=j
            Pbuff = Pbuff*(t - x0(j))/(x0(i) - x0(j));
        end
    end
    P = P + Pbuff;
end
end
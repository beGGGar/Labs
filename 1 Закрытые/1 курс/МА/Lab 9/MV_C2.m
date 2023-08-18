close all; clear; clc;
syms x y k

z = x^2 + 12*x*y + 2*y^2;
phy = 4*x.^2 + y.^2 - 25;
L = z + k*phy;
s = solve(diff(L, x), diff(L, y), phy, 'k, x, y');

M = [0, diff(phy, x), diff(phy, y); 
    diff(phy, x), diff(L, x, 2), diff(diff(L, x), y); 
    diff(phy, y), diff(diff(L, y), x), diff(L, y, 2)];

min0 = 1; max0 = 1;
for q = 1:1:size(s.k)
    for i = 1:1:size(s.x)
        for j = 1:1:size(s.y)
            p = [s.x(i), s.y(j)];
            m = det(subs(M, [k, [x, y]], [s.k(q), p]));
            
            if imag(m)==0
                if m > 0
                    min(min0, 1:3) = [p, s.k(q)];
                    min0 = min0+1;
                end

                if m < 0
                    max(max0, 1:3) = [p, s.k(q)];
                    max0 = max0+1;
                end
            end
        end
    end
end
max
min
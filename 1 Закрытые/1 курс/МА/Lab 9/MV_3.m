close all; clear; clc; 
syms k1 k2 x y
z1 = x^3/3 + y^3/3;
phy1 = x+4*y-1;
L1 = z1 + k1*phy1;
s = solve(diff(L1, x), diff(L1, y), phy1, 'k1, x, y');

M1 = [0, diff(phy1, x), diff(phy1, y); 
    diff(phy1, x), diff(L1, x, 2), diff(diff(L1, x), y); 
    diff(phy1, y), diff(diff(L1, y), x), diff(L1, y, 2)];

min0 = 1; max0 = 1;
for i = 1:1:size(s.x)
    for j = 1:1:size(s.y)
        for k = 1:1:size(s.k1)
            p = [s.x(i), s.y(j)];
            m = det(subs(M1, [k1, [x, y]], [s.k1(k), p]));
            
            if imag(m)==0
                if m > 0
                    min1(min0, 1:2) = p;
                    min0 = min0+1;
                end

                if m < 0
                    max1(max0, 1:2) = p;
                    max0 = max0+1;
                end
            end
        end
    end
end
max1
min1

z2 = (x+1)^2 + y^2;
phy2 = y^2-x^3;
L2 = z2 + k2*phy2;

M2 = [0, diff(phy2, x), diff(phy2, y); 
    diff(phy2, x), diff(L2, x, 2), diff(diff(L2, x), y); 
    diff(phy2, y), diff(diff(L2, y), x), diff(L2, y, 2)];

s = solve(diff(L2, x), diff(L2, y), phy2, 'k2, x, y');
min0 = 1; max0 = 1;
for i = 1:1:size(s.x)
    for j = 1:1:size(s.y)
        for k = 1:1:size(s.k2)
            p = [s.x(i), s.y(j)];
            m = det(subs(M2, [k2, [x, y]], [s.k2(k), p]));
            
            if imag(m)==0
                if m > 0
                    min2(min0, 1:2) = p;
                    min0 = min0+1;
                end

                if m < 0
                    max2(max0, 1:2) = p;
                    max0 = max0+1;
                end
            end
        end
    end
end
%нет решений
%max2
%min2

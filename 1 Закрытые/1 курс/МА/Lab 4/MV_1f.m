function [s ro1 ro2] = MV_1f(n, A, B)
ro1 = 0; ro2 = 0;
for i = 1:1:n
    s(i) = abs(A(i) - B(i));
    ro1 = ro1+s(i);
    ro2 = ro2+s(i)^2;
end
s = max(s);
ro2 = sqrt(ro2);
end
function [p2, T] = MV_C2f(f, X, Dx, DX, X0)
[a, b] = size(X); n = a*b;
p2 = subs(f, X, X0);

for i = 1:1:n
    A = subs(diff(f, X(i)), X, X0);
    p2 = p2 + A*Dx(i);
end

for i = 1:1:n
    for j = 1:1:n
        A = subs(diff(diff(f, X(i)), X(j)), X, X0);
        p2 = p2 +  A*Dx(i)*Dx(j);
        %(X(i)-X0(i))*(X(j)-X0(j))
    end
end

%k = subs(p2, Dx, 0*ones(a, b));
T = p2;
for i = 1:1:n
    T = subs(T, Dx(i), DX(i));
end
T = double(T);
end
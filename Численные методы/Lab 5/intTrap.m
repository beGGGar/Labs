function I = intTrap(fun, a, b, n)
h = (b-a)/(n-1);
X = a:h:b;
f = @(a)subs(fun, a);
I = f(a)/2;
for i = 2:n-1
    I = I + f(X(i));
end 
I = I + f(b)/2;
I = I*h;
end
%теореточеская погрешность h^2
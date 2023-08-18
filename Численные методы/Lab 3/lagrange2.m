function P = lagrange2(f, x0, t)
y = subs(f, x0); %массив значений функции
n = length(x0);     %количество точек
A = t - x0;
A = repmat(A, n, 1);                       %(t - x0(j))
B = repmat(x0, n, 1)' - repmat(x0, n, 1) + eye(n).*A;  %(x0(i) - x0(j)
A = A./B;
P = prod(A, 2).*(y');
P = sum(P);
end
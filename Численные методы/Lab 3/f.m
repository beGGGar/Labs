function A = f(n)
A = ones(n, n);
A = tril(A, 0);
B = sum(A, 1);
B = fliplr(B);
B = diag(B);
B = eye(n)/B;
A = A+B-eye(n);
A = flipud(A);
end
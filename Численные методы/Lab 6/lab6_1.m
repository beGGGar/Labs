clear; clc;
n = 5;
A = rand(n)*100;
f = rand(n,1)*100;

if det(A) ~= 0
    %метод обратной матрицы
    X1 = inv(A)*f;
    
    %метод крамера
    A1 = A; A2 = A; A3 = A;
    for i = 1:1:n
        Ai(i) = 1;
    end
    A1(:,1) = f;
    A2(:,2) = f;
    A3(:,3) = f;
    x1 = det(A1) / det(A);
    x2 = det(A2) / det(A);
    x3 = det(A3) / det(A);
    x=[x1;x2;x3];
end
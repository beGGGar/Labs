function rez=C1(A)
[sz, q] = size(A);
C = -1*A + eye(sz);

for i = 1:1:sz
    C1(i) = sum(abs(C(i, 1:end))); % сумма по стокам
    C2(i) = sum(abs(C(1:end, i))); % сумма по столбцам
    C3(i) = sum(C(1:end, i).^2); %сумма квадратов элементов по столбцам
end
k1 = max(C1); k2 = max(C2); k3 = sqrt(sum(C3));
if k1<1 | k2<1 | k3<1
    rez = 1;
else rez = 0;
end
end
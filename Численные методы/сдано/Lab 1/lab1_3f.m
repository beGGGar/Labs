function rez = lab1_3f(n)
syms x
buff = x;
rez = x;
for i = 0:1:n
    buff = buff*(-x^2)/(2*i+2)/(2*i+3);
    rez = rez + buff;
end
end


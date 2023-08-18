function [x0, n] = half_found_zeros(f, a, b, delt)
%метод деления отрезка пополам
%необходима чтобы функция имела разные по знаку значения относительно корня
n = 0; exc = 1;

while (b-a)>delt
    n=n+1;
    c = (b+a)/2;
    if(f(c)*f(a)<0)
        b=c;
    elseif(f(c)*f(a)>0)
        a=c;
    else 
        exc = 0;
        break;
    end
end
%крайний случай
if (exc)
    x0 = a;
else
    x0 = c;
end
end
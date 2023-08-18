clear; clc; cla; close all;
syms z;
ya = @(x)x.*log(x);
x0 = 1; x = [0:0.01:-0.01,0.01:0.01:2];
yap = @(n, x, x0)subs(diff(z*log(z), n), z, x).*(x-x0).^n./factorial(n);
hold on; grid on; ylim([-1, 5])
plot(x, ya(x));
plot(x, ya(x0)+yap(1, x, x0)+yap(2, x, x0));
plot(x, ya(x0)+yap(1, x, x0)+yap(2, x, x0)+yap(3, x, x0));
plot(x, ya(x0)+yap(1, x, x0)+yap(2, x, x0)+yap(3, x, x0)+yap(4, x, x0));
xlabel('x'); ylabel('y'); title('x.*log(x)'); 
legend('Функция', 'Многочлен 2 проядка','Многочлен 3 проядка' , 'Многочлен 4 проядка');
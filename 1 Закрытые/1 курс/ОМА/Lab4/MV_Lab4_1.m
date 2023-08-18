%По графику последовательности высказать предположения (гипотезы) о ее 
%свойствах (монотонности, ограниченности, сходимости)
clear; clc; cla; close all;
n=1:10;
x= (sind(n)+cosd(n))./n./(n+1);

plot(n, x);
xlabel('n'),ylabel('f(x)')
grid on;
title('x(n) = (sind(n)+cosd(n))./n./(n+1)')
xlabel('n'), ylabel('x')
legend('(sind(n)+cosd(n))./n./(n+1)')
%монотонно убывает, ограничена снизу, предел а = +беск, 

clear;
figure()
grid on;
x(1) = 1;
hold on;
n = 1:10000;
for k=2:10000
    x(k) = x(k-1)+1/k;
end
plot(n, x);
title('x(n)= 1+ 1/2+ 1/3... 1/n'); xlabel('n'); ylabel('x'); legend('x(n) = x(n-1)+1/n');

%ограничена снизу x = 0
%монотоннo возрастает
%стремиться к бесконечности
%не имеет сходимости и предела

clear;
figure()
hold on;
grid on;
n = 1:100;
x = (log10(n.*10)./log10(n)).^2;
plot(n, x);
n = 1; x = (log10(n*10)/log10(n))^2

title('x(n) = (log(n.*10)).^2/(log(n)).^2'); xlabel('n'); ylabel('x');
legend('(log(z.*10)).^2/(log(z)).^2');
%разрыв в 0
%монотонно возрастает до 0 и монотонно убывает после 0
%ограничена снизу 0





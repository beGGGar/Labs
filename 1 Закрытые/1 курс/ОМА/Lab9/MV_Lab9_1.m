%1) Постройте в одной системе координат график функции   (см. п. а) и б)) и график многочленов Тейлора   
%этой функции в точке   для  .  2) Рассчитайте разности между численными значениями функции    и значениями многочленов  
clear; clc; cla; close all;
%А1
x0 = 0; x = -pi:pi/20:pi; syms z;
ya = @(x)sin(x);
%вычисляем значение nного члена в многочлене Тейлора
yap = @(n, x, x0)subs(diff(sin(z), n), z, x).*(x-x0).^n./factorial(n);

hold on; grid on;
plot(x, ya(x));
plot(x, ya(x0)+yap(1, x, 0));
plot(x, ya(x0)+yap(1, x, 0)+yap(2, x, 0));
plot(x, ya(x0)+yap(1, x, 0)+yap(2, x, 0)+yap(3, x, 0));
plot(x, ya(x0)+yap(1, x, 0)+yap(2, x, 0)+yap(3, x, 0)+yap(4, x, 0));
plot(x, ya(x0)+yap(1, x, 0)+yap(2, x, 0)+yap(3, x, 0)+yap(4, x, 0)+yap(5, x, 0));
xlabel('x'); ylabel('y'); title('График sin(x) и многочленов Тайлера'); legend('y(x)', 'n = 1', 'n = 2', 'n = 3', 'n = 4', 'n = 5');

%A2
Ra = [pi/12 pi/8 pi/6 pi/ 4 pi/3 pi/2];
for a = 1:6
    Ra(2, a) = ya(Ra(1, a));
    Ra(3, a) = abs(Ra(2, a)-(ya(x0)+yap(1, Ra(1, a), 0)));
    Ra(4, a) = abs(Ra(2, a)-(ya(x0)+yap(1, Ra(1, a), 0)+yap(2, Ra(1, a), 0)));
    Ra(5, a) = abs(Ra(2, a)-(ya(x0)+yap(1, Ra(1, a), 0)+yap(2, Ra(1, a), 0)+yap(3, Ra(1, a), 0)));
    Ra(6, a) = abs(Ra(2, a)-(ya(x0)+yap(1, Ra(1, a), 0)+yap(2, Ra(1, a), 0)+yap(3, Ra(1, a), 0)+yap(4, Ra(1, a), 0)));
    Ra(7, a) = abs(Ra(2, a)-(ya(x0)+yap(1, Ra(1, a), 0)+yap(2, Ra(1, a), 0)+yap(3, Ra(1, a), 0)+yap(4, Ra(1, a), 0)+yap(5, Ra(1, a), 0)));
    
end

%Б
yb = @(x)cos(x);
%вычисляем значение nного члена в многочлене Тейлора
ybp = @(n, x, x0)subs(diff(cos(z), n), z, x).*(x-x0).^n./factorial(n);

figure(); hold on; grid on;
plot(x, yb(x));
plot(x, yb(x0)+ybp(1, x, 0));
plot(x, yb(x0)+ybp(1, x, 0)+ybp(2, x, 0));
plot(x, yb(x0)+ybp(1, x, 0)+ybp(2, x, 0)+ybp(3, x, 0));
plot(x, yb(x0)+ybp(1, x, 0)+ybp(2, x, 0)+ybp(3, x, 0)+ybp(4, x, 0));
plot(x, yb(x0)+ybp(1, x, 0)+ybp(2, x, 0)+ybp(3, x, 0)+ybp(4, x, 0)+ybp(5, x, 0));
xlabel('x'); ylabel('y'); title('График cos(x) и многочленов Тайлера'); legend('y(x)', 'n = 1', 'n = 2', 'n = 3', 'n = 4', 'n = 5');

%Б2
Rb = [pi/12 pi/8 pi/6 pi/ 4 pi/3 pi/2];
for a = 1:6
    Rb(2, a) = ya(Rb(1, a));
    Rb(3, a) = abs(Rb(2, a)-(ya(x0)+yap(1, Rb(1, a), 0)));
    Rb(4, a) = abs(Rb(2, a)-(ya(x0)+yap(1, Rb(1, a), 0)+yap(2, Rb(1, a), 0)));
    Rb(5, a) = abs(Rb(2, a)-(ya(x0)+yap(1, Rb(1, a), 0)+yap(2, Rb(1, a), 0)+yap(3, Rb(1, a), 0)));
    Rb(6, a) = abs(Rb(2, a)-(ya(x0)+yap(1, Rb(1, a), 0)+yap(2, Rb(1, a), 0)+yap(3, Rb(1, a), 0)+yap(4, Rb(1, a), 0)));
    Rb(7, a) = abs(Rb(2, a)-(ya(x0)+yap(1, Rb(1, a), 0)+yap(2, Rb(1, a), 0)+yap(3, Rb(1, a), 0)+yap(4, Rb(1, a), 0)+yap(5, Rb(1, a), 0)));
    
end
Ra
Rb




close all; clear; clc;
x = -6:6;
ezplot('y = 1 - 2*x^2');
hold on; grid on; xlabel('x'); ylabel('y'); title('область интегрирования')
plot(x, -x, 'k')
syms x y

%y = -x
%y = 1-2x^2
s = solve(1-2.*x.^2 +x);
X = [s(1), s(2)];
Y = [-s(1), -s(2)];

%В ОДНУ СТОРОНУ
f = sin(x*y);
Iy = int(f, y, 1-2*x^2, -x);
Ix = int(Iy, x, min(X), max(X));
I1 = vpa(Ix,5)

%В ДРУГУЮ
%x = -y
%x = +- sqrt((1-y)/2)
Ix1 = int(f, x, sqrt((1-y)/2), -y);
Iy1 = int(Ix1, y, min(Y), max(Y));

Ix2 = 2*int(f, x, sqrt((1-y)/2), 0);
ext = subs(1-2.*x.^2, x, 0);
Iy2 = int(Ix2, y, max(Y), ext);

I2 = Iy1+Iy2;
I2 = vpa(I2, 5)

plot(X(1), Y(1), 'r*')
plot(X(2), Y(2), 'g*')
plot(0 ,ext, 'k*')
plot([-2 2], [1/2 1/2], 'k--')
legend('y = 1-2x^2', 'y = -x', '(-1/2, 1/2)', '(1, -1)', '(0, 1)')
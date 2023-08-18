clear all; clc; cla; 
syms x;
f1 = sym('x^2+2*x');
f2 = sym('7 - 4*x-x^2');
f = @(u)subs(f1-f2, x, u);

x0 = double(solve(f1 - f2 == 0))
S = abs(double(quad(f, x0(1), x0(2))))

ezplot(f1); 
grid on; hold on;
ezplot(f2);
xlabel('x'); ylabel('y');
legend('x^2+2*x', '7 - 4*x-x^2');
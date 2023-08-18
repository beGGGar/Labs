clear; clc; cla;
syms t; x = sym(cos(t).^3); y = sym(sin(t).^3);

f1 = @(u)subs(y*diff(x), t, u);
S = double(2*quad(f1, pi, 0))

f2 =  @(u)subs(sqrt(diff(x)^2 + diff(y)^2), t, u);
L = double(quad(f2, 0, 2*pi))

t = 0:pi/50:2*pi;
x = cos(t).^3;
y = sin(t).^3;
plot(x, y); hold on; grid on;
xlabel('x'); ylabel('y'); title('x = cos(t).^3 y = sin(t).^3'); 
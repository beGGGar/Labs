clear; clc; cla;
r1 = 1; r2 = 2; 
syms u t;
x1 = sym(r1.*cos(t));
y1 = sym(r1.*sin(t));
x2 = sym(r2.*cos(t));
y2 = sym(r2.*sin(t));

f1 = @(u)subs(x1^2+y1^2, t, u);
f2 = @(u)subs(x2^2+y2^2, t, u);

phy=pi/4:pi/100:3*pi/4;
S = double(quad(f2, phy(1), phy(end)) - quad(f1, phy(1), phy(end)))/2

polar(phy, sqrt(f2(phy)), '--'); hold on;
polar(phy, sqrt(f1(phy)), '--')
%plot(x1,y1, '--g', x2, y2, '--r'); hold on; grid on;
line([0 r2*cos(pi/4)], [0 r2*sin(pi/4)]);
line([0 r2*cos(3*pi/4)], [0 r2*sin(3*pi/4)]);
title('ѕлощадь в пол€рный координатах'); 
legend('r = 1', 'r = 2', 'phy = pi/4 и 3/4*pi');    
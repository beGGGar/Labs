clear; clc;
syms x
sinx = lab1_3f(50);

sin0 = sin(0)  - subs(sinx, x, 0)
sinpi3 = double(sin(pi/3) - subs(sinx, x, pi/3))
sinpi2 = double(sin(pi/2) - subs(sinx, x, pi/2))
sinpi =  double(sin(pi) - subs(sinx, x, pi))
sin2pi = double(sin(2*pi) - subs(sinx, x, 2*pi))

sin12pi = double(sin(12*pi) - subs(sinx, x, 12*pi))
sin13pi = double(sin(13*pi) - subs(sinx, x, 13*pi))
sin14pi = double(sin(14*pi) - subs(sinx, x, 14*pi))
%результаты объ€сн€ютс€ погрешност€ми округлени€


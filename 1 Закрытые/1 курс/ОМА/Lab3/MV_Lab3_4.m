% а) Найти зависимость расстояния между частицами от времени движения первой
%частицы аналитически.
clear; clc; cla; close all;
v1 = 2; v2 = 6;
syms a t;
s1 = v1*t; s2 = v2*(t-3600);
Ss = sqrt((v1*t).^2+(v2*(t-3600)).^2-2*v1*v2*t*(t-3600)*cos(a));
dt = 60;
t0 = 0:dt:7200;

for a = [90, 60, 15]
    for t = t0;
        if t<3600
            S(t/dt+1) = v1*t;
        else
            S(t/dt+1) = sqrt((v1*t)^2+(v2*(t-3600))^2-2*v1*t*v2*(t-3600)*cosd(a));
        end
    end
    plot(t0, S);
    hold on; 
end
title('S(t)'); grid on; xlabel('t, с'), ylabel('S, м'); legend('a = 90', 'a = 60', 'a = 15')

figure()
plot(S, t0);
hold on; title('t(S)'); grid on; ylabel('t, с'), xlabel('S, м'); legend('a = 15')

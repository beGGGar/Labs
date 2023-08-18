%Тело движется по прямой, удаляясь от начала координат. 
%На каком расстоянии от начала координат находится тело в момент, когда его скорость равна 4? 
clear; clc; cla; close all;
t = 0:0.1:10;
s = t.^2 +0.2*cosd(t);
v = 2*t-0.2*sind(t);
subplot(2, 1, 1);
plot(t, s);
grid on; xlabel('t'); ylabel('s'); title('s(t)');
subplot(2, 1, 2);
plot(t, v);
grid on; xlabel('t'); ylabel('v'); title('v(t)');
syms t;
t  = solve(2*t-0.2*sin(t*3.14/180)-4)%t = 2.0035 
S = t^2 +0.2*cos(t*3.14/180)       %s = 4.2139 

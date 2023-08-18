clear all; clc; cla;
t=0:pi/100:2*pi;
r=exp(t);
x=r.*cos(t);
y=r.*sin(t);
plot(x,y)

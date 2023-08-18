 clear all; close all;
t=pi:0.01:2*pi;
x=exp(-t).*cos(t);
y=sin(t);
comet(x,y);
pause(1);


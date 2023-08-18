%3.	Постройте тор, используя его параметрическое уравнение:
clear; clc; cla; close all; 
a = 2; b = 1; c = 3; alfa = (0:pi/20:2*pi)'; beta = 0:pi/20:2*pi;

X = (a+b*cos(alfa))*cos(beta);
Y = (a+b*cos(alfa))*sin(beta);
Z = ones(size(alfa))*b*sin(beta);
mesh(X,Y,Z);
xlabel('x'); ylabel('y'); zlabel('z'); title('Тор');

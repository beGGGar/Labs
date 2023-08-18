%2.	Построить двуполостный гиперболоид вращением гиперболы вокруг оси Ох.
clear; clc; cla; close all;
grid on; hold on; axis equal; view(15,51);
quiver3(-10,0,0,10,0,0,2,'Linewidth',2,'Color','r')

L = ezplot('x^2/9-y^2/4=1');

rotate(L,[1 0 0],20)
   
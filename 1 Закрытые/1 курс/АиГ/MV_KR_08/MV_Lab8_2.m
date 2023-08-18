%2.	Построить двуполостный гиперболоид вращением гиперболы вокруг оси Ох.
clear; clc; cla; close all;
grid on; hold on; axis equal; view(15,51);xlabel('x');ylabel('y');zlabel('z'); title('Двуполостный гиперболоид');
%quiver3(-10,0,0,10,0,0,2,'Linewidth',2,'Color','r')
x1 = -8:0.1:-3;
y1 = sqrt(x1.^2./9-1)*2;
x2 = 3:0.1:8;
y2 = -sqrt(x2.^2./9-1)*2;
i = 1;
for k=0:i:360
    L = plot(x1, y1, 'b', x1, -y1, 'b', x2, y2, 'b', x2, -y2, 'b');
    rotate(L,[1 0 0],k)
end

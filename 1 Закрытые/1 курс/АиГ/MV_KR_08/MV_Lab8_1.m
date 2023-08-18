%1.	Изобразить на одном графике кривую, заданную на промежутке и ее 
%образы после поворота относительно начала координат на угол 45 с шагом 5.
clear; clc; cla; close all;
x = -3/2:0.01:3/2;
y = tan(x);
hold on; grid on; xlim([-10, 10]); ylim([-15, 15]); 
for k = 0:5:45
    h = plot(x, y);
    rotate(h,[0 0 1],k) %вокруг оси Oy
    M(k/5+1)=getframe;
    %cla;

end
movie(M,1,10)
xlabel('x'); ylabel('y'); zlabel('z'); title('Образы поворота кривой');
%1.	���������� �� ����� ������� ������, �������� �� ���������� � �� 
%������ ����� �������� ������������ ������ ��������� �� ���� 45 � ����� 5.
clear; clc; cla; close all;
x = -3/2:0.01:3/2;
y = tan(x);
hold on; grid on; xlim([-10, 10]); ylim([-15, 15]); 
for k = 0:5:45
    h = plot(x, y);
    rotate(h,[0 0 1],k) %������ ��� Oy
    M(k/5+1)=getframe;
    %cla;

end
movie(M,1,10)
xlabel('x'); ylabel('y'); zlabel('z'); title('������ �������� ������');
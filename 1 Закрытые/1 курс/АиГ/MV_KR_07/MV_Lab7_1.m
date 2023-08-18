%1.	��������� ������ � �������� �����������   (������� ��������).
clear; clc; cla; close all;
t = 0:pi/100:2*pi;
f = t;
f = max(0, f);
y=f.*sin(t);
x=f.*cos(t);
subplot(1, 2, 1);
plot(x,y)
grid on, axis square; xlabel('x'); ylabel('y'); title('������� �������� � ���������� �������'); legend('f(t) = t');
subplot(1, 2, 2);
polar(t,f)
xlabel('x'); ylabel('y'); title('������� �������� � �������� �������'); legend('f(t) = t');


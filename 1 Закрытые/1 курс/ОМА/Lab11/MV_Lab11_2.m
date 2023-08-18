%(1) ��������� ������� ������������
%(2) ��������� ���������� �������� ������������ ����� � ������� ���������  . 
%������� ������������ � �������� ����� ������, � ������� ����������� � ���������� ����������� ���� ���������. 
%��������� ������, �������� �� ������ ��������������� �����.
%(3) ������� �������� ����������� �������� �� ����������.
clear; clc; cla; close all; 
syms t;
xt = @(t)2*t-t.^2;
yt = @(t)8*t.^2-4*t.^3;
xinv = @(t)-xt(t);
yinv = @(t)-yt(t);
subplot(1,2, 1)
hold on; grid on; 
xlabel('x'); ylabel('y'); title('x(t)');
t = 0:0.05:3;
plot(t, xt(t));
subplot(1, 2, 2)
hold on; grid on; 
xlabel('x'); ylabel('y'); title('y(t)');
plot(t, yt(t));
figure()
hold on; grid on;
plot(xt(t), yt(t))
OXmax = fminbnd (xinv, 0, 4);
OYmax = fminbnd (yinv, 0, 4);
x = [xt(OXmax), yt(OXmax)]
y = [xt(OYmax), yt(OYmax)]
plot(xt(OXmax), yt(OXmax), '*')
plot(xt(OYmax), yt(OYmax), '*')
xlabel('x'); ylabel('y'); title('���������� �������� �����'); 
legend('����������', '����������� �y(1, 4)', '����������� �x(0.89, 4.74)');
quiver(0.25, -2.5, 0.75, 2.5, 0);
quiver(-0.25, 2.5, -1.5, -15, 0);

%�� ������� ������������������ ��������� ������������� (��������) � �� 
%��������� (������������, ��������������, ����������)
clear; clc; cla; close all;
n=1:10;
x= (sind(n)+cosd(n))./n./(n+1);

plot(n, x);
xlabel('n'),ylabel('f(x)')
grid on;
title('x(n) = (sind(n)+cosd(n))./n./(n+1)')
xlabel('n'), ylabel('x')
legend('(sind(n)+cosd(n))./n./(n+1)')
%��������� �������, ���������� �����, ������ � = +����, 

clear;
figure()
grid on;
x(1) = 1;
hold on;
n = 1:10000;
for k=2:10000
    x(k) = x(k-1)+1/k;
end
plot(n, x);
title('x(n)= 1+ 1/2+ 1/3... 1/n'); xlabel('n'); ylabel('x'); legend('x(n) = x(n-1)+1/n');

%���������� ����� x = 0
%��������o ����������
%���������� � �������������
%�� ����� ���������� � �������

clear;
figure()
hold on;
grid on;
n = 1:100;
x = (log10(n.*10)./log10(n)).^2;
plot(n, x);
n = 1; x = (log10(n*10)/log10(n))^2

title('x(n) = (log(n.*10)).^2/(log(n)).^2'); xlabel('n'); ylabel('x');
legend('(log(z.*10)).^2/(log(z)).^2');
%������ � 0
%��������� ���������� �� 0 � ��������� ������� ����� 0
%���������� ����� 0





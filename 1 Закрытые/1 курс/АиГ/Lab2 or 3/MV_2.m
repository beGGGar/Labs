clear; clc;
x = 2.8:0.05:2.9;
%f = exp(x)-3*x.^2; ����������� �������
f1 = exp(x)-6*x; %�����������
plot(x, f1);
grid on;

figure()
n = -300:0.05:10;
f = exp(x)-3*x.^2;
f2 = exp(n)-6*n;
plot(n, f2);
grid on;
%����� ��������: 2.83
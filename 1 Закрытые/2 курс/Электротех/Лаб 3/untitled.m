clear; clc; close all;
UL = 26.39;
UR = 4.97;
UC = 26.39;
E = 5;
figure; hold on; grid on; 
plot([0, E], [0, 0], 'r')
plot([0, UR], [0, 0], 'g--')
plot([0, 0], [0, UL], 'k')
plot([0, 0], [0, -UC], 'y')
legend('E', 'UR', 'UL', 'UC'); xlim([-1, E+1]); title('диаграмма напряжений')

I1 = 1.04;I2 = 1.04;I = 0.09;
f = 127.43;
R = 0.2;
L = 6*10^(-3); C = 260*10^(-6);
phi1 = atan(2*pi*f*L/R)
phi2 = -atan(1/(2*pi*f*C)/R)
figure; hold on; grid on; title('диаграмма токов')
plot([0, I], [0, 0], '')
plot([0, I1*cos(phi1)+I2*cos(phi2)], [0, 0], 'y--')
plot([0, I1*cos(phi1)], [0, I1*sin(phi1)])
plot([0, I2*cos(phi2)], [0, I2*sin(phi2)])
legend('I', 'I1+I2', 'I1', 'I2')
Q = I1*sin(phi1)/I
antip = I2*sin(phi2)/5

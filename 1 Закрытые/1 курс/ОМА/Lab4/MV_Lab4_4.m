%Путем вычислительного эксперимента установите, на что может рассчитывать
%ростовщик при «неограниченном» возрастании n .
clear; clc; cla; close all;
subplot(1, 2, 1)
hold on; grid on; xlabel('n частей'); ylabel('S, сумма возврата'); title('S(n)');
for n = 1:0.1:10
    s = 1;
    s = s*(1+1/n)^n;
    plot(n, s, '.');
end
%выше 2.7183S ростовщик не получит 
subplot(1, 2, 2)
hold on; grid on; xlabel('n частей'); ylabel('S, сумма возврата'); title('S(n)');
for n = 9990:10000  
    s = 1;
    s = s*(1+1/n)^n;
    plot(n, s, '.');
end
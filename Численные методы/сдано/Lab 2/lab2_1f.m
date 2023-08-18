function x0 = lab2_1f(f, p)
syms x
figure;
grid on; hold on;
line([-10 10],[0 0],'color','black')
line([0 0],[-1500 1000],'color','black')
fplot(f, [-10, 10]);   
x0=roots(p);
delt = 1/(1+max(abs(p))/1);
for i=1:1:length(x0)
    plot(x0(i), 0, 'r*')
end
end
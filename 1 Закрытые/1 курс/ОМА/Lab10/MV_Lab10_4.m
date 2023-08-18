%вычисления и построения графика математической функции y =x.^4+a.*x.^3+x+1

function [] = MV_Lab10_4(b, e, a)
k = 1; x = b:0.01:e;
figure(); hold on; grid on;
for z = a
    y =x.^4+z*x.^3+x+1;
    plot(x, y);   
end
xlabel('x'); ylabel('y'); title('y =x.^4+a.*x.^3+x+1');
legend('a1', 'a2', 'a3')
end
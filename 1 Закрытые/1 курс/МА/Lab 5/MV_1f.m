function [L, n] = MV_1f(Y, x0, y0, a, b, n0, e)
syms x y;
n = n0; 
X = a:(b-a)/n:b;
y1(1) = y0;
y2(1) = y0;
for i = 2:1:n+1
    y1(i) = y1(i-1)+subs(Y, {x, y}, {X(i-1), y1(i-1)})*(b-a)/n;
end
figure(1)
plot(X, y1, 'r')
hold on; grid on;
plot(X, y1, 'r*')
%%%%%%%%%%

n = 2*n;
X = a:(b-a)/n:b;
for i = 2:1:n+1
    y2(i) = y2(i-1)+subs(Y, {x, y}, {X(i-1), y2(i-1)})*(b-a)/n;
end
plot(X, y2, 'g')
plot(X, y2, 'g*')
%%%%%%%%%%

for i = 1:1:n/2
    dy(i) = abs(y1(i)-y2(2*i-1));
end

while max(dy)>e
    y1 = y2; 
    n = 2*n;
    X = a:(b-a)/n:b;
    for i = 2:1:n+1
    y2(i) = y2(i-1)+subs(Y, {x, y}, {X(i-1), y2(i-1)})*(b-a)/n;
    end
    for i = 1:1:n/2
    dy(i) = abs(y1(i)-y2(2*i-1));
    end
end
%%%%%%%%

X = a:(b-a)/n*2:b;
plot(X, y1, 'k')
xlabel('x'); ylabel('y'); title('ћетод ломанных Ёйлера дл€ y = yx'); 
legend('n = n0','вершины','n = 2n0','вершины','конечное n');
n = n/2; L = y1;
end
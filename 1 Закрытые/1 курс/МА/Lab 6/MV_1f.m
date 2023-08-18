function [] = MV_1f(f, g, X, n, rf, rg)
syms x;
a = X(1); b = X(2);
X = a:(b-a)/n:b;
F = subs(f, x, X);
G = subs(g, x, X);

figure();
hold on; grid on;
plot(X, F, rf);
plot(X, G, rg);
for i = 1:n
    if F(i)>G(i)
        plot([X(i), X(i)], [F(i), G(i)], 'b--');
    end
end
xlabel('x'); ylabel('y'); title('область определения функции'); 
legend('f(x)','g(x)','область определения');
hold off;
end

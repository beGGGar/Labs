function s = MV_1f(f, n0)
syms n;
figure();
grid on; hold on;
for i = 1:1:n0
    F(i) = subs(f, n, i);
end
S(1) = F(1);
for j = 2:1:n0
    S(j) = S(j-1)+F(j);
end
plot(1:1:n0, S);
plot(1:1:n0, F);
legend('Предельные суммы', 'х(n)'); 
xlabel('n'); ylabel('f');
s = double(S(n0));
end
syms x
f = sin(x)/x;
T6 = taylor(f, x);

T8 = taylor(f, x, 'Order', 8);
T10 = taylor(f, x, 'Order', 10);

fplot(f, [-4 4])
grid on

legend('approximation of sin(x)/x up to O(x^6)',...
       'approximation of sin(x)/x up to O(x^8)',...
       'approximation of sin(x)/x up to O(x^{10})',...
       'sin(x)/x','Location','Best')
title('Taylor Series Expansion')
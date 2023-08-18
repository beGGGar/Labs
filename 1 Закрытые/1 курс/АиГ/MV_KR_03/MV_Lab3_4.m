clear; clc;
A = [1 2 0];
B = [3 2 1];
C = [-2 1 2];
ab = B-A;
ac = C-A;
AB = sqrt(ab(1)^2+ab(2)^2+ab(3)^2);
AC = sqrt(ac(1)^2+ac(2)^2+ac(3)^2);
corner = acos((ab(1)*ac(1)+ab(2)*ac(2)+ab(3)*ac(3))/(AB*AC));
S = AB*AC*sin(corner)/2

%проверка
x = cross(ab, ac);
S1 = sqrt(x(1)^2+x(2)^2+x(3)^2)/2
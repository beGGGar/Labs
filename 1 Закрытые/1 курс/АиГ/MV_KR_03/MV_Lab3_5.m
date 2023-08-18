clear; clc;
A = [7 2 4];
B = [7 -1 -2];
C = [3 3 1];
D = [-4 2 1];
ab = B-A;
ac = C-A;
ad = D-A;
S = cross(ab, ac);
S1 = sqrt(S(1)^2+S(2)^2+S(3)^2)/2;
V=abs(dot(S, ad)/6)
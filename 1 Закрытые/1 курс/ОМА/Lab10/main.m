clear; clc; cla; close all;
%1
y0 = MV_Lab10_1(0)
x = -10:0.1:10;
plot(x, MV_Lab10_1(x))
grid on; xlabel('x'); ylabel('y'); title('y = exp(-x^2/2)/sqrt(2*pi)');

%2
alfa = 60:0.1:180; a = 40;
[cornmax, Smax] = MV_Lab10_2(alfa, a)

%3
V = 250; H = 1:0.1:250;
[S, R] = MV_Lab10_3(V, H);
s = MV_Lab10_3(V, H(1)); k = 1;
for n = S
    if (s>S(k))
        s = S(k); r = R(k); h = H(k);
    end
    k=k+1;
end
s, r, h
figure(); 
plot(H, S)
grid on; xlabel('H, cм'); ylabel('S, см^2'); title('S поверхности от H');

%4
a = -20:20:20; beg = -20;  e = 20;
MV_Lab10_4(beg, e, a)
beg = -1;  e = 1;
MV_Lab10_4(beg, e, a)
    
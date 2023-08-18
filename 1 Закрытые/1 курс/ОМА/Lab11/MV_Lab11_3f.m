function [x, y] = MV_Lab11_3f(C1 ,C2, t)
xt = @(t, C1, C2)(2*C2-C1)*cosd(2*t)-(2*C1+C2)*sin(2*t);
yt = @(t, C1, C2)C1*cos(2*t)+C2*sin(2*t);
x = xt(t, C1 ,C2);
y = yt(t, C1 ,C2);
end
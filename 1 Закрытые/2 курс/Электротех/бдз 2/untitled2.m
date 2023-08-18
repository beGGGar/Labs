clear; clc;
syms i x;
i1 = 22.12; i2 = 16.38; i3 = 7.18;
f1 = -53; f2 = 66; f3 = 22.1;
x1 = 9.99; x2 = 1.99; x3 = 15.92;
%format short e
%rez = (i1*(cosd(f1) + imag(sind(f1))))^2*x1 + (i2*(cosd(f2) + imag(sind(f2))))^2*x2 + (i3*(cosd(f3) + imag(sind(f3))))^2*x3
%rez = (i1*(cosd(f1) + x*sind(f1)))^2*x1 + (i2*(cosd(f2) + x*sind(f2)))^2*x2 + (i3*(cosd(f3) + x*sind(f3)))^2*x3
rez = (i1*complex(cosd(f1), sind(f1)))^2*x1 + (i2*complex(cosd(f2), sind(f2)))^2*x2 + (i3*complex(cosd(f3), sind(f3)))^2*x3
%collect(rez)
%vpa(rez)
complex(cosd(f1), sind(f1))^2
200*22.12*complex(cosd(-53), sind(-53))
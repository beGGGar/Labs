a = 1; b=1; c=2;
u = (-2:0.02:2)';
phi = 0:pi/100:2*pi;
X = a * cosh(u) * cos(phi);
Y = b * cosh(u) * sin(phi);
Z = c * sinh(u) * ones(size(phi));
mesh(X, Y, Z)
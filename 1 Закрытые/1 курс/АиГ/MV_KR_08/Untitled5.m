a = 16; b = 16;
[X , Y] = meshgrid(-a:0.1:a, -b:0.1:b);
Z = (X.^2/a^2 + Y.^2/b^2);
mesh(X, Y, Z);
close all; clear; clc; 
[X, Y] = meshgrid(-10:1:10, -10:1:10);
Z = X.^3./3 + Y.^3./3;
surf(X, Y, Z)
hold on; grid on;
mesh(X, (1-X)/4, Z)
xlabel('x'); ylabel('y'); zlabel('z'); title('Z = X^3/3 + Y^3/3')
figure()

[X, Y] = meshgrid(0:1:20, -50:1:100);
Z = (X+1).^2 + Y.^2;
surf(X, Y, Z); 
hold on; grid on; xlabel('x'); ylabel('y'); zlabel('z'); title('Z = (X+1)^2 + Y^2;')
mesh(X, X.^(3/2), Z)
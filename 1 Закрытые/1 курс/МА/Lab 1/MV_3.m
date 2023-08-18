clear; clc; 
a = 1; b = 2; n = 4; f = sym('x');        
right = 0;

S = MV_3f(a, b, f, n, right)

right = 1;
S = MV_3f(a, b, f, n, right)

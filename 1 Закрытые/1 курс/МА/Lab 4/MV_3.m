clear; clc; 
X(1) = 3;
for i = 2:10
    X(i) = tan(X(i-1));
end
X
clear; clc; 
f= @(x)(sin(x)+cos(x)/(1-x.^3).^(1/5));
quad(f)
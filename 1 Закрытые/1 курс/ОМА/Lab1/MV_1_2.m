%Определите объем мороженого
clc; clear; 
format short
H = 10;
R=3;
V1 = 4/3/2*pi*R^3;
V2=pi*R^2*H/3;
V = V1+V2

a = round(V)
b = round(V*10)/10
c = round(V*100)/100
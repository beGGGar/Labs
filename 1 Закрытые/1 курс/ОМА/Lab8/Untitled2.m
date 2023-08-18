clear; clc; cla; close all;

y0=100; 
hold on;
x=-1:0.1:500;

xt=3;%x0
x0 = xt;
yt=a*xt^2+b*xt;%y0

ymin=-2;
xmax=20; xmin=-10;
a=-10;
b=sqrt(-4*y0*a);

y=a*x.^2+b*x;

k=2*a*xt+b;%производная
bk=yt-k*xt;
xk=[xmin xmax];
yk=k*xk+bk;

k = 2*a*x0+b;
bk = y-k*x0;
kn=-1/k;
bn=yt-kn*xt;
yn=kn*xk+bn;

%plot(x,y,'b',xt,yt,'ro', xk,yk,'g', xk,yn,'r');
plot(x,y,'b');
plot(xk,yk,'g');

ylim([ymin y0+1]);
grid on;

a=1;b=1;c=1;
u = (0:0.05:1)';
v = [0:0.05*pi:2*pi];
X = a*sinh(u)*cos(v);
Y = b*sinh(u)*sin(v);
Z = c*cosh(u)*ones(size(v));
surf(X,Y,Z);
hold on
Z=-Z;
surf(X,Y,Z);

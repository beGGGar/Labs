clear; clc;
w = 100*pi; R2 = 8; R3 = 10; U = 200;
L1 = 31.8*10^(-3); C2 = 1600*10^(-6); C3 = 200*10^(-6);

Z1 = complex(0, w*L1); Z2 = complex(R2, -1/w/C2); Z3 = complex(R3, -1/w/C3); 
Z23 = Z2*Z3/(Z2+Z3); Z = Z1 + Z23;

I1 = U/Z; U23 = I1*Z23; I2 = U23/Z2; I3 = U23/Z3;
UR2 = I2*R2; UR3 = I3*R3;
UL1 = I1*w*L1; UC2 = I2/w/C2; UC3 = I3/w/C3;

%S = U*I1
%P = real(BM(I2))^2*R2 + real(BM(I3))^2*R3
%Q = real(BM(I1))^2*w*L1 - real(BM(I2))^2/w/C2 - real(BM(I3))^2/w/C3
UL1, UC2, UC3, UR2, UR3, U23
%I1, I2, I3



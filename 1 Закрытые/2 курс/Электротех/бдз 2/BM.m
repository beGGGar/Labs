function newNum = BM(num)
syms degry;
phi = atand(imag(num)/real(num));
leng = sqrt(imag(num)^2 + real(num)^2);
newNum = complex(leng, phi);
end
function F = MV_3f(arg)
x = arg(1);
y = arg(2);
F = x.^2+y.^2-2*log(x)-18*log(y);
end
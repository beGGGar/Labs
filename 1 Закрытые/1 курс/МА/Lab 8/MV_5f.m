function F = MV_5f(arg)
x = arg(1);
y = arg(2);
z = arg(3);
F = x + y./x + z./y + 2./z;
end
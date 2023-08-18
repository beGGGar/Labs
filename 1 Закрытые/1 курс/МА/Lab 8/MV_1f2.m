function F = MV_1f2(arg)
x = arg(1);
y = arg(2);
F = -1*(x.*y+50./x+20./y);
end
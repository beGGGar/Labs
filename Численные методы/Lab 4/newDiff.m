function df = newDiff(f, x, h)
df = (subs(f, x+h) - subs(f, x-h))/2/h;
%df = double(df);
end
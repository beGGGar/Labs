function [S, s] = MV_4f(a, b, f, n)
step=(b-a)/n;

syms x u; S = 0; s = 0;
funp = @(u)double(subs(f, x, u));
funm = @(u)double(subs(-f, x, u));

 for i = a:step:b-step
        s = s+step*subs(f, x, fminbnd(funp, i, i+step));
 end
 
 for i = a:step:b-step
        S = S+step*subs(f, x, fminbnd(funm, i, i+step));
 end
 S = double(S); s = double(s);
end
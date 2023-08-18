function [min, max] = MV_4f(f)
syms x y z
dx = diff(f, x);
dy = diff(f, y);
dz = diff(f, z);

dxx = diff(f, x, 2);
dyy = diff(f, y, 2);
dzz = diff(f, z, 2);
dxy = diff(dx, y);
dxz = diff(dx, z);
dyx = diff(dy, x);
dyz = diff(dy, z);
dzx = diff(dz, x);
dzy = diff(dz, y);

M = [dxx, dxy, dxz; dyx, dyy, dyz; dzx, dzy, dzz];
sylv = [dxx, det(M(1:2, 1:2)), det(M)];

s = solve(dx, dy, dz, 'x', 'y', 'z');
min0 = 1; max0 = 1;
for i = 1:1:size(s.x)
    for j = 1:1:size(s.y)
        for k = 1:1:size(s.z)
            P = [s.x(i), s.y(j), s.z(k)];
            buff = subs(sylv, [x, y, z], P);
            
            if imag(buff)==0
                if (buff(1)>0) && (buff(2)>0) && (buff(3)>0) 
                    min(min0, 1:3) = P;
                    min0 = min0+1;
                end
            
                if (buff(1)<0) && (buff(2)>0) && (buff(3)<0) 
                    max(max0, 1:3) = P;
                    max0 = max0+1;
                end
            end
            
        end
    end
end
min = double(min);
max = double(max);
end
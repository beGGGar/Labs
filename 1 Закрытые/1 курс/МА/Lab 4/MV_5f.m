function []=MV_5f(A1, B1, X0, e)
[t, q] = size(A1);
C = -1*A1 + eye(t);
ans1 = B1+C*X0
ans2 = B1+C*ans1
ind = 0; n = 1;
while (ind == 0)
    ans1 = ans2;
    ans2 = B1+C*ans2;
    ind = 1; 
    n = n+1;
    for j = 1:1:t
        if (abs(ans1(j)-ans2(j)) < e)
            ind = ind*1;
        else
            ind = 0;
        end
    end
end
ans2
n
end
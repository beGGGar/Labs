function I = intSimpson(F, a, b, n)
h=(b-a)/n; %���������� ���
I = F(a);

for i=1:1:((n/2)-1) %��� �������� ��������
    x=a+2*h*i;
    I = I + 2*F(x) + 4*F(x+h);
end

I=double(h*I/3);

end
%������� �������� ����� ��� ������ ���������� 3-�� �������
%����������� ��������� ������� h^3
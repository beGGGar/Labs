%3.	������ �������   � ��������� ������. ���������, ��� �������   ���������� �����. 
%�������� ������� ��������������� ��������� ����� ������������� �����.
clear; clc;
format rat
e1 = [1 -1 5]; e2 = [2 1 1]; e3 = [3 0 4];
A = [e1; e2; e3], det(A)
a1 = e1
a2 = e2 - dot(a1, e2)/sqrt(a1(1).^2+a1(2).^2+a1(3).^2)
a3 = e3 - dot(a1, e3)/sqrt(a1(1).^2+a1(2).^2+a1(3).^2) - dot(a2, e3)/sqrt(a2(1).^2+a2(2).^2+a2(3).^2)



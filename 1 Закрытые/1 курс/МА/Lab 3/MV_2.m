clear; clc; close all;
f = sym('q^n'); syms q;
q1 = 0.3; q2 = 1; q3 = 4;

S1 = MV_1f(subs(f, q, q1), 10)
S2 = MV_1f(subs(f, q, q2), 10)
S3 = MV_1f(subs(f, q, q3), 10)
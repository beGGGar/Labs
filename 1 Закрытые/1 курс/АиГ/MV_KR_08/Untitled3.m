t = -1:0.1:1;
hold on, grid on, axis equal
h = plot(t, 2*t);
for i = 1:1:90
    h = plot(t, 2*t);
    rotate(h, [0 0 1], i)
    pause(0.1)
    M(i) = getframe;
end
movie(M, 2, 30)
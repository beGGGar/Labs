clear; close all; clc; 
figure; hold on; grid on; xlim([-0.1, 0.6]); ylim([-0.1, 0.8]);
k = 8; t = 0:1/k:4/k;
f = @(t)sin(pi.*t./2);
fplot(f)

for i = 1:1:(length(t)-1)
    line([t(i), t(i+1)], [f(t(i)), f(t(i+1))],'color','red');
end
legend('f', 'ломаная')

%графики почти не отличаются из-за особенности участка, но совпадают лиш в
%узлах t

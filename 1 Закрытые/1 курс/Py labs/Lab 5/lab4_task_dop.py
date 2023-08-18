from random import randint


def max_find(M):
    maxid = 0
    maxval = M[0]
    for i in range(0, len(M)):
        if M[i] > maxval:
            maxval = M[i]
            maxid = i
    return maxid


n = int(input("n: "))
M = []
for i in range(0, n):
    M.append(randint(1, 5))
print(M)
counter = 0
while len(set(M)) > 1:
    maxid = max_find(M)
    M[maxid] -= min(M)
    counter += 1
    print(M)
print(counter)

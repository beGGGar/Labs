from random import randint
import time
from threading import Thread
import math

print("вариант 1: " + str(8211812 % 5 + 1))
print("вариант 2: " + str(8211812 % 2 + 1))
N = 5000


def formula(p: int, q: int):
    return int(math.sqrt((p - q) ** 2))


def init_r(P: list[int], Q: list[int]):
    r = [[formula(p, q) for p in P] for q in Q]
    # print(r)


def main():
    Q = [randint(-1000, 1000) for i in range(N)]
    P = [randint(-1000, 1000) for i in range(N)]

    start_time = time.time()
    init_r(P, Q)
    init_r(P, Q)
    print(f"Время без потоков: {time.time() - start_time}")

    start_time = time.time()
    t1 = Thread(target=init_r, args=(P, Q))
    t1.start()
    t2 = Thread(target=init_r, args=(P, Q))
    t2.start()
    t1.join()
    t2.join()
    print(f"Время c потоками: {time.time() - start_time}")


main()

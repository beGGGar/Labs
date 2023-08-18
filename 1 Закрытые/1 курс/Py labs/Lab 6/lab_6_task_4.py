import os
import time
from threading import Thread

print("вариант: " + str(8211812 % 3 + 1))  # 3

FILENAME = "size.txt"


def file_create(filename):
    path = os.getcwd()
    for root, dirs, files in os.walk(path):
        size = len(os.listdir())
        with open(root + '\\' + filename, 'w') as file:
            file.write(str(size))


def main():
    start_time = time.time()
    file_create(FILENAME)
    file_create(FILENAME)
    print(f"Время без потоков: {time.time() - start_time}")

    start_time = time.time()
    t1 = Thread(target=file_create, args=(FILENAME,))
    t1.start()
    t2 = Thread(target=file_create, args=(FILENAME,))
    t2.start()
    t1.join()
    t2.join()
    print(f"Время c потоками: {time.time() - start_time}")


main()

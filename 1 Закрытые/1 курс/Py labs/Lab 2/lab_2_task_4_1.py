from random import randint
import os

try:
    os.mkdir("exemple")
except:
    print("Папка 'exemple' уже создана")

for i in range(1, 101):
    FILENAME = fr"exemple\file{i}.txt"
    data = "a"*randint(1, 100)*1000
    with open(FILENAME, "w") as file:
        file.write(data)


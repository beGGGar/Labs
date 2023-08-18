n = input("Введите число строк: ")
bilets = {}
print("Введите ", n, " строк даднных в формате {ряд} {место} {стоимость билета}:\n")

#Занесение данных в словарь
for i in range(1, int(n)+1):
    buff = input("Место 1: ").split()
    place = tuple([buff[0], buff[1]])
    try:
        bilets[place].append(int(buff[2]))
    except:
        bilets[place] = [int(buff[2]), ]

#Вывод иговых данных
for i in range(len(bilets)):
    key, value = bilets.popitem()
    print(key[0], " ", key[1], " - ", len(value))

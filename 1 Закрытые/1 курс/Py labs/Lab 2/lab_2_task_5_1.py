import os

while True:
    try:
        min = int(input("Введите наименьший размер файлов(от 1 до 100): "))
        if min<1 or min >100:
            raise ValueError()
        break
    except ValueError:
        print("Некорректное значение")
while True:
    try:
        max = int(input("Введите наибольший размер файлов(от min до 100): "))
        if max<min or max>100:
            raise ValueError()
        break
    except ValueError:
        print("Некорректное значение")
counter = 0
file_list = os.listdir("exemple")
for file in file_list:
    size = os.path.getsize("exemple\\"+file)/1000
    if size<=max and size>=min:
        counter += 1
print(counter)
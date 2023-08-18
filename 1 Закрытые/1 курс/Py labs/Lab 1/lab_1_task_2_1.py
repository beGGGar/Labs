def reduce_value(nums, start, stop):
    # определяет границы уменьшения
    for i in range(start, stop+1):
        nums[i] -= 1
    return nums

def found_border(nums):
    # уменьшает от сих до сих на 1
    start = -1
    stop = -1
    for i in range(len(nums)):
        if nums[i] > 0:
            start = i
            break
    if start == -1:
        return -1, -1
    for i in range(start, len(nums)):
        if nums[i] != 0:
            stop = i
        else:
            break
    return [start, stop]

numbers = input("Введите числа через пробелы: ").split()
numbers = list(map(int, numbers))
final = list(map(int, list("0"*len(numbers))))

#Излишний рудимент
#i = int(input(f"Всего чисел {len(numbers)}, \nC какого числа начать уменьшение:"))
#n = int(input("На каком закончить: "))

counter = 0
# подсчет операций
while True:
    print(numbers)
    [start, stop] = found_border(numbers)
    if start == -1:
        break
    reduce_value(numbers, start, stop)
    counter += 1
print(f"Шагов: {counter}")




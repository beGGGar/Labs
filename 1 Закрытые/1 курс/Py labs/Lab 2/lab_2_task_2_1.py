FILENAME_1 = "ip.log"
FILENAME_2 = "ip_solve.log"


def mask_class():
    mask = ""
    while mask != 0 or mask != "0":
        mask = input("Введите маску подсети в формате x.x.x.x: ")
        mask = mask.split(".")
        if mask[0] == "255":
            if mask[1] == "255":
                if mask[2] == "255":
                    return 3
                return 2
            return 1
        else:
            print("Неверно введенная маска подсети. Пример правильной маски:\n255.0.0.0\n255.255.0.0\n255.255.255.0\n")

def address_gen(ip, MC):
    ip = ip.split('.')
    if MC == 1:
        return "{}.0.0.0".format(ip[0])
    if MC == 2:
        return "{}.{}.0.0".format(ip[0], ip[1])
    if MC == 3:
        return "{}.{}.{}.0".format(ip[0], ip[1], ip[2])

with open(FILENAME_1, 'r') as file_1:
    with open(FILENAME_2, 'w') as file_2:
        MC = mask_class()
        for ip in file_1:
            #ip = file_1.readline()
            address = address_gen(ip, MC) + "\n"
            file_2.write(address)





from random import randint

FILENAME = "ip.log"
with open(FILENAME, 'w') as file:
    try:
        for i in range(1, 10000):
            rand_ip = "{}.{}.{}.{}\n".format(randint(0, 255), randint(0, 255), randint(0, 255), randint(0, 255))
            file.write(rand_ip)
    except Exception as e:
        print(e)
def int_input(s: str = ""):
    # All Type Input
    while True:
        text = input(s)
        try:
            text = int(text)
            return text
        except ValueError:
            print("Введите целочисленное значение!")


def float_input(s: str = ""):
    while True:
        text = input(s)
        try:
            text = float(text)
            return text
        except ValueError:
            print("Введите значение типа float!")


def type_check(s, type_):
    if type(s) == type_:
        return True
    return False


def int_range(s: str = "", minvalue: int = -9223372036854775808, maxvalue: int = 9223372036854775807):
    while True:
        number = int_input(s)
        if number <= maxvalue and number >= minvalue:
            return number
        elif number > maxvalue:
            print("Введите меньшее значение!")
        else:
            print("Введите большее значение!")


def float_range(s: str = "", minvalue: float = "", maxvalue: float = "") -> float:
    while True:
        number = float_input(s)
        if type(minvalue) != str:
            if number < minvalue:
                print("Введите большее значение!")
                continue
        if type(maxvalue) != str:
            if number > maxvalue:
                print("Введите меньшее значение!")
                continue
        return number

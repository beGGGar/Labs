def int_input(s: str = ""):
    # All Type Input
    while True:
        text = input(s)
        try:
            text = int(text)
            return text
        except ValueError:
            print("Введите целочисленное значение!")


def int_range(s: str = "", minvalue: int = -9223372036854775808, maxvalue: int = 9223372036854775807):
    while True:
        number = int_input(s)
        if number <= maxvalue and number >= minvalue:
            return number
        elif number > maxvalue:
            print("Введите меньшее значение!")
        else:
            print("Введите большее значение!")

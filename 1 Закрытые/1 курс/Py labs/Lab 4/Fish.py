from Product import Product
from ValueCheck import float_range, int_range


class Fish(Product):
    def __init__(self, name: str = "NotStated", price: float = 0, alive: bool = False, quant: int = 0,
                 height: float = 0, width: float = 0, depth: float = 0):
        Product.__init__(self, name, price, quant, height, width, depth)
        self.__alive = alive

    @property
    def alive(self):
        return self.__alive

    def display_info(self) -> str:
        live = "живая"
        if not self.__alive:
            live = "не " + live
        return f"Название: {self.__name}({live}), Цена : {self.__price}, Количество: {Product.__quant}, Объем: {self.__depth * self.__height * self.__width}"

    def kill_fish(self) -> str:
        if self.__alive:
            self.__alive = False
            return "Рыба умертвлена"
        else:
            return "Рыба уже мертва"

    def __add__(self, other):
        if self.__name == other.__name and self.__price == other.__price and self.__height == other.__height and \
                self.__width == other.__width and self.__depth == other.__depth and self.__alive == other.__alive:
            new_quant: object = self.__quant + other.__quant
            return Fish(self.__name, self.__price, self.__alive, new_quant, self.__height, self.__width, self.__depth)
        return Fish(self.__name, self.__price, self.__alive, self.__quant, self.__height, self.__width, self.__depth)

    def define(self):
        print("Рыба")
        self.__name = input("Название: ")
        self.__price = float_range("Цена: ", minvalue=0.01)
        self.__quant = int_range("Количество: ", minvalue=0)
        y = input("Жива ли рыба? y/n")
        if y == "y":
            self.__alive = True
        else:
            self.__alive = False
        n = input("Указать размеры? y/n: ")
        if n == "y":
            self.define_size()

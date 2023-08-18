from ValueCheck import float_range, int_range


class Product:
    def __init__(self, name: str = "NotStated", price: float = 0, quant: int = 0, height: float = 0, width: float = 0,
                 depth: float = 0):
        self.__price = price
        self.__name = name
        self.__height = height
        self.__width = width
        self.__depth = depth
        self.__quant = quant

    @property
    def price(self) -> float:
        return self.__price

    @property
    def name(self) -> str:
        return self.__name

    @property
    def size(self) -> "list[height:float, width:float, depth:float]":
        return [self.__height, self.__width, self.__depth]

    @property
    def quant(self) -> int:
        return self.__quant

    @name.setter
    def name(self, name: str):
        if type(name) == str:
            self.__name = name
        else:
            self.__name = str(name)

    @price.setter
    def price(self, price: float):
        if type(price) == float or type(price) == int:
            if price >= 0.01:
                self.__price = price
            else:
                self.__price = 0.01
        else:
            print("Неверный тип данных!")

    @size.setter
    def size(self, size: "list[height:float, width:float, depth:float]"):
        height = size[0]
        width = size[1]
        depth = size[2]
        if type(height) == float or type(height) == int and type(width) == float or type(width) == int and type(
                depth) == float or type(depth) == int:
            if width > 0 and height > 0 and depth > 0:
                self.__height = height
                self.__width = width
                self.__depth = depth
            else:
                print("Только положительные значения!")
        else:
            print("Неверный тип данных!")

    @quant.setter
    def quant(self, quant: int):
        if type(quant) == int:
            if quant >= 0:
                self.__quant = quant
            else:
                print("Только неотрицательные значения!")
        else:
            print("Неверный тип данных!")

    def display_info(self) -> str:
        return f"Название: {self.__name}, Цена : {self.__price}, Коливество: {self.__quant}, Объем: " \
               f"{self.__depth * self.__height * self.__width} HWD:({self.__height}, {self.__width}, {self.__depth})"

    # вместимость коробки в подуктах не зависимо от их положения в них
    def quant_in_box(self, h_box: int, w_box: int, d_box: int) -> int:
        # вместимость коробки в подуктах с жестким положением
        def quant_in_box_accord(h_box: int, w_box: int, d_box: int) -> int:
            return int(h_box / self.__height) * int(w_box / self.__width) * int(d_box / self.__depth)

        if h_box > 0 and w_box > 0 and d_box > 0:
            res = []
            res.append(quant_in_box_accord(h_box, w_box, d_box))
            res.append(quant_in_box_accord(h_box, d_box, w_box))
            res.append(quant_in_box_accord(w_box, h_box, d_box))
            res.append(quant_in_box_accord(w_box, d_box, h_box))
            res.append(quant_in_box_accord(d_box, h_box, w_box))
            res.append(quant_in_box_accord(d_box, w_box, h_box))
            return max(res)
        else:
            print("Необходима коробка с положительными размерами")
            return 0

    # вычисление скидки
    def sale_counter(self, percent_sale: float) -> float:
        fin_price = float("{:.2f}".format(percent_sale / 100 * self.__price))
        if fin_price >= 0.01:
            return fin_price
        return 0.01

    def __add__(self, other):
        # если все кроме количества равны то возвр суммарное кол-во
        if self.__name == other.__name and self.__price == other.__price and self.__height == other.__height and \
                self.__width == other.__width and self.__depth == other.__depth:
            new_quant = self.__quant + other.__quant
            return Product(self.__name, self.__price, new_quant, self.__height, self.__width, self.__depth)
        return Product(self.__name, self.__price, self.__quant, self.__height, self.__width, self.__depth)

    # инициализация размеров
    def define_size(self):
        print("Размеры")
        self.__height = float_range("Высота: ", minvalue=0)
        self.__width = float_range("Ширина: ", minvalue=0)
        self.__depth = float_range("Глубина: ", minvalue=0)

    # интерфейс инициализации
    def define(self):
        print("Продукт")
        self.__name = input("Название: ")
        self.__price = float_range("Цена: ", minvalue=0.01)
        self.__quant = int_range("Количество: ", minvalue=0)
        n = input("Указать размеры? y/n: ")
        if n == "y":
            self.define_size()

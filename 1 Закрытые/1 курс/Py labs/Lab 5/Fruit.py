from Product import Product
from ValueCheck import float_range, int_range


class Fruit(Product):
    def __init__(self, name: str = "NotStated", price: float = 0, quant: int = 0, height: float = 0, width: float = 0,
                 depth: float = 0):
        Product.__init__(self, name, price, quant, height, width, depth)


from Product import Product
from Fish import Fish
from Fruit import Fruit
import copy


def main():
    product1 = Product()
    product1.define()
    print(product1.quant_in_box(7, 10, 9))
    product2 = copy.deepcopy(product1)
    product2.quant = 56
    print((product2 + product1).display_info())
    fruit = Fruit()
    fruit.define()
    fish = Fish()
    fish.define()
    product1.define_size()


if __name__ == "__main__":
    main()
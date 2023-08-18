from ValueCheck import int_range


def hofstadter_f_m(n):
    def M(n):
        if n == 0:
            return 0
        else:
            return n - F(M(n - 1))

    def F(n):
        if n == 0:
            return 1
        else:
            return n - M(F(n - 1))

    for i in range(0, n):
        yield F(i), M(i)


def main():
    n = int_range("Введите n: ", minvalue=1) - 1
    gen = hofstadter_f_m(n)
    for i in range(n):
        print(next(gen))
    return 0


if __name__ == "__main__":
    main()

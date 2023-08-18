from ValueCheck import int_range


def reducer(m: int, n: int):
    # m - числитель, n - знаменатель m<n
    buffm = m
    buffn = n
    while True:
        for i in range(1, m + 1):
            if m % i == 0 and n % i == 0:
                m = m // i
                n = n // i
        if buffn == n and buffm == m:
            return m, n
        else:
            buffm = m
            buffn = n


def main():
    numerator = int_range("Числитель: ", minvalue=1)
    denumerator = int_range("Знаменатель: ", minvalue=numerator)
    numerator, denumerator = reducer(numerator, denumerator)
    print(f"Числитель: {numerator}, Знаменатель: {denumerator}")
    return 0


if __name__ == "__main__":
    main()

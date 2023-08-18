from ValueCheck import int_range
from random import randint


def seq_find(sequence, seq_len):
    number = int_range("Введите искомое: ", minvalue=1)
    final = False
    for i in range(seq_len):
        start = i
        amount = 0
        for j in range(i, seq_len):
            amount += sequence[j]
            if amount > number:
                break
            if amount == number:
                final = j
                break
        if final:
            break
    if final:
        res = []
        for i in range(start, final):
            res.append(sequence[i])
        return res
    return False


def main():
    sequence = []
    seq_len = 20
    for i in range(0, seq_len):
        sequence.append(randint(1, 20))
    print(sequence)
    while True:
        new_seq = seq_find(sequence, seq_len)
        if new_seq:
            print(new_seq)
        else:
            print("False")
    return 0


main()

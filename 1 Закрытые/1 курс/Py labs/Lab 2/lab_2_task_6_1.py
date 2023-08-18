FILENAME_poem = "article_rus.txt"
FILENAME_results = "article_rus_solve.txt"

# подсчет букв из поэмы Медный всадник Пушкина
with open(FILENAME_poem, "r", encoding="utf-8") as file:
    counter = 0
    alphabet = {}
    for line in file:
        for letter in line:
            if letter.isalpha():
                counter += 1
                letter = letter.lower()
                try:
                    alphabet[letter] += 1
                except:
                    alphabet[letter] = 1

# Запись словаря в файл
with open(FILENAME_results, "w", encoding="utf-8") as file:
    keys = list(alphabet.keys())
    while True:
        keys = list(alphabet.keys())
        if len(keys) == 0:
            break
        max_count = 0
        for alpha in keys:
            if alphabet[alpha] > max_count:
                max_alpha = alpha
                max_count = alphabet[alpha]
        file.write(max_alpha + f": {round(max_count/counter, 4)}\n")
        alphabet.pop(max_alpha)


s = input("Введите строку: ")
x = input("Введите нежелательные символы: ")

for err in range(len(x)):
    s = s.replace(x[err].lower(), "")
    s = s.replace(x[err].upper(), "")
print("\nИтог: ", s)    

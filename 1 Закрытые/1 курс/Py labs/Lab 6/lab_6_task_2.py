from threading import Thread, Event

print("вариант " + str(8211812 % 5 + 1))


def main():
    event = Event()
    event.clear()

    def printing(sth: str):
        event.wait()
        print(f"Your value: {sth}")

    events = [Thread(target=printing, args=(f"value {i}",)) for i in range(5)]
    for e in events:
        e.start()
    print("start title")
    event.set()


main()
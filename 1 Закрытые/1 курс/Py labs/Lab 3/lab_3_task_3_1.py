from datetime import date


def nearest_date(*args):
    days = len(args)
    today = date.today()
    dates = [today, ]
    # Перевод в нормальный вид
    for i in args:
        day = list(map(int, i.split(".")))
        dates.append(date(day[2], day[1], day[0]))
    # Сортировка по датам по возрастанию
    for j in range(0, days):
        for k in range(0, days - j):
            if dates[k] > dates[k + 1]:
                dates[k], dates[k + 1] = dates[k + 1], dates[k]
    # Ищу индекс сегодня в списке
    today_id = 0
    for day in dates:
        if day == today:
            break
        today_id += 1
    # for day in dates:
    #    print(day)
    # Крайние случаи
    if today_id == 0:
        nearest = f"{dates[today_id + 1].day}.{dates[today_id + 1].month}.{dates[today_id + 1].year}"
        return nearest
    if today_id == days:
        nearest = f"{dates[today_id - 1].day}.{dates[today_id - 1].month}.{dates[today_id - 1].year}"
        return nearest
    # разница в датах
    future = dates[today_id + 1] - dates[today_id]
    past = dates[today_id] - dates[today_id - 1]

    if past <= future:
        nearest = f"{dates[today_id - 1].day}.{dates[today_id - 1].month}.{dates[today_id - 1].year}"
    elif future < past:
        nearest = f"{dates[today_id + 1].day}.{dates[today_id + 1].month}.{dates[today_id + 1].year}"
    return nearest


def main():
    nearest = nearest_date("12.10.2022", "10.10.2020", "1.12.2023", "9.1.2008")
    print(nearest)


if __name__ == "__main__":
    main()

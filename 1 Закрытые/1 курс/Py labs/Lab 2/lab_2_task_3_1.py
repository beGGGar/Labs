import csv

FILENAME_player = "players.csv"
FILENAME_res = "results.csv"

with open(FILENAME_player, 'r', newline="", encoding="utf8") as fplayers:
    reader = csv.DictReader(fplayers, delimiter=';')

    #чтение игроков
    players = []
    for row in reader:
        players.append(row)
    keys = list(players[0].keys())
    #сортировка по уменьшению побед
    for i in range(0, len(players)):
        for j in range(0, len(players)-1):
            #сравнение побед
            if int(players[j][keys[1]]) < int(players[j+1][keys[1]]):
                players[j], players[j+1] = players[j+1], players[j]
            #Сравнение доб очков при равных победах
            if players[j][keys[1]] == players[j+1][keys[1]]:
                if int(players[j][keys[2]]) < int(players[j+1][keys[2]]):
                    players[j], players[j + 1] = players[j + 1], players[j]
    results = []
    number = 1
    results.append({keys[0]:players[0][keys[0]], 'Место':number})
    for i in range(1, len(players)):
        #одинаковые места для одинаковых результатов
        if players[i][keys[1]] == players[i-1][keys[1]] and int(players[i][keys[2]]) == int(players[i-1][keys[2]]):
            results.append({keys[0]: players[i][keys[0]], 'Место': number})
        else:
            number+=1
            results.append({keys[0]: players[i][keys[0]], 'Место': number})

keys = results[0].keys()
with open(FILENAME_res, 'w', newline="", encoding="utf8") as fres:
    writer = csv.DictWriter(fres, keys, delimiter=';')
    writer.writeheader()
    writer.writerows(results)

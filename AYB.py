INF = 1000000000

def AYB(path, closed):
    for k in range(1, p + 1):
        if closed[k]:
            continue
        for i in range(1, p + 1):
            if closed[i]:
                continue
            for j in range(1, p + 1):
                if closed[j]:
                    continue
                path[i][j] = min(path[i][k] + path[k][j], path[i][j])

while True:
    try:
        p, r, bh, of, yh, m = map(int, input().split())
    except EOFError:
        break

    if p == 0:
        break

    boss = [[INF for _ in range(105)] for _ in range(105)]
    me = [[INF for _ in range(105)] for _ in range(105)]
    closed = [0] * 105

    for i in range(1, p + 1):
        boss[i][i] = me[i][i] = 0

    for _ in range(r):
        p1, p2, d = map(int, input().split())
        boss[p1][p2] = boss[p2][p1] = me[p1][p2] = me[p2][p1] = d

    AYB(boss, closed)

    for i in range(1, p + 1):
        if boss[bh][of] == boss[bh][i] + boss[i][of]:
            closed[i] = True

    if closed[yh] or closed[m]:
        print("MISSION IMPOSSIBLE.")
        continue

    AYB(me, closed)
    ans = me[yh][m]

    if ans == INF:
        print("MISSION IMPOSSIBLE.")
    else:
        print(ans)

while True:
    N, n = map(int, input().split())
    if N == 0 and n == 0:
        break

    firstsquare = [input() for _ in range(N)]
    secondsquare = [input() for _ in range(n)]

    counts = [0, 0, 0, 0]  # Initialize counts for each rotation

    for _ in range(4):
        for i in range(N - n + 1):
            for j in range(N - n + 1):
                found = True
                for x in range(n):
                    for y in range(n):
                        if firstsquare[i + x][j + y] != secondsquare[x][y]:
                            found = False
                            break
                    if not found:
                        break
                if found:
                    counts[_] += 1
        secondsquare = list(zip(*reversed(secondsquare)))

    print(*counts)

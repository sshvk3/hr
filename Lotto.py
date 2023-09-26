while True:
    # Read input
    line = input().strip()
    if line == '0':
        break
    k, *S = map(int, line.split())

    # Generate all possible games
    games = []
    for i in range(2 ** k):
        game = []
        for j in range(k):
            if i & (1 << j):
                game.append(S[j])
        if len(game) == 6:
            games.append(game)

    # Print output
    for game in sorted(games):
        print(*game)
    print()

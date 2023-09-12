def find_max_rank_urls(urls, ranks):
    max_rank = max(ranks)
    max_rank_urls = [urls[i] for i in range(len(ranks)) if ranks[i] == max_rank]
    return max_rank_urls

num_sets = int(input())
sets = []

for i in range(num_sets):
    urls = []
    ranks = []

    for j in range(10):
        line = input().split()
        urlkey = line[0]
        rankvalue = int(line[1])
        urls.append(urlkey)
        ranks.append(rankvalue)

    max_rank_urls = find_max_rank_urls(urls, ranks)
    sets.append(max_rank_urls)

for i, max_rank_urls in enumerate(sets):
    print(f"Case #{i+1}:")
    for url in max_rank_urls:
        print(url)

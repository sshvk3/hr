
from sys import stdin, stdout

def binSearch(lst, sz, val):
    s, t = 0, sz-1

    while s <= t:
        mid = (s + t) // 2
        lst_mid = lst[mid]

        if lst_mid == val:
            return mid-1, mid+1
        if lst_mid < val:
            s = mid + 1
        else:
            t = mid - 1
    
    return t, s

def main():
    # stdin = open('input.txt', 'r')

    stdin.readline()

    mp = map(int, stdin.readline().split())

    chipmunks = []
    last = -1

    for i in mp:
        if i != last:
            chipmunks.append(i)    # Keeps only the unique elements.
            last = i

    stdin.readline()

    queries = map(int, stdin.readline().split())

    sz = len(chipmunks)
    result = []

    for q in queries:
        a, b = binSearch(chipmunks, sz, q)

        result.append(str(chipmunks[a]) if a >= 0 else 'X')
        result.append(' ')
        result.append(str(chipmunks[b]) if b < sz else 'X')
        result.append('\n')

    stdout.write(''.join(result))

if __name__ == '__main__':
    main()
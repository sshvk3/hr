def main():
    while True:
        n, m = map(int, input().split())
        if n == 0 and m == 0:
            break

        suspects = [0] * n
        suspects[0] = 1

        gmp = {}

        groups = []
        for _ in range(m):
            g_data = list(map(int, input().split()))
            groups.append(g_data)

        group_id = 0  # Initialize the group_id
        for group_members in groups:
            for student in group_members[1:]:
                if student not in gmp:
                    gmp[student] = []
                gmp[student].append(group_id)
            group_id += 1  # Increment the group_id

        queue = [0]

        while queue:
            student = queue.pop(0)
            for group_id in gmp.get(student, []):
                for group_member in groups[group_id][1:]:
                    if suspects[group_member] == 0:
                        suspects[group_member] = 1
                        queue.append(group_member)

        result = sum(suspects)
        print(result)

if __name__ == "__main__":
    main()

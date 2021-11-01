#Uses python3

import sys

def explore(edges, vertex, visited, stack, dag):
    visited[vertex] = True
    stack.append(vertex)
    for v in edges[vertex]:
        if v in stack:
            dag[0] = False
        if not visited[v]:
            explore(edges, v, visited, stack, dag)
    stack.pop()

def is_DAG(edges, visited, n):
    dag = [True]
    stack = []
    for i in range(1, n + 1):
        if not visited[i]:
            explore(edges, i, visited, stack, dag)
            if not dag[0]:
                return False
    return True


if __name__ == '__main__':
    n, m = map(int, input().split())
    edges = [[] for _ in range(n + 1)]
    for i in range(m):
        a, b = map(int, input().split())
        edges[a].append(b)
    visited = [False] * (n + 1)
    check = is_DAG(edges, visited, n)
    if check:
        print(0)
    else:
        print(1)

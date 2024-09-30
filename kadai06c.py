#kadai06c
import networkx as nx
n = int(input())
L = []
for _ in range(n):
    L.append(input())
G = nx.Graph()
G = nx.parse_adjlist(L, nodetype = int)
while True:
    flag = True
    for i in list(G):
        if G.degree(i) == 0 or G.degree(i) == 1:
            G.remove_node(i)
            flag = False
        if flag:
            break
print(len(G.nodes()))
print(len(G.edges()))

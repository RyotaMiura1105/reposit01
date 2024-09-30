#kadai06b
import networkx as nx
G = nx.Graph()
ver = int(input())
ed = int(input())
J = []
L = [0]
M = [0]
for n in range(ed):
    J.append(input())
G = nx.parse_edgelist(J, nodetype = int)
G.add_nodes_from([i for i in range(ver)])
for _ in range(1,ver):
    M.append(-1)
i = 1
while len(L) != 0:
    a = L.pop(0)
    for n in nx.all_neighbors(G,a):
        b = n
        if M[b] == -1:
            L.append(b)
            M[b] = i
            i += 1
print(*M)


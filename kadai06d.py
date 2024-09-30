#kadai06d
import networkx as nx
from operator import itemgetter
n = int(input())
m = int(input())
l = []
sum = 0
for _ in range(m):
    l.append([int(i) for i in input().split()])
l.sort(key = itemgetter(2))
t = nx.Graph(nodetype = int)
t.add_nodes_from([i for i in range(n)])
for i in range(m):
    if(nx.has_path(t, l[i][0], l[i][1])) == False:
        t.add_edge(l[i][0], l[i][1])
        sum += l[i][2]
print(sum)
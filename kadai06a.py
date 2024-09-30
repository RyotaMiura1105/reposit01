#kadai06a
import networkx as nx
G = nx.DiGraph()
G.add_nodes_from([0,1,2,3,4,5,6,7,8,9])
G.add_edges_from([(0,1),(1,2),(2,0),(2,3),(2,5),(3,1),(3,6),(4,2),(4,3),(5,0),(6,3),(6,7),(6,8),(7,6),(8,4),(9,5)])
s = int(input())
e = int(input())
all = nx.all_simple_paths(G, source = s, target = e)
for path in all:
    print(path)
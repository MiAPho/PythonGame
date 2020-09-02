import pprint
W=10
H=10
data=list()
for i in range(H):
	temp=list()
	for j in range(W):
		temp.append(0)
	data.append(temp)
pprint.pprint(data)

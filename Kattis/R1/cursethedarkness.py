ii = int(input())
for i in range(ii):
	b = [float(i) for i in input().split(" ")]
	tt = int(input())
	light = False
	for t in range(tt):
		c = [float(k) for k in input().split(" ")]
		if (c[0] - b[0])**2 + (c[1] - b[1])**2 < 64:
			light = True
	if light:
		print("light a candle")
	else:
		print("curse the darkness")
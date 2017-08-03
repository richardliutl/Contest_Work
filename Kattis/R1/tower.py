a = [int(i) for i in input().split(" ")]
h = a[:-2]
t = a[-2:]
done = False
for i in range(4):
	for j in range(i+1,5):
		for k in range(j+1,6):
			s = h[i] + h[j] + h[k]
			if s == t[0]:
				tempp = [n for n in reversed(sorted([h[i],h[j],h[k]]))]
				h.remove(tempp[0])
				h.remove(tempp[1])
				h.remove(tempp[2])
				temppp = [n for n in reversed(sorted(h))]
				print(" ".join(str(k) for k in tempp + temppp))
				done = True
				break;
			elif s == t[1]:
				tempp = [n for n in reversed(sorted([h[i],h[j],h[k]]))]
				h.remove(tempp[0])
				h.remove(tempp[1])
				h.remove(tempp[2])
				temppp = [n for n in reversed(sorted(h))]
				print(" ".join(str(k) for k in temppp + tempp))
				done = True
				break;
		if done:
			break;
	if done:
		break;
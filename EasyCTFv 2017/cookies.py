import binascii
str1 = b"53514c69746520666f726d6174203300"
str2 = b"2dedd20d7ff800037dc9007e417fc17dc9"
print(binascii.unhexlify(str1))
print(binascii.unhexlify(str2))
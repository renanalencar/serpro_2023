def ordenacao(numeros):
    for x in range(len(numeros)):
        for y in range(len(numeros)-1):
            if numeros[y] > numeros[y+1]:
                temp = numeros[y]
                numeros[y] = numeros[y+1]
                numeros[y+1] = temp
    return numeros

numeros = [5, 1, 4, 2, 8]
print("Lista Desordenada: ")
print(numeros)
print("Lista Ordenada:\n" + str(ordenacao(numeros)))
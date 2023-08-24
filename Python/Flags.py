import time

cuenta1 = 0
cuenta2 = 50
cuenta3 = 0
SIGNAL = False
WAIT = False

cuenta1 = 0
def contador1():
  global cuenta1
  cuenta1+=2

cuenta2 = 50
def contador2():
  global cuenta2
  cuenta2-=2

cuenta3 = 0
def contador3():
  global cuenta3
  cuenta3+=2

for x in range(5):

    if(SIGNAL == False):

        SIGNAL = True
        WAIT = False
        print("\n\nActivando Contador Incremental. Status SIGNAL.\nDesactivando Contador Decremental. Status WAIT.\nDesactivando Multiplicador Base 2. Status WAIT.\n")

        for i in range(5):
            contador1()
            print(cuenta1, end = " ")
            time.sleep(2)
        SIGNAL = False
        WAIT = True

        print("\n\nActivando Contador Decremental. Status SIGNAL.\nDesactivando Contador Incremental. Status WAIT.\nDesactivando Multiplicador Base 2. Status WAIT.\n") 

        for i in range(5):
            contador2()
            print(cuenta2, end = " ")
            time.sleep(2)
        SIGNAL = True
        WAIT = False

        print("\n\nActivando Multiplicador Base 2. Status SIGNAL.\nDesactivando Contador Incremental. Status WAIT.\nDesactivando Contador Decremental. Status WAIT.\n") 

        for i in range(6):
            contador3()
            print(cuenta3, end = " ")
            time.sleep(2)
        SIGNAL = False
        WAIT = True

print("\n\nProceso de Contador Incremental finalizado. Status: WAIT.\nProceso de Contador Decremental finalizado. Status: WAIT.\nProceso de Multiplicador Base 2 finalizado. Status: WAIT.\n") 
from time import sleep
class segmentacion:
    def __init__(self):
        self.seg=[]
        self.tamMermoria=[100,200,300,400,500]
        self.MemoriaBase=[1000,2000,500,700,4000]
        self.fragmentacionFisica=0
        self.memoriatotal=0
#imprime tamMemoria y MemoriaBase como una tabla para que el usuario vea
    def tabular(self):
        for i in range(5):
            print("     Registro      Limite     Base")
            print("segmento #",i+1,"---->",self.tamMermoria[i],"--->",self.MemoriaBase[i])
            sleep(1)
#aqui comparamos la segmentacion (seg[]) con el tamaño de memoria (tamMemoria)
    def asignacion(self):
        for i in range(5):
            self.memoriatotal=self.memoriatotal+self.tamMermoria[i]
#que segmento se asigna
            print("Segmento con valor =",self.seg[i])
#que segmento con que tamaño de memoria se compara
            print("Comparando segmento con registro limite ",self.seg[i],"<",self.tamMermoria[i])
#si es menor el segmento  se resta
            if(self.seg[i]<=self.tamMermoria[i]):
                print("\n Segmento asignado a memoria fisica")
#guardamos cuanto quedo de la resta
                Residuo=self.tamMermoria[i]-self.seg[i]
                print("fragmentacion externa= ",Residuo)
#se suma a la fragmentacion
                self.fragmentacionFisica=self.fragmentacionFisica+Residuo
#aqui solo sumo para saber el total

                print("------------------------------------------------")
                sleep(2)
#si no es menor se bloquea
            else:
                print("error en el direccionamiento del segmento a la memoria")
                print("-->         BLOQUEANDO ACCESO A LA MEMORIA         <--")
                print("------------------------------------------------------")
                self.fragmentacionFisica=self.fragmentacionFisica+self.tamMermoria[i]
                sleep(2)
#Solo imprime la cantidad de memoria total y la fragmentada(resta del metodo asignacion)
    def MemoriaEXterna(self):
        print("------------------------------------------------------")
        
        print(" \n La Fragmentacion total es =",self.fragmentacionFisica)
        print("la anterior memoria es =",self.memoriatotal)
#pedimos los tamaños de los segmentos con un total de 5 que coinciden con la memoria del constructor MemoriaBase y tamMemoria
#se añaden a seg[]
    def CrearSeg(self):
        print("------------------------------")
        print("tenemos 5 Espacios de memoria")
        print("------------------------------")
        for i in range(5):
            dato=int(input("ingrese valor del segmento \n"))
            self.seg.append(dato)
 #verifico si coinciden los tamaños, en realidad no hace nada ajjaj
    def verificar(self):
        if(len(self.seg)>5):
            print("no ingreso correctamente los datos")
            self.seg=[]
            self.CrearSeg()
        elif(len(self.seg)==5):
            return 
        else:
            print("ingreso correctamente los datos")
            return self.seg
    def metodos(self):
        B.tabular()
        B.CrearSeg()
        B.verificar()
        B.asignacion()
        B.MemoriaEXterna()
B=segmentacion()
B.metodos()

# Instituto Tecnológico de Mérida. Campus Poniente
# Ingeniería en Sistemas Computacionales
# Sistemas Operativos
# Realizado por:
# Gutiérrez Alonso, Alejandro
# Uicab Cetz, Luisa Alejandra
# Sarricolea Veyro, Jorge 
# Uicab Espinoza, Martin Antonio

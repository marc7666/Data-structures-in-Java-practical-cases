# Lab2_EEDD

## Apartat 1a

### equals de la classe Person:

En primer lloc, es comprova si 'this' i 'o' referencien el mateix objecte, en cas que sí, òbviament, es retorna true. En
segon lloc, es realitzen dues comprovacions diferents. La primera comprova si la referència 'o' apunta a null. La segona,
comprova si els objectes referenciats per 'this' i 'o' son de classes diferents. En el cas que la referència 'o' apunti a null
o els objectes pertanyin a classes diferents, es retronarà false. Seguidament, es defineix una nova referència que
apunta al mateix objecte referenciat per 'o'. A aquesta nova referència se li assigna el tipus 'Person'. Finalment, retornem
una crida al mètode estàtic 'equals' de la classe 'Objects'. El comportament d’aquest mètode és pot desglossar en 4 casos
diferents:

1) Si els dos arguments son iguals entre si, es retorna true.
2) Si els dos arguments son diferents entre si, es retorna false.
3) Si els dos arguments son referències que apunten a null, es retorna true.
4) En cas que el primer argument no sigui una referència que apunta a null, s’invoca al mètode equals de la classe
   Object, que retorna true si i nomes si ambdós arguments fan referència al mateix objecte.

### equals de la classe Employee:

En la subclasse Employee, les dues primeres línies son les mateixes que en el mètode de la superclasse. És a dir, es
comprova si 'this' i 'o' referencien el mateix objecte i es comprova si 'o' és una referència que apunta a 'null' o si els
objectes referenciats per 'this' i 'o' pertanyen a classes diferents. En la tercera línia es troba la diferència principal
entre els dos mètodes 'equals'. En aquesta línia, s’invoca al mètode 'equals' de la superclasse (Person) sobre l’objecte
receptor, passant com a paràmetre la referència 'o'. Seguidament, es defineix una nova referència del tipus 'Employee', que
apuntarà al mateix objecte referenciat per 'o'. Finalment, es retorna cert si i només si el salari (this) es igual al
salari de la nova referència que s’acaba de crear.

### Test:

El test notInteroperable passa de manera correcta, atès que s’està realitzant una comparació de dos objectes diferents.
És a dir, s’està comparant una persona amb un empleat i, en el segon test, un empleat amb una persona. El mètode
assertNotEquals, comprova si els objectes son diferents. Expressant amb llenguatge natural, el primer test: estem
comparant una persona amb un empleat, però aquesta persona podria no ser un empleat.

## Apartat 1b

### equals de la classe Person:

Primerament, igual que en l'apartat anterior, es comporova si l'objecte referenciat per 'this' i l'objecte referenciat per 'o' son el mateix. En cas afirmatiu es retorna true, òbviament. Seguidament, es comprova si l'objecte referenciat per 'o' és una instància de 'Person' o d'alguna de les seves subclasses. En cas de no complir aquesta condició, es retorna false. A continuació, es crea una nova referència de tipus 'Person', aquesta apuntarà al mateix objecte refrenciat per 'o'. Finalment, es retorna una crida al mètode 'equals' de la classe 'Objects', el comportament del qual ja ha estat definit anteriorment.

### equals de la classe Employee:

En aquesta ocasió, les dues primeres línies són les mateixes que en la superclasse (comprovar si ambdues referències apunten al mateix objecte i comprovació de instanceof). Seguidament, s'invoca al mètode 'equals' de la superclasse 'Person', passant com a paràmetre l'objecte referenciat per 'o'. En cas que aquest mètode retorni fals, es retonarà fals com a resultat del mètode de la subclasse. A continuació, es crea una nova referència del tipus 'Employee' que apuntarà al mateix objecte que la referència 'o' i finalment, es retorna vertader si i només si els dos salaris (el del 'this' i el de la nova referència) son iguals.

### Test:

Els jocs de proves són els mateixos que en l'apartat anterior a excepció del mètode 'notInteroperable' que s'ha vist modificat a causa de l'acceptació de subclasses com a paràmetre del mètode 'equals'. Com s'especifica en l'informe, amb aquesta modificació és pot comparar una persona amb un empleat, però no es pot comparar un empleat amb una persona. Per tant, el mètode 'equals', tal i com està codificat en aquest apartat, és semi-interoperable.

## Apartat 1c

En la classe 'Employee', s'han realitzat un total de 3 canvis:

1) S'ha realitzat un canvi en l'operador 'instanceof'. En comptes de comprovar que 'o' sigui una instància de 'Employee' o quelcom inferior (cosa imopssible), ara es comprova que 'o' sigui una instància de 'Person' o inferior. Aquest canvi s'ha realitzar per poder realitzar la comparació empleat - persona, atès que 'Employee' no té sublcasses, i per tant sense aquest canvi el test fallaría.
2) Donat el canvi anterior, no es pot crear una referència de tipus 'Employee', s'ha de crear una referència de tipus 'Person'. Aquesta referència apuntarà al mateix objecte que 'o'.
3) Es retorna una crida al mètode 'equals' a nivell de nom. Per tant, es retornarà vertader si i només si els noms són iguals.

Un cop efectuats aquests canvis, el test 'interoperable' que proporciona l'enunciat, passa correctament.

També és demana que es realitzi un joc de proves que demostri la pèrdua de la transitivitat. Per tant, saben que aquesta propietat afirma que: ∀𝒙,𝒚,𝒛 ∈𝑨:𝒙𝑹𝒚 𝒊 𝒚𝑹𝒛 →𝒙𝑹𝒛 s'ha de trobar un exemple en que 'x' no estigui relacionat amb 'z'. Per tant, el que s'ha fet és crear dos empleats i una persona i comprovar que quan es comparen (a nivell de nom) el primer empleat amb la persona i el segon empleat amb la persona, es compleix que el primer empleat està relacionat amb la persona. En canvi, quan realitzem la comparació dels empleats a nivell de salari, es pot comprovar que, encara que ambdós empleats tinguin el mateix nom, tenen un salari diferent, per tant, no es tracta del mateix empleat. És per aquesta raó, que s'ha afegit el mètode 'getSalary()'.

## Exercici 2

El mètode 'removeIf()', té un disseny força senzill. En primer lloc, es declara un bucle de tipus 'while' que donarà voltes mentre el iterador tingui element següent, és a dir, donarà voltes mentre l'operació 'hasNext()' retorni 'true'. Dins d'aquest bucle, Es defineix una nova referència de tipus 'E' que apuntarà al valor que retorni l'operació 'next()'. La condició del bucle és la manera d'assegurar-se que el programa no intentarà fer una operació 'next()' quan l'iterador no pugui avançcar més. Seguidament, es comprova si el mètode test (el de l'interfície), retorna cert o fals. En cas de retornar cert, és a dir, compleix la condició, s'eliminarà aquell element de la llista, atès que compleix la condició especificada.

### Test:

En la classe de tests, s'implementa el mètode de l'interfície. En cada test s'implementa mitjançant una tècnica diferent.

En el primer test, s'implementa mitjançant una classe local. En el segon test, mitjançant una classe anònima i en el tercer mitjançant una funció lambda

## Exercici 3

La primera part de l'exercici, consisteix en implementar el mètode 'compareTo()' en la classe 'Person'. La implementarció d'aquest mètode és ben senzilla, atès que només s'ha de retornar una crida al mètode 'compareToIgnoreCase()' amb el 'this.name' com a cadena que crida al mètode i el 'o.name' com a cadena paràmetre. El comportament del 'compareToIgnoreCase()' es divideix en:

1) Retorna un valor < 0 si la cadena que crida al mètode va primer, lexicogràficament.
2) Retorna 0 si les dues són lexicogràficament equivalents.
3) Retorna un valor > 0 si la cadena paràmetre va primer, lexicogràficament.

La segona part de l'exercici, consisteic en realitzar una classe de testing per comprovar el correcte funcionament de la implementació anterior.

La segona part de l’exercici, consisteix en la realització d’una classe de tests que comprovi que la correcta comparació entre noms independentment de les lletres majúscules i minúscules. Aquesta classe, en aquest cas, consta d’una totalitat de 3 tests diferents; El primer dels quals, realitza la comparació entre elements de la classe Person; el segon dels quals, compara elements de la classe Employee i el tercer i últim test, realitza comparacions mixtes, és a dir, realitza comparacions entre empleats i persones.

La tercera i última part d’aquest darrer exercici, consisteix en implementar una classe que contingui un mètode que realitzi la tasca descrita en l’enunciat de la pràctica. Com s’observa en el joc de proves proporcionat en l’enunciat, la classe s’anomena Comparisons i el mètode removeLower.

### Test:

En el cas del primer test, es passa al mètode un iterador de una llista de empleats (List<Employee>) i una referència tipus Person. Gràcies al comodí, es pot jugar amb el nivell de la herència. En aquest cas E = Person. Atès que E es situa amunt, no hi ha cap problema en realitzar la comparació Persona – Empleat.
  
En el cas del segon test, es passa al mètode una llista de persones i la referència es un empleat. Atesa la relació d’herència; un empleat és una persona, es pot executar el mètode de manera correcta. En aquest cas E = Person, encara que la referència sigui un empleat. Ja s’ha esmentat que degut al comodí es pot jugar amb el nivell de la herència i situar el tipus E en el nivell de la herència mes convenient. Per tant, com E es situa amunt, no hi ha cap problema en comparar una persona amb un empleat.
   
En el cas del tercer test, E = Employee, atès que en ningun moment s’ha de jugar amb el nivell de la herència ja que tant la llista com la referència són empleats. Atès que Employee és subclasse de alguna cosa comparable amb ell mateix o superior i l’iterador compleix la condició <? extends E>, el test passa de manera correcta.

Finalment, esmentar que s’ha afegit un test addicional, en el qual E = Person atès que tant la llista com la referència son persones. La justificació de perquè passa de manera correcta es la mateix que en el cas anterior.
